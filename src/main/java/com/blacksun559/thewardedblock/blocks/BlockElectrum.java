package com.blacksun559.thewardedblock.blocks;

import com.blacksun559.thewardedblock.blocks.base.BlockTWB;
import net.minecraft.block.material.Material;

public class BlockElectrum extends BlockTWB
{
    public BlockElectrum(String name)
    {
        super(name, Material.IRON);
        this.setHardness(5.0f);
        this.setHarvestLevel("pickaxe", 1);
    }
}
