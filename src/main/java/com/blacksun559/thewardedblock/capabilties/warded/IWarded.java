package com.blacksun559.thewardedblock.capabilties.warded;

public interface IWarded
{
    int[] getWards();

    void addWard(int id);

    void removeWard(int id);

    void setWards(int[] wards);

    void sync();
}