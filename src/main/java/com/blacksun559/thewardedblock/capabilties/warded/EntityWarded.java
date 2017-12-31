package com.blacksun559.thewardedblock.capabilties.warded;

import com.blacksun559.thewardedblock.network.PacketEntityWarded;
import com.blacksun559.thewardedblock.network.TWBPacketHandler;
import net.minecraft.entity.EntityLivingBase;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class EntityWarded implements IWarded
{
    private ArrayList<Integer> wardIDs;
    private final EntityLivingBase entity;

    public EntityWarded(@Nullable final EntityLivingBase entity)
    {
        this.entity = entity;
        this.wardIDs = new ArrayList<>();
    }

    @Override
    public int[] getWards()
    {
        int[] wards = new int[this.wardIDs.size()];

        for(int i = 0; i < this.wardIDs.size(); i++)
        {
            wards[i] = this.wardIDs.get(i);
        }

        return wards;
    }

    @Override
    public ArrayList<Integer> getArrayList()
    {
        return this.wardIDs;
    }

    @Override
    public void addWard(int id)
    {
        if(!this.wardIDs.contains(id))
        {
            this.wardIDs.add(id);
        }
    }

    @Override
    public void removeWard(int id)
    {
        if(this.wardIDs.contains(id))
        {
            this.wardIDs.remove(this.wardIDs.get(id));
        }
    }

    @Override
    public void clearWards()
    {
        this.wardIDs.clear();
    }

    @Override
    public void setWards(int[] wards)
    {
        this.wardIDs.clear();
        for(int ward : wards)
        {
            this.wardIDs.add(ward);
        }
    }

    @Override
    public void sync()
    {
        if(this.entity != null && !this.entity.getEntityWorld().isRemote)
        {
            IWarded wards = CapabilityEntityWarded.getWards(this.entity);
            PacketEntityWarded entityWarded = new PacketEntityWarded(wards.getWards());
            TWBPacketHandler.sendToServer(entityWarded);
        }
    }
}
