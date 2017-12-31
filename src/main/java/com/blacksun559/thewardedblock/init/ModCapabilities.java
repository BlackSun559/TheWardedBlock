package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.capabilties.eaten.CapabilityEaten;
import com.blacksun559.thewardedblock.capabilties.knowledge.CapabilityWardKnowledge;
import com.blacksun559.thewardedblock.capabilties.warded.CapabilityEntityWarded;

public class ModCapabilities
{
    public static void registerCapabilities()
    {
        CapabilityEaten.register();
        CapabilityEntityWarded.register();
        CapabilityWardKnowledge.register();
    }
}
