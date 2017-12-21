package com.blacksun559.thewardedblock.capabilties;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CapabilityProviderSimple<HANDLER> implements ICapabilityProvider
{
    protected final Capability<HANDLER> capability;

    protected final EnumFacing facing;

    protected final HANDLER instance;

    public CapabilityProviderSimple(Capability<HANDLER> capability,@Nullable EnumFacing facing,@Nullable HANDLER instance)
    {
        this.capability = capability;
        this.facing = facing;
        this.instance = instance;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == getCapability();
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
    {
        T t = null;
        if(capability == getCapability())
        {
            t = getCapability().cast(getInstance());
        }

        return t;
    }

    public Capability<HANDLER> getCapability()
    {
        return capability;
    }

    public EnumFacing getFacing()
    {
        return facing;
    }

    public HANDLER getInstance()
    {
        return instance;
    }
}
