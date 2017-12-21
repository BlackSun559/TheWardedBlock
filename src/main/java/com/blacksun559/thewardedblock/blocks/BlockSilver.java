package com.blacksun559.thewardedblock.blocks;

import net.minecraft.block.material.Material;

public class BlockSilver extends BlockTWB
{
    public BlockSilver(String name)
    {
        super(name, Material.IRON);
        this.setHardness(5.0f);
        this.setHarvestLevel("pickaxe", 1);
    }
}
