package com.blacksun559.thewardedblock.network;

import com.blacksun559.thewardedblock.network.message.MessageTileEntityTWB;
import com.blacksun559.thewardedblock.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntityTWB.class, MessageTileEntityTWB.class, 0, Side.CLIENT);
    }
}
