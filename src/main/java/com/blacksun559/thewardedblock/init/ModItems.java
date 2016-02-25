package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.item.ItemTWB;
import com.blacksun559.thewardedblock.item.WardBrush;
import com.blacksun559.thewardedblock.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemTWB wardBrush = new WardBrush();

    public static void Init()
    {
        GameRegistry.registerItem(wardBrush, "wardBrush");
    }
}
