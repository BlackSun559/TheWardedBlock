package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.block.BlockTileEntityTWB;
import com.blacksun559.thewardedblock.block.BlockWardBench;
import com.blacksun559.thewardedblock.reference.Names;
import com.blacksun559.thewardedblock.reference.Reference;
import com.blacksun559.thewardedblock.tileentity.TileEntityTWB;
import com.blacksun559.thewardedblock.tileentity.TileEntityWardBench;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockTileEntityTWB wardBench = new BlockWardBench();

    public static void Init()
    {
        GameRegistry.registerBlock(wardBench, Names.Blocks.WARD_BENCH);
    }
}
