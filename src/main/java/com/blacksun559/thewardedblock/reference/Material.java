package com.blacksun559.thewardedblock.reference;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Material
{
    public static final class Tools
    {
        public static final Item.ToolMaterial DEMON_BONE = EnumHelper.addToolMaterial(Names.Materials.DEMON_BONE, 3, 1500, 12f, 5f, 15);
        public static final Item.ToolMaterial WARD_SWORD = EnumHelper.addToolMaterial(Names.Materials.WARD_SWORD, 3, 2500, 16f, 10f, 25);
    }
}
