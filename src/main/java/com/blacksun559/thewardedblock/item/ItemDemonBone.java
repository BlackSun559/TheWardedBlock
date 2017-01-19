package com.blacksun559.thewardedblock.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemDemonBone extends ItemTWB
{
    public ItemDemonBone(String name)
    {
        super(name);
        this.setMaxStackSize(64);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        tooltip.add("Basic Demon bone. Has very little power.");
        super.addInformation(stack, player, tooltip, advanced);
    }
}
