package com.blacksun559.thewardedblock.blocks.ward;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.blocks.base.BlockTWB;
import com.blacksun559.thewardedblock.blocks.properties.UnlistedPropertySourceBlock;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.tileentity.TileEntityWard;
import com.blacksun559.thewardedblock.util.PlayerUtils;
import com.blacksun559.thewardedblock.util.interfaces.IWardBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

import javax.annotation.Nullable;

public class BlockWard extends BlockTWB implements ITileEntityProvider, IWardBlock
{
    private final int MESSAGE_CLEAR = TheWardedBlock.getMessageID();
    private final int MESSAGE_DEBUG = TheWardedBlock.getMessageID();
    public static final UnlistedPropertySourceBlock SOURCE_BLOCK = new UnlistedPropertySourceBlock();

    public BlockWard(String name)
    {
        super(name, Material.ROCK);
        this.setCreativeTab((CreativeTabs) null);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityWard();
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return true;
    }

    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        IProperty[] listedProperties = new IProperty[0];
        IUnlistedProperty[] unlistedProperties = new IUnlistedProperty[]{SOURCE_BLOCK};
        return new ExtendedBlockState(this, listedProperties, unlistedProperties);
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        IExtendedBlockState value = null;

        if(state instanceof IExtendedBlockState)
        {
            value = (IExtendedBlockState) state;
            TileEntityWard warded = (TileEntityWard) world.getTileEntity(pos);
            IBlockState source = warded.getSourceBlock().getStateFromMeta(warded.getSourceMeta());
            value = value.withProperty(SOURCE_BLOCK, source);
        }

        return value != null ? value : state;
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state;
    }

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
                else
                {
                    PlayerUtils.messageOnce(MESSAGE_DEBUG, new TextComponentTranslation("Source: " + tileEntity.getSourceBlock() + "\nMeta: " + tileEntity.getSourceMeta()));
                }

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
