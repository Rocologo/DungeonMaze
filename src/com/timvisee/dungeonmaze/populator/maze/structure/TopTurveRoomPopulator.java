package com.timvisee.dungeonmaze.populator.maze.structure;

import java.util.Random;

import com.timvisee.dungeonmaze.Core;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

import com.timvisee.dungeonmaze.DungeonMaze;
import com.timvisee.dungeonmaze.populator.maze.MazeRoomBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.MazeRoomBlockPopulatorArgs;

public class TopTurveRoomPopulator extends MazeRoomBlockPopulator {

    /** General populator constants. */
	public static final int LAYER_MIN = 1;
	public static final int LAYER_MAX = 5;
	public static final float ROOM_CHANCE = .002f;

    // TODO: Implement this feature!
	public static final double CHANCE_TOPTURVE_ADDITION_EACH_LEVEL = -0.167; /* to 2 */

	@Override
	public void populateRoom(MazeRoomBlockPopulatorArgs args) {
		final World world = args.getWorld();
		final Chunk chunk = args.getSourceChunk();
		final Random rand = args.getRandom();
		final int x = args.getX();
		final int y = args.getY();
		final int yCeiling = args.getCeilingY();
		final int z = args.getZ();
			
        // Register the current room as constant room
        DungeonMaze.instance.registerConstantRoom(world.getName(), chunk.getX(), chunk.getZ(), x, y, z);

        // Hull
        chunk.getBlock(x + 3, yCeiling - 2, z + 3).setType(Material.MOSSY_COBBLESTONE);
        chunk.getBlock(x + 3, yCeiling - 2, z + 4).setType(Material.MOSSY_COBBLESTONE);
        chunk.getBlock(x + 4, yCeiling - 2, z + 3).setType(Material.MOSSY_COBBLESTONE);
        chunk.getBlock(x + 4, yCeiling - 2, z + 4).setType(Material.MOSSY_COBBLESTONE);
        chunk.getBlock(x + 2, yCeiling - 1, z + 3).setType(Material.NETHERRACK);
        chunk.getBlock(x + 2, yCeiling - 1, z + 4).setType(Material.GLASS);
        chunk.getBlock(x + 3, yCeiling - 1, z + 2).setType(Material.GLASS);

        Block ore1 = chunk.getBlock(x + 3, yCeiling - 1, z + 3);
        switch(rand.nextInt(5)) {
        case 0:
            ore1.setType(Material.GOLD_ORE);
            break;
        case 1:
            ore1.setType(Material.IRON_ORE);
            break;
        case 2:
            ore1.setType(Material.COAL_ORE);
            break;
        case 3:
            ore1.setType(Material.LAPIS_ORE);
            break;
        case 4:
            ore1.setType(Material.COAL_ORE); // Originally diamond, changed to coal because ore2 could be diamond too
            break;
        default:
            ore1.setType(Material.COAL_ORE);
        }

        chunk.getBlock(x + 3, yCeiling - 1, z + 5).setType(Material.NETHERRACK);
        chunk.getBlock(x + 4, yCeiling - 1, z + 2).setType(Material.NETHERRACK);

        Block ore2 = chunk.getBlock(x + 4, yCeiling - 1, z + 4);
        switch(rand.nextInt(5)) {
        case 0:
            ore2.setType(Material.GOLD_ORE);
            break;
        case 1:
            ore2.setType(Material.IRON_ORE);
            break;
        case 2:
            ore2.setType(Material.COAL_ORE);
            break;
        case 3:
            ore2.setType(Material.LAPIS_ORE);
            break;
        case 4:
            ore2.setType(Material.DIAMOND_ORE);
            break;
        default:
            ore2.setType(Material.COAL_ORE);
        }

        chunk.getBlock(x + 4, yCeiling - 1, z + 5).setType(Material.GLASS);
        chunk.getBlock(x + 5, yCeiling - 1, z + 3).setType(Material.GLASS);
        chunk.getBlock(x + 5, yCeiling - 1, z + 4).setType(Material.NETHERRACK);

        // Spawners
        if(Core.getConfigHandler().isMobSpawnerAllowed("Pig")) {
            chunk.getBlock(x + 3, yCeiling - 1, z + 4).setType(Material.MOB_SPAWNER);
            CreatureSpawner PigSpawner = (CreatureSpawner) chunk.getBlock(x + 3, yCeiling - 1, z + 4).getState();
            PigSpawner.setSpawnedType(EntityType.PIG);
        }

        if(Core.getConfigHandler().isMobSpawnerAllowed("Skeleton")) {
            chunk.getBlock(x + 4, yCeiling - 1, z + 3).setType(Material.MOB_SPAWNER);
            CreatureSpawner PigSpawner2 = (CreatureSpawner) chunk.getBlock(x + 4, yCeiling - 1, z + 3).getState();
            PigSpawner2.setSpawnedType(EntityType.SKELETON);
        }
	}

    @Override
    public float getRoomChance() {
        return ROOM_CHANCE;
    }
	
	/**
	 * Get the minimum layer
	 * @return Minimum layer
	 */
	@Override
	public int getMinimumLayer() {
		return LAYER_MIN;
	}
	
	/**
	 * Get the maximum layer
	 * @return Maximum layer
	 */
	@Override
	public int getMaximumLayer() {
		return LAYER_MAX;
	}
}