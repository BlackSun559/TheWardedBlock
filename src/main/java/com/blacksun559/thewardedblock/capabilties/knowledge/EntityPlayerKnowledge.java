package com.blacksun559.thewardedblock.capabilties.knowledge;

import com.blacksun559.thewardedblock.network.PacketPlayerKnowledge;
import com.blacksun559.thewardedblock.network.TWBPacketHandler;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class EntityPlayerKnowledge implements IWardKnowledge
{
    private ArrayList<Integer> knowledgeIDs;
    private final EntityPlayer player;

    public EntityPlayerKnowledge(@Nullable final EntityPlayer player)
    {
        this.player = player;
        this.knowledgeIDs = new ArrayList<>();
    }

    @Override
    public int[] getKnown()
    {
        int[] knowledge = new int[this.knowledgeIDs.size()];

        for(int i = 0; i < this.knowledgeIDs.size(); i++)
        {
            knowledge[i] = this.knowledgeIDs.get(i);
        }

        return knowledge;
    }

    @Override
    public ArrayList<Integer> getKnownList()
    {
        return this.knowledgeIDs;
    }

    @Override
    public void addKnowledge(int id)
    {
        if(!this.knowledgeIDs.contains(id))
        {
            this.knowledgeIDs.add(id);
        }
    }

    @Override
    public void removeKnowledge(int id)
    {
        if(this.knowledgeIDs.contains(id))
        {
            this.knowledgeIDs.remove(this.knowledgeIDs.get(id));
        }
    }

    @Override
    public void setKnowledge(int[] knowledge)
    {
        this.knowledgeIDs.clear();
        for(int id : knowledge)
        {
            this.knowledgeIDs.add(id);
        }
    }

    @Override
    public void setKnowledge(ArrayList<Integer> knowledge)
    {
        this.knowledgeIDs = knowledge;
    }

    @Override
    public void clearWards()
    {
        this.knowledgeIDs.clear();
    }

    @Override
    public void sync()
    {
        if(this.player != null && !this.player.getEntityWorld().isRemote)
        {
            IWardKnowledge knowledge = CapabilityWardKnowledge.getKnowledge(this.player);
            PacketPlayerKnowledge playerKnowledge = new PacketPlayerKnowledge(knowledge.getKnown());
            TWBPacketHandler.sendToServer(playerKnowledge);
        }
    }
}
