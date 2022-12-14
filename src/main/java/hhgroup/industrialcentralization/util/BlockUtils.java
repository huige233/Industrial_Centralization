package hhgroup.industrialcentralization.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.LinkedList;
import java.util.List;

public class BlockUtils {

    /**
     * Checks if an entity is in range of the position passed in.
     *
     * @param pos    Position of block.
     * @param entity Entity to check.
     * @param range  Range to check.
     * @return True if entity in range.
     */
    public static boolean isEntityInRange(BlockPos pos, Entity entity, int range) {
        return entity.getDistanceSq(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= range;
    }

    /**
     * Simply fires a lighting update for a block.
     *
     * @param world    World for the update.
     * @param position Pos to update.
     */
    public static void fireLightUpdate(World world, BlockPos position) {
        world.notifyLightSet(position);
    }

    /**
     * Fires a block update.
     * Assumes the BlockState has not changed but a update is still needed.
     *
     * @param world The world.
     * @param pos   The position.
     */
    public static void fireBlockUpdate(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        world.notifyBlockUpdate(pos, state, state, 3);
    }

    /**
     * Fires a block update.
     * Assumes the BlockState has not changed but a update is still needed.
     *
     * @param tileEntity The tile to fire an update for.
     */
    public static void fireBlockUpdate(TileEntity tileEntity) {
        fireBlockUpdate(tileEntity.getWorld(), tileEntity.getPos());
    }

    /**
     * Gets the adjacent blocks for a position.
     *
     * @param pos             Main position.
     * @param includeVertical Weather to include vertical facings.
     * @return List of adjacent blocks.
     */
    public static List<BlockPos> getAdjacent(BlockPos pos, boolean includeVertical) {
        LinkedList<BlockPos> adjacentPositions = new LinkedList<>();
        for (EnumFacing step : (includeVertical ? EnumFacing.VALUES : EnumFacing.HORIZONTALS)) {
            adjacentPositions.add(pos.offset(step));
        }

        return adjacentPositions;
    }

}