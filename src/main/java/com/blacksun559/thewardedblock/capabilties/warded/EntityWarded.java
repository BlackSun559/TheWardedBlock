package com.blacksun559.thewardedblock.capabilties.warded;

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
    public void addWard(int id)
    {
        this.wardIDs.add(id);
    }

    @Override
    public void removeWard(int id)
    {
        this.wardIDs.remove(id);
    }

    @Override
    public void setWards(int[] wards)
    {
        for(int ward : wards)
        {
            this.wardIDs.add(ward);
        }
    }

    @Override
    public void sync()
    {
        // NOOP
    }
}
