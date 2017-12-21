package com.blacksun559.thewardedblock.world.gen;

import com.blacksun559.thewardedblock.blocks.BlockOres;
import com.blacksun559.thewardedblock.init.ModBlocks;
import com.blacksun559.thewardedblock.util.handlers.EnumHandler;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator
{
    private WorldGenerator ore_end_crystal, ore_nether_crystal, ore_overworld_crystal;
    private WorldGenerator ore_end_silver, ore_nether_silver, ore_overworld_silver;

    public WorldGenCustomOres()
    {
        //End Ores
        ore_end_crystal = new WorldGenMinable(ModBlocks.ORE_END.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.CRYSTAL), 20, BlockMatcher.forBlock(Blocks.END_STONE));
        ore_end_silver = new WorldGenMinable(ModBlocks.ORE_END.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.SILVER), 20, BlockMatcher.forBlock(Blocks.END_STONE));

        //Nether Ores
        ore_nether_crystal = new WorldGenMinable(ModBlocks.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.CRYSTAL), 20, BlockMatcher.forBlock(Blocks.NETHERRACK));
        ore_nether_silver = new WorldGenMinable(ModBlocks.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.SILVER), 20, BlockMatcher.forBlock(Blocks.NETHERRACK));

        //Overworld Ores
        ore_overworld_crystal = new WorldGenMinable(ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.CRYSTAL), 20, BlockMatcher.forBlock(Blocks.STONE));
        ore_overworld_silver = new WorldGenMinable(ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.OreEnumType.SILVER), 20, BlockMatcher.forBlock(Blocks.STONE));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

        switch(world.provider.getDimensionType())
        {
            case NETHER:
                for(int i = 0; i < 16; i++)
                {
                    ore_nether_crystal.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(128), random.nextInt(16)));
                    ore_nether_silver.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(128), random.nextInt(16)));
                }
                break;

            case OVERWORLD:
                for(int i = 0; i < 16; i++)
                {
                    ore_overworld_crystal.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(128), random.nextInt(16)));
                    ore_overworld_silver.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(128), random.nextInt(16)));
                }
                break;

            case THE_END:
                for(int i = 0; i < 16; i++)
                {
                    ore_end_crystal.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(128), random.nextInt(16)));
                    ore_end_silver.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(128), random.nextInt(16)));
                }
                break;
        }
    }
}
