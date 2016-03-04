package com.blacksun559.thewardedblock;


import com.blacksun559.thewardedblock.handler.ConfigurationHandler;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.init.ModTileEntities;
import com.blacksun559.thewardedblock.network.PacketHandler;
import com.blacksun559.thewardedblock.proxy.IProxy;
import com.blacksun559.thewardedblock.util.LogHelper;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
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
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.Init();
        ModBlocks.Init();
        PacketHandler.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModTileEntities.init();

        proxy.initRenderingAndTextures(); // TODO update readme

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
}
