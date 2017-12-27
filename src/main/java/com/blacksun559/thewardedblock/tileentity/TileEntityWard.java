package com.blacksun559.thewardedblock.tileentity;

import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.Iterator;

public class TileEntityWard extends TileEntityTWB
{
    ArrayList<Integer> wardIDs;
    private final String key = "wards";

    public TileEntityWard()
    {
        this.wardIDs = new ArrayList<>();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        int[] wardArray = nbt.getIntArray(key);

        for(int i : wardArray)
        {
            wardIDs.add(i);
        }

        super.readFromNBT(nbt);
    }



    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        int[] wardArray = new int[this.wardIDs.size()];
        Iterator<Integer> iterator = this.wardIDs.iterator();

        for(int i = 0; i < this.wardIDs.size(); i++)
        {
            wardArray[i] = iterator.next();
        }

        nbt.setIntArray(key, wardArray);

        return super.writeToNBT(nbt);
    }

    public ArrayList<Integer> getWards()
    {
        return this.wardIDs;
    }

    public void addWard(int id)
    {
        if(!this.wardIDs.contains(id))
        {
            this.wardIDs.add(id);
        }
    }

    public void clearWards()
    {
        this.wardIDs.clear();
    }
}
