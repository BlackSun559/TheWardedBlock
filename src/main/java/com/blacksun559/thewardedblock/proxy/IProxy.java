package com.blacksun559.thewardedblock.proxy;

import net.minecraft.item.Item;

public interface IProxy
{
    void preInit();

    void init();

    void postInit();

    void registerItemRender(Item item, int meta, String id);

    void registerVariantRender(Item item, int meta, String filename, String variant);
}
