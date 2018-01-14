package com.blacksun559.thewardedblock.network;

import com.blacksun559.thewardedblock.util.PlayerUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.nio.charset.Charset;

public class PacketPlayerMessage implements IMessage
{
    private int messageID;
    private String message;

    public PacketPlayerMessage()
    {
        this.message = null;
        this.messageID = 0;
    }

    public PacketPlayerMessage(int messageID, String message)
    {
        this.messageID = messageID;
        this.message = message;
    }

    @Override
    public void fromBytes(ByteBuf byteBuf)
    {
        this.messageID = byteBuf.readInt();
        int length = byteBuf.readInt();
        this.message = (String) byteBuf.readCharSequence(length, Charset.defaultCharset());
    }

    @Override
    public void toBytes(ByteBuf byteBuf)
    {
        byteBuf.writeInt(this.messageID);
        byteBuf.writeInt(this.message.length());
        byteBuf.writeCharSequence(this.message, Charset.defaultCharset());
    }

    public static class Handler implements IMessageHandler<PacketPlayerMessage, IMessage>
    {

        @Override
        public IMessage onMessage(PacketPlayerMessage packetPlayerMessage, MessageContext messageContext)
        {
            PlayerUtils.messageOnce(packetPlayerMessage.messageID, new TextComponentTranslation(packetPlayerMessage.message));
            return null;
        }
    }
}
