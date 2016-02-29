package com.blacksun559.thewardedblock.knowledge;

import net.minecraft.entity.player.EntityPlayer;

import java.util.UUID;

public class AbilityKnowledgeRegistry
{
    private static AbilityKnowledgeRegistry abilityKnowledgeRegistry;

    private AbilityKnowledgeRegistry()
    {

    }

    public static AbilityKnowledgeRegistry getInstance()
    {
        if(abilityKnowledgeRegistry == null)
        {
            abilityKnowledgeRegistry = new AbilityKnowledgeRegistry();
        }

        return abilityKnowledgeRegistry;
    }

    public void loadPlayerFromDiskIfNeeded(EntityPlayer entityPlayer)
    {
        if(entityPlayer != null && entityPlayer.getUniqueID() != null)
        {
            loadPlayerFromDiskIfNeeded(entityPlayer.getUniqueID());
        }
    }

    public void loadPlayerFromDiskIfNeeded(UUID playerUUID)
    {
        if(playerUUID != null)
        {
            // TODO set player ability knowledge
            // TODO generate a knowledge file
        }
    }
}
