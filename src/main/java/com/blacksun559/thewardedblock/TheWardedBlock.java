package com.blacksun559.thewardedblock;

import com.blacksun559.thewardedblock.creativeTab.CreativeTab;
import com.blacksun559.thewardedblock.init.ModCapabilities;
import com.blacksun559.thewardedblock.init.ModEntities;
import com.blacksun559.thewardedblock.init.ModMapGen;
import com.blacksun559.thewardedblock.init.ModRecipes;
import com.blacksun559.thewardedblock.proxy.IProxy;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.LogHelper;
import com.blacksun559.thewardedblock.util.handlers.EventHandler;
import com.blacksun559.thewardedblock.util.handlers.RenderHandler;
import com.blacksun559.thewardedblock.util.handlers.TWBPacketHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Random;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class TheWardedBlock
{
    public static int messageID = new Random(System.currentTimeMillis()).nextInt();

    @Mod.Instance(Reference.MOD_ID)
    public static TheWardedBlock instance;

    public static CreativeTab thewardedblock;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        TWBPacketHandler.init();

        thewardedblock = new CreativeTab(CreativeTabs.getNextID(), "thewardedblock");

        ModCapabilities.registerCapabilities();
        ModEntities.registerEntities();
        RenderHandler.registerEntityRenders();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModRecipes.registerRecipes();
        ModMapGen.registerWorldGenerators();

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());

        LogHelper.info("Post Initialization Complete!");
    }

    public static int getMessageID()
    {
        return messageID++;
    }
}
