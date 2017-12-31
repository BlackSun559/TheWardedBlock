package com.blacksun559.thewardedblock.capabilties.knowledge;

import com.blacksun559.thewardedblock.capabilties.CapabilityProviderSerializable;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.CapabilityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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

import javax.annotation.Nullable;

public class CapabilityWardKnowledge
{
    @CapabilityInject(IWardKnowledge.class)
    private static final Capability<IWardKnowledge> WARD_KNOWLEDGE_CAPABILITY = null;

    private static final EnumFacing DEFAULT_FACING = null;

    private static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "EntityPlayerKnowledge");

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IWardKnowledge.class, new Capability.IStorage<IWardKnowledge>()
        {
            @Nullable
            @Override
            public NBTBase writeNBT(Capability<IWardKnowledge> capability, IWardKnowledge instance, EnumFacing enumFacing)
            {
                return new NBTTagIntArray(instance.getKnown());
            }

            @Override
            public void readNBT(Capability<IWardKnowledge> capability, IWardKnowledge instance, EnumFacing enumFacing, NBTBase nbt)
            {
                instance.setKnowledge(((NBTTagIntArray) nbt).getIntArray());
            }
        }, () -> new EntityPlayerKnowledge(null));
    }

    public static IWardKnowledge getKnowledge(final EntityPlayer player)
    {
        return CapabilityUtils.getCapability(player, WARD_KNOWLEDGE_CAPABILITY, DEFAULT_FACING);
    }

    public static ICapabilityProvider createProvider(final IWardKnowledge knowledge)
    {
        return new CapabilityProviderSerializable<>(WARD_KNOWLEDGE_CAPABILITY, DEFAULT_FACING, knowledge);
    }

    @Mod.EventBusSubscriber
    public static class EventHandler
    {
        @SubscribeEvent
        public static void attachCapabilities(final AttachCapabilitiesEvent<Entity> event)
        {
            if(event.getObject() instanceof EntityPlayer)
            {
                final EntityPlayerKnowledge knowledge = new EntityPlayerKnowledge((EntityPlayer) event.getObject());
                event.addCapability(ID, createProvider(knowledge));
            }
        }

        @SubscribeEvent
        public static void playerClone(final PlayerEvent.Clone event)
        {
            final IWardKnowledge oldKnowledge = getKnowledge(event.getEntityPlayer());
            final IWardKnowledge newKnowledge = getKnowledge(event.getEntityPlayer());

            if(oldKnowledge != null && newKnowledge != null)
            {
                oldKnowledge.setKnowledge(newKnowledge.getKnown());
            }
        }

        @SubscribeEvent
        public static void playerChangeDimension(final net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent event)
        {
            final IWardKnowledge knowledge = getKnowledge(event.player);

            if(knowledge != null)
            {
                knowledge.sync();
            }
        }
    }
}
