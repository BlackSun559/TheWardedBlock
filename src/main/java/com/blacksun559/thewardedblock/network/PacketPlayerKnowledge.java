package com.blacksun559.thewardedblock.network;

import com.blacksun559.thewardedblock.capabilties.knowledge.CapabilityWardKnowledge;
import com.blacksun559.thewardedblock.capabilties.knowledge.IWardKnowledge;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketPlayerKnowledge implements IMessage
{
    private int[] knowledge;

    public PacketPlayerKnowledge()
    {
        this.knowledge = new int[0];
    }

    public PacketPlayerKnowledge(int[] knowledge)
    {
        this.knowledge = knowledge;
    }

    @Override
    public void fromBytes(ByteBuf byteBuf)
    {
        this.knowledge = new int[byteBuf.readInt()];

        for(int i = 0; i < this.knowledge.length; i++)
        {
            this.knowledge[i] = byteBuf.readInt();
        }
    }

    @Override
    public void toBytes(ByteBuf byteBuf)
    {
        byteBuf.writeInt(this.knowledge.length);

        for(int i : knowledge)
        {
            byteBuf.writeInt(i);
        }
    }

    public static class Handler implements IMessageHandler<PacketPlayerKnowledge, IMessage>
    {
        @Override
        public IMessage onMessage(PacketPlayerKnowledge packetPlayerKnowledge, MessageContext messageContext)
        {
            EntityPlayerMP playerMP = messageContext.getServerHandler().player;

            playerMP.mcServer.addScheduledTask(() ->
            {
                IWardKnowledge knowledge = CapabilityWardKnowledge.getKnowledge(playerMP);
                knowledge.setKnowledge(packetPlayerKnowledge.knowledge);
            });
            return null;
        }
    }
}
