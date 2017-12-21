package com.blacksun559.thewardedblock.items.Base;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.interfaces.IModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemTWB extends Item implements IModel
{
    // The base items from The EntityWarded Block
    public ItemTWB(String name)
    {
        setItemName(this, name);
        this.setCreativeTab(TheWardedBlock.thewardedblock);
        this.setMaxStackSize(1);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        TheWardedBlock.proxy.registerItemRender(this, 0, "inventory");
    }

    private static void setItemName(Item item, String itemName)
    {
        item.setRegistryName(Reference.MOD_ID, itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
    {
        super.addInformation(stack, world, tooltip, flag);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return super.getRarity(stack);
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return super.hasEffect(stack);
    }
}
