package com.blacksun559.thewardedblock.init;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes
{
    public static void registerRecipes()
    {
        addSmeltingRecipes();
    }

    private static void addSmeltingRecipes()
    {
        NonNullList<ItemStack> ores = OreDictionary.getOres("oreSilver");

        for(ItemStack ore : ores)
        {
            GameRegistry.addSmelting(ore, new ItemStack(ModItems.INGOT_SILVER), 0.35f);
        }
    }
}
