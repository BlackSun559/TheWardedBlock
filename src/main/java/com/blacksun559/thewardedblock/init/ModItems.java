package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.items.*;
import com.blacksun559.thewardedblock.reference.Names;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final ItemTWB BONE_DEMON = new ItemDemonBone(Names.Items.BONE_DEMON);
    public static final ItemTWB WARD_BRUSH = new ItemWardBrush(Names.Items.WARD_BRUSH);
}
