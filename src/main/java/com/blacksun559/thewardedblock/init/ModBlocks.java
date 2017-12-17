package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.blocks.BlockOres;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block ORE_END = new BlockOres("ore_end", "end");
    public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
    public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
}