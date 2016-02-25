package com.blacksun559.thewardedblock.handler;

import com.blacksun559.thewardedblock.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static float damageChance = 0.05f;

    public static void init(File configFile)
    {
        //Create the configuration object from the given configuration file
        if(configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            //Resync configs
            loadConfiguration();
        }
    }

    public static void loadConfiguration()
    {
        damageChance = configuration.getFloat("damageChance", Configuration.CATEGORY_GENERAL, 0.05f, 0.001f, 1.0f, "Percent chance of damage applying to Demons. (Range of 1.0 - 0.001 and default of 0.05)");

        if(configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
