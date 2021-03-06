package com.timvisee.dungeonmaze.populator.maze.structure;

import org.bukkit.Chunk;
import org.bukkit.Material;

import com.timvisee.dungeonmaze.populator.maze.MazeRoomBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.MazeRoomBlockPopulatorArgs;

public class StairsPopulator extends MazeRoomBlockPopulator {

    /** General populator constants. */
	public static final int LAYER_MIN = 1;
	public static final int LAYER_MAX = 6;
	public static final float ROOM_CHANCE = .02f;

	@Override
	public void populateRoom(MazeRoomBlockPopulatorArgs args) {
		final Chunk chunk = args.getSourceChunk();
		final int x = args.getChunkX();
		final int y = args.getChunkY();
		final int yFloor = args.getFloorY();
		final int z = args.getChunkZ();

        if(chunk.getBlock(x, y - 1, z).getType() == Material.AIR)
            return;

        chunk.getBlock(x + 5, yFloor + 1, z + 2).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 6, yFloor + 1, z + 2).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 5, yFloor + 1 + 1, z + 3).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 6, yFloor + 1 + 1, z + 3).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 5, yFloor + 1 + 2, z + 4).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 6, yFloor + 1 + 2, z + 4).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 5, yFloor + 1 + 2, z + 5).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 6, yFloor + 1 + 2, z + 5).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 5, yFloor + 1 + 2, z + 6).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 6, yFloor + 1 + 2, z + 6).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 4, yFloor + 1 + 3, z + 5).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 4, yFloor + 1 + 3, z + 6).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 3, yFloor + 1 + 4, z + 5).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 3, yFloor + 1 + 4, z + 6).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 2, yFloor + 1 + 5, z + 5).setType(Material.COBBLESTONE_STAIRS);
        chunk.getBlock(x + 2, yFloor + 1 + 5, z + 6).setType(Material.COBBLESTONE_STAIRS);

        chunk.getBlock(x + 3, yFloor + 1 + 5, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 3, yFloor + 1 + 5, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 4, yFloor + 1 + 5, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 4, yFloor + 1 + 5, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 5, yFloor + 1 + 5, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 5, yFloor + 1 + 5, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 2, yFloor + 1 + 6, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 2, yFloor + 1 + 6, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 3, yFloor + 1 + 6, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 3, yFloor + 1 + 6, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 4, yFloor + 1 + 6, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 4, yFloor + 1 + 6, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 5, yFloor + 1 + 6, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 5, yFloor + 1 + 6, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 2, yFloor + 1 + 7, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 2, yFloor + 1 + 7, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 3, yFloor + 1 + 7, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 3, yFloor + 1 + 7, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 4, yFloor + 1 + 7, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 4, yFloor + 1 + 7, z + 6).setType(Material.AIR);
        chunk.getBlock(x + 5, yFloor + 1 + 7, z + 5).setType(Material.AIR);
        chunk.getBlock(x + 5, yFloor + 1 + 7, z + 6).setType(Material.AIR);

        // Set the data values!
        chunk.getBlock(x + 5, yFloor + 1, z + 2).setData((byte) 2);
        chunk.getBlock(x + 6, yFloor + 1, z + 2).setData((byte) 2);
        chunk.getBlock(x + 5, yFloor + 1 + 1, z + 3).setData((byte) 2);
        chunk.getBlock(x + 6, yFloor + 1 + 1, z + 3).setData((byte) 2);
        chunk.getBlock(x + 5, yFloor + 1 + 2, z + 4).setData((byte) 2);
        chunk.getBlock(x + 6, yFloor + 1 + 2, z + 4).setData((byte) 2);
        chunk.getBlock(x + 4, yFloor + 1 + 3, z + 5).setData((byte) 1);
        chunk.getBlock(x + 4, yFloor + 1 + 3, z + 6).setData((byte) 1);
        chunk.getBlock(x + 3, yFloor + 1 + 4, z + 5).setData((byte) 1);
        chunk.getBlock(x + 3, yFloor + 1 + 4, z + 6).setData((byte) 1);
        chunk.getBlock(x + 2, yFloor + 1 + 5, z + 5).setData((byte) 1);
        chunk.getBlock(x + 2, yFloor + 1 + 5, z + 6).setData((byte) 1);

        chunk.getBlock(x + 5, yFloor + 1 + 1, z + 4).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 6, yFloor + 1 + 1, z + 4).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 5, yFloor + 1 + 1, z + 5).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 6, yFloor + 1 + 1, z + 5).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 5, yFloor + 1 + 1, z + 6).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 6, yFloor + 1 + 1, z + 6).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 4, yFloor + 1 + 2, z + 5).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 4, yFloor + 1 + 2, z + 6).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 3, yFloor + 1 + 3, z + 5).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 3, yFloor + 1 + 3, z + 6).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 2, yFloor + 1 + 4, z + 5).setType(Material.COBBLESTONE);
        chunk.getBlock(x + 2, yFloor + 1 + 4, z + 6).setType(Material.COBBLESTONE);
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