package com.blacksun559.thewardedblock.capabilties.eaten;

import com.blacksun559.thewardedblock.capabilties.CapabilityProviderSerializable;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.CapabilityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
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

public class CapabilityEaten
{
    @CapabilityInject(IEaten.class)
    private static final Capability<IEaten> EATEN_CAPABILITY = null;

    private static final EnumFacing DEFAULT_FACING = null;

    private static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "Eaten");

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IEaten.class, new Capability.IStorage<IEaten>()
        {
            @Override
            public NBTBase writeNBT(Capability<IEaten> capability, IEaten instance, EnumFacing side)
            {
                return new NBTTagInt(instance.getEaten());
            }

            @Override
            public void readNBT(Capability<IEaten> capability, IEaten instance, EnumFacing side, NBTBase nbt)
            {
                instance.setEaten(((NBTTagInt)nbt).getInt());
            }
        }, () -> new Eaten(null));
    }

    public static IEaten getEaten(final EntityLivingBase entity)
    {
        return CapabilityUtils.getCapability(entity, EATEN_CAPABILITY, DEFAULT_FACING);
    }

    public static ICapabilityProvider createProvider(final IEaten eaten)
    {
        return new CapabilityProviderSerializable<>(EATEN_CAPABILITY, DEFAULT_FACING, eaten);
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber
    private static class EventHandler
    {
        @SubscribeEvent
        public static void attachCapabilities(final AttachCapabilitiesEvent<Entity> event)
        {
            if(event.getObject() instanceof EntityLivingBase)
            {
                final Eaten eaten = new Eaten((EntityLivingBase) event.getObject());
                event.addCapability(ID, createProvider(eaten));
            }
        }

        @SubscribeEvent
        public static void playerClone(final PlayerEvent.Clone event)
        {
            final IEaten oldEaten = getEaten(event.getOriginal());
            final IEaten newEaten = getEaten(event.getEntityPlayer());

            if(newEaten != null && oldEaten != null)
            {
                newEaten.setEaten(oldEaten.getEaten());
            }
        }

        @SubscribeEvent
        public static void playerChangeDimension(final PlayerChangedDimensionEvent event)
        {
            final IEaten eaten = getEaten(event.player);

            if(eaten != null)
            {
                eaten.sync();
            }
        }
    }
}
