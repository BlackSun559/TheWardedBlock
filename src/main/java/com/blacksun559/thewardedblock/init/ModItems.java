package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.item.*;
import com.blacksun559.thewardedblock.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemTWB wardBrush = new ItemWardBrush();
    public static final FoodItemTWB demonMeat = new ItemDemonMeat();
    public static final ItemWardSword wardSword = new ItemWardSword();

    public static void Init()
    {
        GameRegistry.registerItem(wardBrush, wardBrush.getUnlocalizedName().substring(20));
        GameRegistry.registerItem(demonMeat, demonMeat.getUnlocalizedName().substring(20));
        GameRegistry.registerItem(wardSword, wardSword.getUnlocalizedName().substring(20));
    }
}
