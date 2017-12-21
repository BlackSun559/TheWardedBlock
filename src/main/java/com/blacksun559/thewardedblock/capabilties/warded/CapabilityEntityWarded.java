package com.blacksun559.thewardedblock.capabilties.warded;

import com.blacksun559.thewardedblock.capabilties.CapabilityProviderSerializable;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.CapabilityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;

import javax.annotation.Nullable;

public class CapabilityEntityWarded
{
    @CapabilityInject(IWarded.class)
    private static final Capability<IWarded> WARDED_CAPABILITY = null;

    private static final EnumFacing DEFAULT_FACING = null;

    private static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "EntityWarded");

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IWarded.class, new Capability.IStorage<IWarded>()
        {
            @Nullable
            @Override
            public NBTBase writeNBT(Capability<IWarded> capability, IWarded instance, EnumFacing side)
            {
                return new NBTTagIntArray(instance.getWards());
            }

            @Override
            public void readNBT(Capability<IWarded> capability, IWarded instance, EnumFacing side, NBTBase nbt)
            {
                instance.setWards(((NBTTagIntArray)nbt).getIntArray());
            }
        }, () -> new EntityWarded(null));
    }

    public static IWarded getWards(final EntityLivingBase entity)
    {
        return CapabilityUtils.getCapability(entity, WARDED_CAPABILITY, DEFAULT_FACING);
    }

    public static ICapabilityProvider createProvider(final IWarded warded)
    {
        return new CapabilityProviderSerializable<>(WARDED_CAPABILITY, DEFAULT_FACING, warded);
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber
    public static class EventHandler
    {
        @SubscribeEvent
        public static void attachCapabilities(final AttachCapabilitiesEvent<Entity> event)
        {
            if(event.getObject() instanceof EntityLivingBase)
            {
                final EntityWarded warded = new EntityWarded((EntityLivingBase) event.getObject());
                event.addCapability(ID, createProvider(warded));
            }
        }

        @SubscribeEvent
        public static void playerClone(final PlayerEvent.Clone event)
        {
            final IWarded oldWards = getWards(event.getOriginal());
            final IWarded newWards = getWards(event.getEntityPlayer());

            if(newWards != null && oldWards != null)
            {
                newWards.setWards(oldWards.getWards());
            }
        }

        @SubscribeEvent
        public static void playerChangeDimension(final PlayerChangedDimensionEvent event)
        {
            final IWarded warded = getWards(event.player);

            if(warded != null)
            {
                warded.sync();
            }
        }
    }
}
