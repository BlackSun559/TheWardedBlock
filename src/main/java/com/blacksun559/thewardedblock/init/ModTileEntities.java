package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.reference.Names;
import com.blacksun559.thewardedblock.tileentity.TileEntityTWB;
import com.blacksun559.thewardedblock.tileentity.TileEntityWardBench;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityWardBench.class, Names.Blocks.WARD_BENCH);
    }
}
