package com.blacksun559.thewardedblock.util.handlers;

import com.blacksun559.thewardedblock.network.MouseEventMessage;
import com.blacksun559.thewardedblock.reference.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class TWBPacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
    private static int id = 0;

    public static void init()
    {
        INSTANCE.registerMessage(MouseEventMessageHandler.class, MouseEventMessage.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(MouseEventMessageHandler.class, MouseEventMessage.class, id++, Side.SERVER);
    }
}
