package com.blacksun559.thewardedblock.capabilties;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;

public class CapabilityProviderSerializable<HANDLER> extends CapabilityProviderSimple<HANDLER> implements INBTSerializable<NBTBase>
{
    public CapabilityProviderSerializable(Capability<HANDLER> capability, @Nullable EnumFacing facing)
    {
        super(capability, facing, capability.getDefaultInstance());
    }

    public CapabilityProviderSerializable(Capability<HANDLER> capability, @Nullable EnumFacing facing, @Nullable HANDLER instance)
    {
        super(capability, facing, instance);
    }

    @Nullable
    @Override
    public NBTBase serializeNBT()
    {
        return getCapability().writeNBT(getInstance(), getFacing());
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        getCapability().readNBT(getInstance(), getFacing(), nbt);
    }
}
