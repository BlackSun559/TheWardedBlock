package com.blacksun559.thewardedblock.network;

import com.blacksun559.thewardedblock.capabilties.warded.CapabilityEntityWarded;
import com.blacksun559.thewardedblock.capabilties.warded.IWarded;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketEntityWarded implements IMessage
{
    private int[] wards;

    public PacketEntityWarded()
    {
        this.wards = new int[0];
    }

    public PacketEntityWarded(int[] wards)
    {
        this.wards = wards;
    }

    @Override
    public void fromBytes(ByteBuf byteBuf)
    {
        this.wards = new int[byteBuf.readInt()];

        for(int i = 0; i < this.wards.length; i++)
        {
            this.wards[i] = byteBuf.readInt();
        }
    }

    @Override
    public void toBytes(ByteBuf byteBuf)
    {
        byteBuf.writeInt(this.wards.length);

        for(int i : wards)
        {
            byteBuf.writeInt(i);
        }
    }

    public static class Handler implements IMessageHandler<PacketEntityWarded, IMessage>
    {
        @Override
        public IMessage onMessage(PacketEntityWarded packetEntityWarded, MessageContext messageContext)
        {
            EntityPlayerMP playerMP = messageContext.getServerHandler().player;

            playerMP.mcServer.addScheduledTask(() ->
            {
                IWarded wards = CapabilityEntityWarded.getWards(playerMP);
                wards.setWards(packetEntityWarded.wards);
            });
            return null;
        }
    }
}
