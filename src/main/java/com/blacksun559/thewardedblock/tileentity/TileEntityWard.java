package com.blacksun559.thewardedblock.tileentity;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;

public class TileEntityWard extends TileEntityTWB
{
    private static final String SOURCE_BLOCK = "source_block";
    private static final String SOURCE_META = "source_meta";
    private final ArrayList<Integer> wardIDs;
    private final String key = "wards";
    private Block sourceBlock;
    private int sourceMeta;

    public TileEntityWard()
    {
        this.wardIDs = new ArrayList<>();
        this.sourceBlock = Blocks.AIR;
        this.sourceMeta = 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        int[] wardArray = nbt.getIntArray(key);

        for(int i : wardArray)
        {
            this.wardIDs.add(i);
        }

        sourceBlock = Block.getBlockFromName(nbt.getString(SOURCE_BLOCK));
        sourceMeta = nbt.getInteger(SOURCE_META);

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
        nbt.setString(SOURCE_BLOCK, Block.REGISTRY.getNameForObject(sourceBlock).getResourceDomain() + ":" + Block.REGISTRY.getNameForObject(sourceBlock).getResourcePath());
        nbt.setInteger(SOURCE_META, sourceMeta);

        return super.writeToNBT(nbt);
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        return writeToNBT(new NBTTagCompound());
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.getPos(), 0, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
        readFromNBT(pkt.getNbtCompound());
    }

    public void syncUpdates()
    {
        this.world.markBlockRangeForRenderUpdate(this.getPos(), this.getPos());
        this.world.notifyBlockUpdate(this.getPos(), this.world.getBlockState(this.getPos()), this.world.getBlockState(this.getPos()), 3);
        this.world.scheduleBlockUpdate(this.getPos(), this.getBlockType(), 0, 0);
        this.markDirty();
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

    public Block getSourceBlock()
    {
        return sourceBlock;
    }

    public void setSourceBlock(Block sourceBlock)
    {
        this.sourceBlock = sourceBlock;
    }

    public int getSourceMeta()
    {
        return sourceMeta;
    }

    public void setSourceMeta(int sourceMeta)
    {
        this.sourceMeta = sourceMeta;
    }
}
