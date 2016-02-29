package com.blacksun559.thewardedblock.block;

import com.blacksun559.thewardedblock.reference.Names;
import net.minecraft.block.material.Material;

public class WardBench extends BlockTWB
{
    public WardBench()
    {
        super(Material.wood);
        this.setBlockName(Names.Blocks.WARD_BENCH);
        this.setHardness(0.5f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeWood);
    }
}
