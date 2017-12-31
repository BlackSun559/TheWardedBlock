package com.blacksun559.thewardedblock.network;

import com.blacksun559.thewardedblock.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class TWBPacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    private TWBPacketHandler()
    {
    }

    public static void init()
    {
        int id = 0;
        INSTANCE.registerMessage(PacketPlayerKnowledge.Handler.class, PacketPlayerKnowledge.class, id++, Side.SERVER);
        INSTANCE.registerMessage(PacketEntityWarded.Handler.class, PacketEntityWarded.class, id++, Side.SERVER);
        INSTANCE.registerMessage(PacketEntityEaten.Handler.class, PacketEntityEaten.class, id++, Side.SERVER);
    }

    public static void sendToNearby(World world, BlockPos pos, IMessage toSend)
    {
        if(world instanceof WorldServer)
        {
            WorldServer worldServer = (WorldServer) world;

            for(EntityPlayer player : worldServer.playerEntities)
            {
                EntityPlayerMP playerMP = (EntityPlayerMP) player;

                if(playerMP.getDistanceSq(pos) < 64 * 64 && worldServer.getPlayerChunkMap().isPlayerWatchingChunk(playerMP, pos.getX() >> 4, pos.getZ() >> 4))
                {
                    INSTANCE.sendTo(toSend, playerMP);
                }
            }
        }
    }

    public static void sendToNearby(World world, Entity entity, IMessage toSend)
    {
        sendToNearby(world, new BlockPos(entity), toSend);
    }

    public static void sendTo(EntityPlayerMP playerMP, IMessage toSend)
    {
        INSTANCE.sendTo(toSend, playerMP);
    }

    public static void sendToServer(IMessage msg)
    {
        INSTANCE.sendToServer(msg);
    }
}
