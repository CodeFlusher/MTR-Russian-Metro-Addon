package ru.weryskok.mtrrumetro.blocks;

import mtr.block.IBlock;
import mtr.mappings.BlockDirectionalMapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockMoscowOldTicketBarrierSideCover extends BlockDirectionalMapper {
    public BlockMoscowOldTicketBarrierSideCover(){
        super(Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 5).noOcclusion());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        final Direction facing = IBlock.getStatePropertySafe(state, FACING);
        return IBlock.getVoxelShapeByDirection(10.9, 0.0, -2.0, 16.0, 24.1, 19.5, facing);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        final Direction facing = IBlock.getStatePropertySafe(state, FACING);
        final VoxelShape base = IBlock.getVoxelShapeByDirection(10.9, 0.0, -2.0, 16.0, 24.1, 19.5, facing);
        return base;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
