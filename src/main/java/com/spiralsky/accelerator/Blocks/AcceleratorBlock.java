package com.spiralsky.accelerator.Blocks;

import com.spiralsky.accelerator.BlockEntities.AcceleratorBlockEntity;
import com.spiralsky.accelerator.Init.BlockEntityInit;
import com.spiralsky.accelerator.util.TickableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class AcceleratorBlock extends Block implements EntityBlock{
    int speed;
    public AcceleratorBlock(Block.Properties properties, int speed) {
        super(properties);
        this.speed = speed;
    }
    public BlockEntity newBlockEntity(@NotNull BlockPos pos,@NotNull BlockState state) {
        AcceleratorBlockEntity blockEntity = BlockEntityInit.ACCELERATOR_BLOCKENTITY.get().create(pos, state);
        Objects.requireNonNull(blockEntity).setSpeed(this.speed);
        return blockEntity;
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return TickableBlockEntity.getTickerHelper(level);
    }
}