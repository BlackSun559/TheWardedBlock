package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.items.Base.ItemFoodTWB;
import com.blacksun559.thewardedblock.items.Base.ItemTWB;
import com.blacksun559.thewardedblock.items.*;
import com.blacksun559.thewardedblock.reference.Names;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final ItemTWB BONE_DEMON = new ItemDemonBone(Names.Items.BONE_DEMON);
    public static final ItemTWB WARD_BRUSH = new ItemWardBrush(Names.Items.WARD_BRUSH);
    public static final ItemTWB INGOT_SILVER = new ItemSilverIngot(Names.Items.INGOT_SILVER);
    public static final ItemTWB INGOT_ELECTRUM = new ItemElectrumIngot(Names.Items.INGOT_ELECTRUM);
    public static final ItemTWB ITEM_DEBUG = new ItemDebug(Names.Items.ITEM_DEBUG);
    public static final ItemTWB ITEM_BONE_NEEDLE = new ItemBoneNeedle(Names.Items.ITEM_BONE_NEEDLE);
    public static final ItemTWB ITEM_IRON_NEEDLE = new ItemIronNeedle(Names.Items.ITEM_IRON_NEEDLE);
    public static final ItemTWB ITEM_FILE = new ItemFile(Names.Items.ITEM_FILE);
    public static final ItemTWB ITEM_KNIFE = new ItemKnife(Names.Items.ITEM_KNIFE);
    public static final ItemTWB ITEM_TOME = new ItemTome(Names.Items.ITEM_TOME);
    public static final ItemTWB ITEM_TOOLKIT = new ItemToolkit(Names.Items.ITEM_TOOLKIT);

    public static final ItemFoodTWB MEAT_DEMON = new ItemDemonMeat(Names.Items.MEAT_DEMON);
}