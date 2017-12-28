package com.blacksun559.thewardedblock.blocks;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.tileentity.TileEntityWard;
import com.blacksun559.thewardedblock.util.PlayerUtils;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockWard extends BlockTWB implements ITileEntityProvider
{
    private final int MESSAGE_CLEAR = TheWardedBlock.getMessageID();
    private final int MESSAGE_GET = TheWardedBlock.getMessageID();
    private final int MESSAGE_NONE = TheWardedBlock.getMessageID();


    public BlockWard(String name)
    {
        super(name, Material.ROCK);
    }

//    @Nullable
//    @Override
//    public TileEntity createTileEntity(World world, IBlockState state)
//    {
//        return new TileEntityWard();
//    }


    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        this.placeBarrier(world, pos);
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity)
    {
        if(world.getBlockState(pos.up()).getBlock() != ModBlocks.BLOCK_BARRIER)
        {
            System.out.println("spawning");
            this.placeBarrier(world, pos);
        }

        super.onEntityWalk(world, pos, entity);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityWard();
    }

    public TileEntityWard getTileEntity(World world, BlockPos pos)
    {
        return (TileEntityWard) world.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        boolean notBrush = false;

        if(!world.isRemote)
        {
            TileEntityWard tileEntity = this.getTileEntity(world, pos);

            if(player.getHeldItem(hand).getItem() != ModItems.WARD_BRUSH)
            {
                if(player.isSneaking())
                {
                    PlayerUtils.messageOnce(MESSAGE_CLEAR, new TextComponentTranslation("Clearing wards."));
                    tileEntity.clearWards();
                }
//                else if(tileEntity.getWards().size() > 0)
//                {
//                    PlayerUtils.messageOnce(MESSAGE_GET, new TextComponentTranslation("Block has ward " + WardType.WardNames.values()[tileEntity.getWards().get(0)] + "."));
//                }
//                else
//                {
//                    PlayerUtils.messageOnce(MESSAGE_NONE, new TextComponentTranslation("No wards."));
//                }

                notBrush = true;
            }
        }

        return notBrush;
    }

    private void placeBarrier(World world, BlockPos pos)
    {
        int i = 1;
        while(i < 4)
        {
            if(world.isAirBlock(pos.up(i)))
            {
                world.setBlockState(pos.up(i), ModBlocks.BLOCK_BARRIER.getDefaultState());
                i++;
            }
            else
            {
                i = 4;
            }
        }
    }
}
