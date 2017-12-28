package com.blacksun559.thewardedblock.blocks;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.materials.MaterialBarrier;
import com.blacksun559.thewardedblock.tileentity.TileEntityWard;
import com.blacksun559.thewardedblock.util.WardType;
import com.blacksun559.thewardedblock.util.interfaces.IModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockBarrier extends Block implements IModel
{
    public static final Material barrier = new MaterialBarrier();

    public BlockBarrier(String name)
    {
        super(barrier);
        this.setCreativeTab((CreativeTabs)null);
        this.setHardness(0);
        this.setBlockUnbreakable();
        this.setRegistryName(name);
        this.setUnlocalizedName(this.getRegistryName().toString());

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Items.AIR);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemById(0);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
        return new AxisAlignedBB(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
    {
        if(!world.isRemote && entity != null)
        {
            int wardPos = 1;
            boolean validWard = false;
            TileEntityWard ward = null;

            while(wardPos < 3 && !validWard)
            {
                if(world.getBlockState(pos.down(wardPos)).getBlock() == ModBlocks.BLOCK_WARD)
                {
                    ward = (TileEntityWard) world.getTileEntity(pos.down(wardPos));
                    validWard = true;
                }
                else if(world.getBlockState(pos.down(wardPos)).getBlock() == ModBlocks.BLOCK_WARD)
                {
                    wardPos++;
                }
                else
                {
                    wardPos = 5;
                }
            }

            if(!validWard)
            {
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
            else if(WardType.isValidTarget(entity, ward.getWards()))
            {
                super.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f));
            }
        }
    }

    @Override
    public void registerModels()
    {
        TheWardedBlock.proxy.registerItemRender(Item.getItemFromBlock(this), 0, "inventory");
    }
}
