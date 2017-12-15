package com.blacksun559.thewardedblock.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemWardBrush extends ItemTWB
{
    public ItemWardBrush(String name)
    {
        super(name);
        this.setMaxDamage(250);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
    {
        return super.onItemRightClick(itemStack, world, player, hand);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
