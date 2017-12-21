package com.blacksun559.thewardedblock.items;

import com.blacksun559.thewardedblock.items.Base.ItemTWB;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemDemonBone extends ItemTWB
{
    public ItemDemonBone(String name)
    {
        super(name);
        this.setMaxStackSize(64);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip,  ITooltipFlag flag)
    {
        tooltip.add("Basic Demon bone. Has very little power.");
        super.addInformation(stack, world, tooltip, flag);
    }
}
