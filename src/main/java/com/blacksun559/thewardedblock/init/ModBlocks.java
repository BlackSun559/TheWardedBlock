package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.block.BlockTWB;
import com.blacksun559.thewardedblock.block.WardBench;
import com.blacksun559.thewardedblock.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockTWB wardBench = new WardBench();

    public static void Init()
    {
        GameRegistry.registerBlock(wardBench, wardBench.getUnlocalizedName().substring(20));
    }
}
