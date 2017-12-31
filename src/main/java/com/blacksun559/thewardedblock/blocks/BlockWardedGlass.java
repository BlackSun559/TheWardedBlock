package com.blacksun559.thewardedblock.blocks;

import com.blacksun559.thewardedblock.blocks.base.BlockTWB;
import com.blacksun559.thewardedblock.materials.MaterialWardedGlass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWardedGlass extends BlockTWB
{
    public static final Material warded_glass = new MaterialWardedGlass();

    public BlockWardedGlass(String name)
    {
        super(name, warded_glass);
        this.setHardness(10.0f);
        this.setSoundType(SoundType.GLASS);

        //TODO make texture
    }
}
