package com.blacksun559.thewardedblock.block;

import com.blacksun559.thewardedblock.reference.Names;
import com.blacksun559.thewardedblock.reference.RenderIds;
import com.blacksun559.thewardedblock.tileentity.TileEntityWardBench;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWardBench extends BlockTileEntityTWB
{
    public BlockWardBench()
    {
        super(Material.wood);
        this.setHardness(2.0f);
        this.setBlockName(Names.Blocks.WARD_BENCH);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityWardBench();
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIds.wardBench;
    }
}
