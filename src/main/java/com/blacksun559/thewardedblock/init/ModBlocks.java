package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.blocks.BlockCrystalOre;
import com.blacksun559.thewardedblock.blocks.BlockTWB;
import com.blacksun559.thewardedblock.reference.Names;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<BlockTWB> BLOCKS = new ArrayList<>();

    public static final BlockTWB ORE_CRYSTAL = new BlockCrystalOre(Names.Blocks.ORE_CRYSTAL, Material.ROCK);
}
