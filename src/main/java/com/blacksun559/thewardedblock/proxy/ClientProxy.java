package com.blacksun559.thewardedblock.proxy;

import com.blacksun559.thewardedblock.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy implements IProxy
{
    private final Minecraft MINECRAFT = Minecraft.getMinecraft();

    public ClientProxy getClientProxy()
    {
        return this;
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }

    public void registerItemRender(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    @Override
    public void registerVariantRender(Item item, int meta, String filename, String variant)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), variant));
    }
}
