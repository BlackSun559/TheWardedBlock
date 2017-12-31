package com.blacksun559.thewardedblock.reference;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Reference
{
    public static final String MOD_ID = "thewardedblock";
    public static final String MOD_NAME = "The Warded Block";
    public static final String VERSION = "1.10.2-0.1";
    public static final String CLIENT_PROXY = "com.blacksun559.thewardedblock.proxy.ClientProxy";
    public static final String SERVER_PROXY = "com.blacksun559.thewardedblock.proxy.ServerProxy";
    public static final String GUI_FACTORY_CLASS = "com.blacksun559.thewardedblock.client.gui.GuiFactory";

    public static final int ENTITY_DEMON = 559;

    public static final String UUID = "a5f357d0-6765-4461-ae27-db5c4fe5b42c";

    public static final Item.ToolMaterial WARDED_GLASS = EnumHelper.addToolMaterial("warded_glass", 3, 2500, 10.0f, 4.0f, 30);
}
