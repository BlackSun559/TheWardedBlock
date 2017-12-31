package com.blacksun559.thewardedblock.blocks.properties;

import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class UnlistedPropertySourceBlock implements IUnlistedProperty<IBlockState>
{
    @Override
    public String getName()
    {
        return "UnlistedPropertySourceBlock";
    }

    @Override
    public boolean isValid(IBlockState state)
    {
        return true;
    }

    @Override
    public Class getType()
    {
        return IBlockState.class;
    }

    @Override
    public String valueToString(IBlockState value)
    {
        return value.toString();
    }
}
