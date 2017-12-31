package com.blacksun559.thewardedblock.util.handlers;

import com.blacksun559.thewardedblock.blocks.model.WardBakedModel;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.tileentity.TileEntityWard;
import com.blacksun559.thewardedblock.util.interfaces.IModel;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber
public class RegistryHandler 
{

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));

        GameRegistry.registerTileEntity(TileEntityWard.class, "tile_ward");

        registerOreDict();
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : ModItems.ITEMS)
        {
            if(item instanceof IModel)
            {
                ((IModel)item).registerModels();
            }
        }

        for(Block block : ModBlocks.BLOCKS)
        {
            if(block instanceof IModel)
            {
                ((IModel)block).registerModels();
            }
        }
    }

    public static void registerOreDict()
    {
        OreDictionary.registerOre("ingotSilver", ModItems.INGOT_SILVER);
        OreDictionary.registerOre("ingotElectrum", ModItems.INGOT_ELECTRUM);
        OreDictionary.registerOre("blockSilver", ModBlocks.BLOCK_SILVER);
        OreDictionary.registerOre("blockElectrum", ModBlocks.BLOCK_ELECTRUM);

        OreDictionary.registerOre("oreCrystal", new ItemStack(ModBlocks.ORE_END, 1, 0));
        OreDictionary.registerOre("oreCrystal", new ItemStack(ModBlocks.ORE_NETHER, 1, 0));
        OreDictionary.registerOre("oreCrystal", new ItemStack(ModBlocks.ORE_OVERWORLD, 1, 0));
        OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.ORE_END, 1, 1));
        OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.ORE_NETHER, 1, 1));
        OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.ORE_OVERWORLD, 1, 1));
    }

    @SideOnly(Side.CLIENT)
    public static void registerWardCamo()
    {
        StateMapperBase ignoreState = new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState iBlockState)
            {
                return WardBakedModel.variantTag;
            }
        };

        ModelLoader.setCustomStateMapper(ModBlocks.BLOCK_WARD, ignoreState);
        MinecraftForge.EVENT_BUS.register(ModelBakeEventHandler.instance);
        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("thewardedblock:block_ward", "inventory");
        final int DEFAULT_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(new ItemBlock(ModBlocks.BLOCK_WARD), DEFAULT_SUBTYPE, itemModelResourceLocation);
    }
}
