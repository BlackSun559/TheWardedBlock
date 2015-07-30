package com.thewardedmen.thewardedblock.init;

import com.thewardedmen.thewardedblock.item.ItemTWB;
import com.thewardedmen.thewardedblock.item.WardBrush;
import com.thewardedmen.thewardedblock.reference.Reference;
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
