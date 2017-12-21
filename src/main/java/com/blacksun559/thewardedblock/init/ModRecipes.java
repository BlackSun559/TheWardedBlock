package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.blocks.BlockOres;
import com.blacksun559.thewardedblock.util.handlers.EnumHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes
{
    public static void registerRecipes()
    {
        addSmeltingRecipes();
    }

    private static void addSmeltingRecipes()
    {
        GameRegistry.addSmelting(ModBlocks.ORE_END.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.SILVER).getBlock(), new ItemStack(ModItems.INGOT_SILVER), 0.35f);
        GameRegistry.addSmelting(ModBlocks.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.SILVER).getBlock(), new ItemStack(ModItems.INGOT_SILVER), 0.35f);
        GameRegistry.addSmelting(ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.SILVER).getBlock(), new ItemStack(ModItems.INGOT_SILVER), 0.35f);
    }
}
