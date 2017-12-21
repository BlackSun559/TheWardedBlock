package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.world.gen.WorldGenCustomOres;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModMapGen
{
    public static void registerWorldGenerators()
    {
        GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
    }
}
