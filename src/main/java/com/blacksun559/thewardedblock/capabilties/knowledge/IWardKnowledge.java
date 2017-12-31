package com.blacksun559.thewardedblock.capabilties.knowledge;

import java.util.ArrayList;

public interface IWardKnowledge
{
    int[] getKnown();

    ArrayList<Integer> getKnownList();

    void addKnowledge(int id);

    void removeKnowledge(int id);

    void setKnowledge(int[] knowledge);

    void setKnowledge(ArrayList<Integer> knowledge);

    void clearWards();

    void sync();
}
