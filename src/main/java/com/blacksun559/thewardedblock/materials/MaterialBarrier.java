package com.blacksun559.thewardedblock.materials;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialBarrier extends Material
{
    public MaterialBarrier()
    {
        super(MapColor.AIR);
    }

    @Override
    public boolean isReplaceable()
    {
        return true;
    }

    @Override
    public boolean blocksLight()
    {
        return false;
    }

    @Override
    public boolean isOpaque()
    {
        return false;
    }
}
