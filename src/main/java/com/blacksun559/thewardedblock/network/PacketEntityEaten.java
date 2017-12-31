package com.blacksun559.thewardedblock.network;

import com.blacksun559.thewardedblock.capabilties.eaten.CapabilityEaten;
import com.blacksun559.thewardedblock.capabilties.eaten.IEaten;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketEntityEaten implements IMessage
{
    private int eaten;

    public PacketEntityEaten()
    {
        this.eaten = 0;
    }

    public PacketEntityEaten(int eaten)
    {
        this.eaten = eaten;
    }

    @Override
    public void fromBytes(ByteBuf byteBuf)
    {
        this.eaten = byteBuf.readInt();
    }

    @Override
    public void toBytes(ByteBuf byteBuf)
    {
        byteBuf.writeInt(this.eaten);
    }

    public static class Handler implements IMessageHandler<PacketEntityEaten, IMessage>
    {
        @Override
        public IMessage onMessage(PacketEntityEaten packetEntityEaten, MessageContext messageContext)
        {
            EntityPlayerMP playerMP = messageContext.getServerHandler().player;

            playerMP.mcServer.addScheduledTask(() ->
            {
                IEaten eaten = CapabilityEaten.getEaten(playerMP);
                eaten.setEaten(packetEntityEaten.eaten);
            });
            return null;
        }
    }
}
