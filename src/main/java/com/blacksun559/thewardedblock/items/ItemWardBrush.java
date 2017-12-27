package com.blacksun559.thewardedblock.items;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.items.Base.ItemTWB;
import com.blacksun559.thewardedblock.tileentity.TileEntityWard;
import com.blacksun559.thewardedblock.util.PlayerUtils;
import com.blacksun559.thewardedblock.util.WardType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemWardBrush extends ItemTWB
{
    private final int MESSAGE_SET = TheWardedBlock.getMessageID();
    private final int MESSAGE_PLACE = TheWardedBlock.getMessageID();
    private final int MESSAGE_WARD_TYPE = TheWardedBlock.getMessageID();

    public ItemWardBrush(String name)
    {
        super(name);
        this.setMaxDamage(250);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            NBTTagCompound nbt = player.getHeldItem(hand).getTagCompound();
            final String key = "wardTWB";
            int ward = 0;
            IBlockState stateAt = world.getBlockState(pos);
            Block blockAt = stateAt.getBlock();

            if(nbt == null)
            {
                nbt = new NBTTagCompound();
            }
            else
            {
                ward = nbt.getInteger(key);
            }

            if(!player.isSneaking())
            {
                System.out.println(blockAt);

                if(blockAt == ModBlocks.BLOCK_WARD)
                {
                    System.out.println("add");

                    final TileEntityWard wards = (TileEntityWard) world.getTileEntity(pos);

                    wards.addWard(ward);

                    PlayerUtils.messageOnce(MESSAGE_SET, new TextComponentTranslation("Added ward " + WardType.WardNames.values()[ward]));
                }
                else if(!blockAt.isAir(stateAt, world, pos) && (stateAt.isOpaqueCube() || stateAt.getRenderType() == EnumBlockRenderType.MODEL))
                {
                    IBlockState state = ModBlocks.BLOCK_WARD.getDefaultState();
                    ItemStack stack = new ItemStack(ModBlocks.BLOCK_WARD);

                    world.playEvent(2001, pos, Block.getStateId(state));
                    world.setBlockState(pos, state, 1 | 2);
                    state.getBlock().onBlockPlacedBy(world, pos, state, player, stack);

                    TileEntityWard warded = (TileEntityWard) world.getTileEntity(pos);

                    warded.addWard(ward);

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

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
