package com.blacksun559.thewardedblock.items;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.blocks.ward.BlockWard;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.items.Base.ItemTWB;
import com.blacksun559.thewardedblock.tileentity.TileEntityWard;
import com.blacksun559.thewardedblock.util.PlayerUtils;
import com.blacksun559.thewardedblock.util.WardType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IExtendedBlockState;

public class ItemWardBrush extends ItemTWB
{
    private final int MESSAGE_SET = TheWardedBlock.getMessageID();
    private final int MESSAGE_PLACE = TheWardedBlock.getMessageID();
    private final int MESSAGE_WARD_TYPE = TheWardedBlock.getMessageID();

    public ItemWardBrush(String name)
    {
        super(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            NBTTagCompound nbt = player.getHeldItem(hand).getTagCompound();
            final String key = "wardTWB";
            IBlockState stateAt = world.getBlockState(pos);
            Block blockAt = stateAt.getBlock();

            int ward = nbt.getInteger(key);

            if(!player.isSneaking())
            {
                if(blockAt == ModBlocks.BLOCK_WARD)
                {
                    final TileEntityWard wards = (TileEntityWard) world.getTileEntity(pos);

                    wards.addWard(ward);

                    PlayerUtils.messageOnce(MESSAGE_SET, new TextComponentTranslation("Added ward " + WardType.WardNames.values()[ward]));
                }
                else if(!blockAt.isAir(stateAt, world, pos) && stateAt.isOpaqueCube() && blockAt != Blocks.GRASS)
                {
                    IExtendedBlockState state = (IExtendedBlockState) ModBlocks.BLOCK_WARD.getDefaultState();

                    state = state.withProperty(BlockWard.SOURCE_BLOCK, stateAt);
                    ItemStack stack = new ItemStack(state.getBlock());

                    world.playEvent(2001, pos, Block.getStateId(state));
                    world.setBlockState(pos, state, 1 | 2);
                    state.getBlock().onBlockPlacedBy(world, pos, state, player, stack);

                    TileEntityWard warded = (TileEntityWard) world.getTileEntity(pos);
                    warded.setSourceBlock(blockAt);
                    warded.setSourceMeta(blockAt.getMetaFromState(stateAt));
                    warded.addWard(ward);
                    warded.syncUpdates();


                    PlayerUtils.messageOnce(MESSAGE_PLACE, new TextComponentTranslation("Added ward " + WardType.WardNames.values()[ward]));
                }
            }
        }

        return EnumActionResult.SUCCESS;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if(!world.isRemote)
        {
            ItemStack stack = player.getHeldItem(hand);
            NBTTagCompound nbt = stack.getTagCompound();
            String key = "wardTWB";
            if(nbt == null)
            {
                nbt = new NBTTagCompound();
            }

            if(nbt.hasKey(key))
            {
                int ward = nbt.getInteger(key);

                if(player.isSneaking())
                {
                    if(ward < WardType.WardNames.values().length - 1)
                    {
                        nbt.setInteger(key, ward + 1);
                    }
                    else
                    {
                        nbt.setInteger(key, 0);
                    }
                }
                PlayerUtils.messageOnce(MESSAGE_WARD_TYPE, new TextComponentString("Ward: " + WardType.WardNames.values()[nbt.getInteger(key)]));
            }
            else if(!nbt.hasKey(key))
            {
                nbt.setInteger(key, 0);
                PlayerUtils.messageOnce(MESSAGE_WARD_TYPE, new TextComponentString("Ward: " + WardType.WardNames.values()[nbt.getInteger(key)]));
            }

            stack.setTagCompound(nbt);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
