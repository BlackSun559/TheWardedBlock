package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.entity.EntityDemon;
import com.blacksun559.thewardedblock.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities
{
    public static void registerEntities()
    {
        registerEntities("demon", EntityDemon.class, Reference.ENTITY_DEMON, 50, 12500670, 16777215);
    }

    private static void registerEntities(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, TheWardedBlock.instance, range, 1, true, color1, color2);
    }
}
