package com.blacksun559.thewardedblock.blocks.properties;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.property.IUnlistedProperty;

public class UnlistedPropertyFacing implements IUnlistedProperty<EnumFacing>
{
    @Override
    public String getName()
    {
        return "UnlistedPropertyFacing";
    }

    @Override
    public boolean isValid(EnumFacing facing)
    {
        return true;
    }

    @Override
    public Class<EnumFacing> getType()
    {
        return EnumFacing.class;
    }

    @Override
    public String valueToString(EnumFacing facing)
    {
        return facing.getName();
    }
}
