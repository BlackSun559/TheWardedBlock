package com.blacksun559.thewardedblock.util.handlers;

import com.blacksun559.thewardedblock.capabilties.warded.CapabilityEntityWarded;
import com.blacksun559.thewardedblock.capabilties.warded.IWarded;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber
public class EventHandler
{
    @SubscribeEvent
    public void testWards(LivingDamageEvent event)
    {
        final IWarded warded = CapabilityEntityWarded.getWards((EntityLivingBase)event.getEntity());

        if(warded.getWards().length > 0)
        {
            if(warded.getArrayList().contains(0) && event.getSource() == DamageSource.MAGIC)
            {
                event.setAmount(0.0f);
            }

            if(warded.getArrayList().contains(1) && event.getSource() == DamageSource.FALL)
            {
                event.setAmount(0.0f);
            }
        }
    }
}
