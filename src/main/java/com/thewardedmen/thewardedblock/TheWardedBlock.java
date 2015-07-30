package com.thewardedmen.thewardedblock;


import com.thewardedmen.thewardedblock.client.gui.GuiFactory;
import com.thewardedmen.thewardedblock.init.ModItems;
import com.thewardedmen.thewardedblock.proxy.IProxy;
import com.thewardedmen.thewardedblock.reference.Reference;
import com.thewardedmen.thewardedblock.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class TheWardedBlock
{
    @Mod.Instance(Reference.MOD_ID)
    public static TheWardedBlock instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.Init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
