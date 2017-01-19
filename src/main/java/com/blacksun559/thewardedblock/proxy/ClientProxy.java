package com.blacksun559.thewardedblock.proxy;

import com.blacksun559.thewardedblock.init.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    public ClientProxy getClientProxy()
    {
        return this;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        ModItems.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
