package com.blacksun559.thewardedblock.tileentity;

import com.blacksun559.thewardedblock.network.PacketHandler;
import com.blacksun559.thewardedblock.network.message.MessageTileEntityTWB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.UUID;

public class TileEntityTWB extends TileEntity
{
    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;
    protected UUID ownerUUID;

    public TileEntityTWB()
    {
        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
        ownerUUID = null;
    }

    public ForgeDirection getOrientation()
    {
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation)
    {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation)
    {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState()
    {
        return this.state;
    }

    public void setState(byte state)
    {
        this.state = state;
    }

    public String getCustomName()
    {
        return this.customName;
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    public UUID getOwnerUUID()
    {
        return ownerUUID;
    }

    public void setOwner(EntityPlayer entityPlayer)
    {
        this.ownerUUID = entityPlayer.getPersistentID();
    }

    public void setOwnerUUID(UUID ownerUUID)
    {
        this.ownerUUID = ownerUUID;
    }

    public boolean hasCustomName()
    {
        return customName != null && customName.length() > 0;
    }

    public boolean hasOwner()
    {
        return ownerUUID != null;
    }

    public Packet getDescriptionPacket()
    {
        return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntityTWB(this));
    }
}
