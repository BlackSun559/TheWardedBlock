package com.blacksun559.thewardedblock.handler;

import com.blacksun559.thewardedblock.knowledge.AbilityKnowledgeRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerEventHandler
{
    @SubscribeEvent
    public void onPlayerLoadFromFileEvent(PlayerEvent.LoadFromFile event)
    {
        if(!event.entityPlayer.worldObj.isRemote)
        {
            AbilityKnowledgeRegistry.getInstance().loadPlayerFromDiskIfNeeded(event.entityPlayer);
        }
    }
}
