package com.blacksun559.thewardedblock.proxy;

import com.blacksun559.thewardedblock.client.renderer.item.ItemRendererWardBench;
import com.blacksun559.thewardedblock.client.renderer.tileentity.TileEntityRendererWardBench;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.reference.RenderIds;
import com.blacksun559.thewardedblock.tileentity.TileEntityWardBench;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
    public ClientProxy getClientProxy()
    {
        return this;
    }

    public void initRenderingAndTextures()
    {
        RenderIds.wardBench = RenderingRegistry.getNextAvailableRenderId();

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.wardBench), new ItemRendererWardBench());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWardBench.class, new TileEntityRendererWardBench());
    }
}
