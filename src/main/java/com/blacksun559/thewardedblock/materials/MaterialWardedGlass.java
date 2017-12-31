package com.blacksun559.thewardedblock.materials;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialWardedGlass extends Material
{
    public MaterialWardedGlass()
    {
        super(MapColor.AIR);
    }

    @Override
    public boolean isOpaque()
    {
        return false;
    }

    @Override
    public boolean blocksLight()
    {
        return false;
    }


}
