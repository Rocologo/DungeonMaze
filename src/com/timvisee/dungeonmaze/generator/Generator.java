package com.timvisee.dungeonmaze.generator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.timvisee.dungeonmaze.Core;
import com.timvisee.dungeonmaze.DungeonMaze;
import com.timvisee.dungeonmaze.generator.chunk.BukkitChunk;
import com.timvisee.dungeonmaze.populator.maze.decoration.*;
import com.timvisee.dungeonmaze.world.dungeon.chunk.DungeonChunk;
import com.timvisee.dungeonmaze.world.dungeon.chunk.grid.DungeonChunkGrid;
import com.timvisee.dungeonmaze.world.dungeon.chunk.grid.DungeonChunkGridManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import com.timvisee.dungeonmaze.populator.maze.spawner.BlazeSpawnerRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.spawner.BossRoomEasyPopulator;
import com.timvisee.dungeonmaze.populator.maze.spawner.BossRoomHardPopulator;
import com.timvisee.dungeonmaze.populator.maze.spawner.BossRoomInsanePopulator;
import com.timvisee.dungeonmaze.populator.maze.spawner.CreeperSpawnerRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.spawner.SilverfishBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.spawner.SpawnerPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.AbandonedDefenceCastleRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.EntrancePopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.FloodedRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.GravelPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.GreatFurnaceRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.HighRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.LibraryRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.MassiveRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.OasisChunkPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.RailPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.RuinsPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.SanctuaryPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.SandPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.SpawnChamberPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.StairsPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.StrutPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.TopTurveRoomPopulator;
import com.timvisee.dungeonmaze.populator.maze.structure.WaterWellRoomPopulator;
import com.timvisee.dungeonmaze.populator.surface.plants.FlowerPopulator;
import com.timvisee.dungeonmaze.populator.surface.plants.TallGrassPopulator;
import com.timvisee.dungeonmaze.populator.surface.plants.TreePopulator;

public class Generator extends ChunkGenerator {

	/** Defines the Dungeon Maze plugin instance. */
	public static DungeonMaze plugin;

