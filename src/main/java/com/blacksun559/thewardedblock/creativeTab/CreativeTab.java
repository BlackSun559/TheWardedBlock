package com.blacksun559.thewardedblock.creativeTab;

import com.blacksun559.thewardedblock.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs
{
    public CreativeTab(int index, String label)
    {
        super(index, label);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.BONE_DEMON);
    }
}