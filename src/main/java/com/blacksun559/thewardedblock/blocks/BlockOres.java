package com.blacksun559.thewardedblock.blocks;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.blocks.item.ItemBlockVariant;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.handlers.EnumHandler;
import com.blacksun559.thewardedblock.util.interfaces.IModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockOres extends Block implements IModel
{
    public static final IProperty<EnumHandler.EnumType> VARIANT = PropertyEnum.create("variant", EnumHandler.EnumType.class);


    private final String dimension;

    public BlockOres(String name, String dimension)
    {
        super(Material.ROCK);
        this.dimension = dimension;
        this.setCreativeTab(TheWardedBlock.thewardedblock);
        this.setRegistryName(Reference.MOD_ID, name);
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.CRYSTAL));

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlockVariant(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, VARIANT);
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetaData(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VARIANT).getMeta();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for(final EnumHandler.EnumType enumType : EnumHandler.EnumType.values())
        {
            items.add(new ItemStack(this, 1, enumType.getMeta()));
        }
    }

    public String getName(final ItemStack stack)
    {
        final int metadata = stack.getMetadata();



        return EnumHandler.EnumType.byMetaData(metadata).getName();
    }

    @Override
    public void registerModels() {
        for(int i = 0; i < EnumHandler.EnumType.values().length; i++)
        {
            TheWardedBlock.proxy.registerVariantRender(Item.getItemFromBlock(this), i, "ore_" + this.dimension, "variant=" + EnumHandler.EnumType.values()[i].getName());
        }
    }
}
