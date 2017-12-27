package com.blacksun559.thewardedblock.capabilties.warded;

import java.util.ArrayList;

public interface IWarded
{
    int[] getWards();

    ArrayList<Integer> getArrayList();

    void addWard(int id);

    void removeWard(int id);

    void setWards(int[] wards);

    void clearWards();

    void sync();
}