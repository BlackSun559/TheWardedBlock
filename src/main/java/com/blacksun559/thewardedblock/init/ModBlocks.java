package com.blacksun559.thewardedblock.init;

import com.blacksun559.thewardedblock.blocks.BlockElectrum;
import com.blacksun559.thewardedblock.blocks.BlockOres;
import com.blacksun559.thewardedblock.blocks.BlockSilver;
import com.blacksun559.thewardedblock.blocks.BlockWardedGlass;
import com.blacksun559.thewardedblock.blocks.base.BlockTWB;
import com.blacksun559.thewardedblock.blocks.ward.BlockBarrier;
import com.blacksun559.thewardedblock.blocks.ward.BlockWard;
import com.blacksun559.thewardedblock.reference.Names;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block ORE_END = new BlockOres(Names.Blocks.ORE_END, Names.Dimensions.END);
    public static final Block ORE_NETHER = new BlockOres(Names.Blocks.ORE_NETHER, Names.Dimensions.NETHER);
    public static final Block ORE_OVERWORLD = new BlockOres(Names.Blocks.ORE_OVERWORLD, Names.Dimensions.OVERWORLD);
    public static final Block BLOCK_BARRIER = new BlockBarrier(Names.Blocks.BLOCK_BARRIER);
    public static final BlockTWB BLOCK_SILVER = new BlockSilver(Names.Blocks.BLOCK_SILVER);
    public static final BlockTWB BLOCK_ELECTRUM = new BlockElectrum(Names.Blocks.BLOCK_ELECTRUM);
    public static final BlockTWB BLOCK_WARD = new BlockWard(Names.Blocks.BLOCK_WARD);
    public static final BlockTWB BLOCK_WARDED_GLASS = new BlockWardedGlass(Names.Blocks.BLOCK_WARDED_GLASS);
}