package com.spiralsky.accelerator.Blocks;

import com.spiralsky.accelerator.BlockEntities.AcceleratorBlockEntity;
import com.spiralsky.accelerator.Config;
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
    int tier;
    public AcceleratorBlock(Block.Properties properties, int tier) {
        super(properties);
        this.tier = tier;
    }
    public BlockEntity newBlockEntity(@NotNull BlockPos pos,@NotNull BlockState state) {
        AcceleratorBlockEntity blockEntity = BlockEntityInit.ACCELERATOR_BLOCKENTITY.get().create(pos, state);
        Objects.requireNonNull(blockEntity).setSpeed(getSpeed(this.tier));
        return blockEntity;
    }
    public int getSpeed(int tier) {
        return switch (tier) {
            case 1 -> Config.accelerator1Speed;
            case 2 -> Config.accelerator2Speed;
            case 3 -> Config.accelerator3Speed;
            case 4 -> Config.accelerator4Speed;
            default -> 0;
        };
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return TickableBlockEntity.getTickerHelper(level);
    }
}