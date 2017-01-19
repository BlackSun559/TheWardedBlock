package com.blacksun559.thewardedblock;

import com.blacksun559.thewardedblock.creativeTab.CreativeTab;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.proxy.CommonProxy;
import com.blacksun559.thewardedblock.util.LogHelper;
import com.blacksun559.thewardedblock.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class TheWardedBlock
{
    @Mod.Instance(Reference.MOD_ID)
    public static TheWardedBlock instance;

    public static CreativeTab thewardedblock;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        thewardedblock = new CreativeTab(CreativeTabs.getNextID(), "thewardedblock");
        ModItems.Init();
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
}
