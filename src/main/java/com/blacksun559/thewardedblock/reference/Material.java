package com.blacksun559.thewardedblock.reference;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Material
{
    public static final class Tools
    {
        public static final Item.ToolMaterial BONE_DEMON = EnumHelper.addToolMaterial(Names.Materials.BONE_DEMON, 3, 1500, 12f, 5f, 15);
        public static final Item.ToolMaterial WARD_SWORD = EnumHelper.addToolMaterial(Names.Materials.SWORD_WARD, 3, 2500, 16f, 10f, 25);
    }
}
