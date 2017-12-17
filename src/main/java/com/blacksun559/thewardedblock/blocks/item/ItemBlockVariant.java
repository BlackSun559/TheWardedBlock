package com.blacksun559.thewardedblock.blocks.item;

import com.blacksun559.thewardedblock.util.handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockVariant extends ItemBlock
{
    public ItemBlockVariant(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "_" + EnumHandler.EnumType.values()[stack.getMetadata()].getName();
    }
}
