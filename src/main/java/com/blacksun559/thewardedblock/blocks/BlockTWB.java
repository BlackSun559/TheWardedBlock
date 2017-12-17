package com.blacksun559.thewardedblock.blocks;

import com.blacksun559.thewardedblock.TheWardedBlock;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.init.ModItems;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.util.interfaces.IModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockTWB extends Block implements IModel
{
    public BlockTWB(String name, Material material)
    {
        this(material);
        this.setRegistryName(Reference.MOD_ID, name);
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(TheWardedBlock.thewardedblock);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockTWB(Material material)
    {
        super(material);
    }

    @Override
    public void registerModels()
    {
        TheWardedBlock.proxy.registerItemRender(Item.getItemFromBlock(this), 0, "inventory");
    }
}
