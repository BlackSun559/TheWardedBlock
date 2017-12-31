package com.blacksun559.thewardedblock.items;

import com.blacksun559.thewardedblock.items.Base.ItemTWB;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemTome extends ItemTWB
{
    public ItemTome(String name)
    {
        super(name);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
    {
        tooltip.add("May contain ancient warding knowledge. Take a look inside.");
        super.addInformation(stack, world, tooltip, flag);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

    //TODO make tomes assign knowledge on right click and then be removed
    //TODO make rarity change with subitem and higher rarity change tooltip and ward knowledge
    //TODO subitems for differing textures
}
