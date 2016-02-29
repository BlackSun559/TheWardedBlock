package com.blacksun559.thewardedblock.proxy;

import com.blacksun559.thewardedblock.client.renderer.tileentity.TileEntityRendererWardBench;
import com.blacksun559.thewardedblock.reference.RenderIds;
import com.blacksun559.thewardedblock.tileentity.TileEntityWardBench;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    public ClientProxy getClientProxy()
    {
        return this;
    }

    public void initRenderingAndTextures()
    {
        RenderIds.wardBench = RenderingRegistry.getNextAvailableRenderId();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWardBench.class, new TileEntityRendererWardBench());
    }
}