	/**
	 * Constructor.
	 *
	 * @param instance The Dungeon Maze instance.
	 */
	public Generator(DungeonMaze instance) {
		// Set the Dungeon Maze instance
		plugin = instance;
	}

	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
        //noinspection unchecked
        return (List<BlockPopulator>)(List<?>) Arrays.asList(
				new BrokenWallsPopulator(),
				new SpawnChamberPopulator(),
				new OresInGroundPopulator(),
				new OasisChunkPopulator(),
				new BossRoomHardPopulator(),
				new BossRoomInsanePopulator(),
				new LibraryRoomPopulator(),
				new AbandonedDefenceCastleRoomPopulator(),
				//new ArmoryRoomPopulator(),
				new WaterWellRoomPopulator(),
				new SanctuaryPopulator(),
				new BlazeSpawnerRoomPopulator(),
				new HighRoomPopulator(),
				new BossRoomEasyPopulator(),
				new MassiveRoomPopulator(),
				new FloodedRoomPopulator(),
				new GreatFurnaceRoomPopulator(),
				new EntrancePopulator(),
				new TreePopulator(),
				new TallGrassPopulator(),
				new FlowerPopulator(),
				new MossPopulator(),
				new CrackedStoneBrickPopulator(),
				new NetherrackPopulator(),
				new SoulsandPopulator(),
				new CoalOrePopulator(),
				new StrutPopulator(),
				new StairsPopulator(),
				new LadderPopulator(),
				new PoolPopulator(),
				new LavaOutOfWallPopulator(),
				new WaterOutOfWallPopulator(),
				new RailPopulator(),
				new SkullPopulator(),
				new TopTurveRoomPopulator(),
				new CreeperSpawnerRoomPopulator(),
				new GravePopulator(),
				new ChestPopulator(),
				new SpawnerPopulator(),
				new SandPopulator(),
				new GravelPopulator(),
				new RuinsPopulator(),
				new IronBarPopulator(),
				new SlabPopulator(),
				new TorchPopulator(),
				new LanternPopulator(),
                new PumpkinPopulator(),
				new SilverfishBlockPopulator(),
				new WebPopulator(),
				new VinePopulator(),
				new CobblestonePopulator(),
				new MushroomPopulator(),
				new ExplosionPopulator()
		);
	}

	@SuppressWarnings({"ConstantConditions", "deprecation"})
	@Override
	public short[][] generateExtBlockSections(World world, Random rand, int chunkX, int chunkZ, BiomeGrid biomes) {
        // Get or create the dungeon chunk data
        DungeonChunk dungeonChunk;

        try {
            // Get the chunk grid manager, and make sure it's valid
            final DungeonChunkGridManager chunkGridManager = Core.getDungeonChunkGridManager();
            if(chunkGridManager == null) {
                Core.getLogger().error("Unable to generate Dungeon Maze chunk, couldn't access the chunk grid manager!");
                return null;
            }

            // Create or get the chunk grid for the current world
            final DungeonChunkGrid dungeonChunkGrid = chunkGridManager.getOrCreateChunkGrid(world);

            // Create or get the chunk data for the current chunk
            dungeonChunk = dungeonChunkGrid.getOrCreateChunk(chunkX, chunkZ);

        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }

        // TODO: Generate the room data for the Dungeon Chunk before generating it!
        // TODO: Clear the data on the current dungeon chunk?

		// Create a chunk
		BukkitChunk chunk = dungeonChunk.createBukkitChunk();

		// This will set the whole floor to stone (the floor of each chunk)
		chunk.setLayers(0, 30 + 3, Material.STONE);

		// The layers for each 5 rooms in the variable y
        for(int y = 30; y < 30 + (7 * 6); y += 6) {

			// The 4 rooms on each layer saved in the variables x and z
            for(int x = 0; x < 16; x += 8) {
                for(int z = 0; z < 16; z += 8) {

					int xr = (rand.nextInt(3) - 1) * (x + 7);
					int zr = (rand.nextInt(3) - 1) * (z + 7);

					int yFloor = rand.nextInt(2);

					// All the y of the room in the variable y2
					for(int y2 = y + yFloor; y2 < y + 8; y2++) {

						// All the x of the room in the variable x2
						for(int x2 = x; x2 < x + 8; x2++) {

							// All the z of the room in the variable z2
							for(int z2 = z; z2 < z + 8; z2++) {

								// Make the bottom of the room
								if(y2 == y + yFloor)
									for(int xb = x; xb < x + 8; xb++)
										for(int zb = z; zb < z + 8; zb++)
											chunk.setBlock(xb, y2, zb, Material.COBBLESTONE);

								// Fill the walls of the place with cobblestone
								if((x2 == x || x2 == x + 7) && (z2 == z || z2 == z + 7))
									chunk.setBlock(x2, y2, z2, (short) 98); // 98 = Stone brick
								else if (xr == x2)
									chunk.setBlock(x2, y2, z2, (short) 98); // 98 = Stone brick
								else if (zr == z2)
									chunk.setBlock(x2, y2, z2, (short) 98); // 98 = Stone brick
								else
									chunk.clearBlock(x2, y2, z2);
							}
						}
					}
				}
			}
		}

		// Create the nose generator which generates wave forms to use for the surface.
		Random random = new Random(world.getSeed());
		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(random, 8);
		octave.setScale(1 / 48.0);

		// Generate the ceiling and the grass land
		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				double height = octave.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 4 + 9;

				chunk.setBlock(x, 30+(7*6), z, Material.COBBLESTONE);
				for(int y = 30 + (7 * 6) + 1; y < 30 + (7 * 6) + 4; y++)
					chunk.setBlock(x, y, z, Material.STONE);

				// Get the current biome
				Biome biome = world.getBiome((chunkX * 16) + x, (chunkZ * 16) + z);

				if(biome.equals(Biome.DESERT) || biome.equals(Biome.DESERT_HILLS)) {
					for(int y = 30 + (7 * 6) + 4; y < 30 + (7 * 6) + 2 + height; y++)
						chunk.setBlock(x, y, z, Material.SAND);

				} else if(biome.equals(Biome.MUSHROOM_ISLAND) || biome.equals(Biome.MUSHROOM_ISLAND)){
					for(int y = 30 + (7 * 6) + 4; y < 30 + (7 * 6) + 2 + height; y++)
						chunk.setBlock(x, y, z, Material.DIRT);
					chunk.setBlock(x, (int) (30 + (7 * 6) + 2 + height), z, Material.MYCEL);

				} else {
					for(int y = 30 + (7 * 6) + 4; y < 30+(7*6)+2+height; y++)
						chunk.setBlock(x, y, z, Material.DIRT);
					chunk.setBlock(x, (int) (30 + (7 * 6) + 2 + height), z, Material.GRASS);
				}
			}
		}

		// Set the bottom layer to bedrock
		chunk.setLayer(0, Material.BEDROCK);

		// Return the chunk data
		return chunk.getChunkData();
	}

	/**
	 * Define whether monsters can spawn in the world. This overwrites the server settings.
	 *
	 * @param world The world.
	 * @param x The X coordinate of the monster.
	 * @param z The Z coordinate of the monster.
	 *
	 * @return True if the monster may spawn, false otherwise.
	 */
	@Override
	public boolean canSpawn(World world, int x, int z) {
		// TODO: Make sure the world is a Dungeon Maze world, return the setting from the config.

		return true;
	}

	/**
	 * Get the spawn location of a Dungeon Maze world.
	 *
	 * @param world The world.
	 * @param random The random seed.
	 *
	 * @return The spawn location for the player.
	 */
	@Override
	public Location getFixedSpawnLocation(World world, Random random) {
		// TODO: Make sure the world is a Dungeon Maze world?

		return new Location(world, 4, 68, 4);
	}
}