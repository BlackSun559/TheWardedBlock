package com.blacksun559.thewardedblock.network.message;

import com.blacksun559.thewardedblock.tileentity.TileEntityTWB;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

public class MessageTileEntityTWB implements IMessage, IMessageHandler<MessageTileEntityTWB, IMessage>
{
    public int x, y, z;
    public byte orientation, state;
    public String customName;
    public UUID ownerUUID;

    public MessageTileEntityTWB()
    {
    }

    public MessageTileEntityTWB(TileEntityTWB tileEntityTWB)
    {
        this.x = tileEntityTWB.xCoord;
        this.y = tileEntityTWB.yCoord;
        this.z = tileEntityTWB.zCoord;
        this.orientation = (byte) tileEntityTWB.getOrientation().ordinal();
        this.state = (byte) tileEntityTWB.getState();
        this.customName = tileEntityTWB.getCustomName();
        this.ownerUUID = tileEntityTWB.getOwnerUUID();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        if (buf.readBoolean())
        {
            this.ownerUUID = new UUID(buf.readLong(), buf.readLong());
        }
        else
        {
            this.ownerUUID = null;
        }
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        if (ownerUUID != null)
        {
            buf.writeBoolean(true);
            buf.writeLong(ownerUUID.getMostSignificantBits());
            buf.writeLong(ownerUUID.getLeastSignificantBits());
        }
        else
        {
            buf.writeBoolean(false);
        }
    }

    @Override
    public IMessage onMessage(MessageTileEntityTWB message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityTWB)
        {
            ((TileEntityTWB) tileEntity).setOrientation(message.orientation);
            ((TileEntityTWB) tileEntity).setState(message.state);
            ((TileEntityTWB) tileEntity).setCustomName(message.customName);
            ((TileEntityTWB) tileEntity).setOwnerUUID(message.ownerUUID);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntityEE - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, ownerUUID:%s", x, y, z, orientation, state, customName, ownerUUID);
    }
}
