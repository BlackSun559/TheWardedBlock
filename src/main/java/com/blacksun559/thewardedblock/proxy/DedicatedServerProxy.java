package com.blacksun559.thewardedblock.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DedicatedServerProxy implements IProxy
{
    @Override
    public void preInit()
    {

    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerItemRender(Item item, int meta, String id)
    {
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerVariantRender(Item item, int meta, String filename, String variant)
    {
    }
}
