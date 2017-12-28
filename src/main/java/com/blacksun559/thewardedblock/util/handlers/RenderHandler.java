package com.blacksun559.thewardedblock.util.handlers;

import com.blacksun559.thewardedblock.entity.EntityDemon;
import com.blacksun559.thewardedblock.entity.render.RenderDemon;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, renderManager -> new RenderDemon(renderManager));
    }
}
