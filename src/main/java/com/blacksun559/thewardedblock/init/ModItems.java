package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.item.*;
import com.blacksun559.thewardedblock.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    private static ItemTWB demonBone;
    private static ItemTWB wardBrush;

    public static void Init()
    {
        demonBone = new ItemDemonBone("demonBone");
        wardBrush = new ItemWardBrush("wardBrush");

        registerItems();
    }

    public static void registerItems()
    {
        GameRegistry.register(demonBone, new ResourceLocation(Reference.MOD_ID, "demonBone"));
        GameRegistry.register(wardBrush, new ResourceLocation(Reference.MOD_ID, "wardBrush"));
    }

    public static void registerRenders()
    {
        registerRender(demonBone);
        registerRender(wardBrush);
    }

    public static void registerRender(ItemTWB item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
