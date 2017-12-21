package com.blacksun559.thewardedblock.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MouseEventMessage implements IMessage
{
    private int dWheel;

    public MouseEventMessage()
    {
    }

    public MouseEventMessage(int dWheel)
    {
        this.dWheel= dWheel;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.dWheel = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.dWheel);
    }

    public int getdWheel()
    {
        return dWheel;
    }
}
