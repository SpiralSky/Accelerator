package com.spiralsky.accelerator.BlockEntities;

import com.spiralsky.accelerator.Init.BlockEntityInit;
import com.spiralsky.accelerator.util.TickableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import org.jetbrains.annotations.NotNull;

public class AcceleratorBlockEntity extends BlockEntity implements TickableBlockEntity{
    double tickInterval;
    int tickCounter;
    int speed;
    public AcceleratorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.ACCELERATOR_BLOCKENTITY.get(), pos, state);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        this.tickInterval = Math.floor(10f/speed);
    }
    //@Override
    public void tick() {
        this.tickCounter = this.tickCounter < this.tickInterval ? this.tickCounter + 1 : 0;
        if (level != null && !level.isClientSide) {

            BlockPos pos = worldPosition.offset(0,0,0);
            BlockPos.betweenClosed(pos.offset(2,2,2),pos.offset(-2,-2,-2)).forEach(blockPos -> {
                updateBlockEntityAtPos(blockPos);
                if (this.tickCounter == 0) {
                    updateCropsAtPos(blockPos);
                }
            });
        }
    }
    public void updateCropsAtPos(@NotNull BlockPos blockPos) {
        assert level != null;
        BlockState cropState = level.getBlockState(blockPos);
        Block cropBlock = cropState.getBlock();
        if (cropBlock instanceof IPlantable) {
            cropBlock.randomTick(cropState, (ServerLevel) level, blockPos, level.random);
        }
    }
    public void updateBlockEntityAtPos(@NotNull BlockPos blockPos) {
        assert level != null;
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof AcceleratorBlockEntity || blockEntity == null) {
            return;
        }
        BlockEntityTicker<BlockEntity> ticker = blockEntity.getBlockState().getTicker(level, (BlockEntityType<BlockEntity>) blockEntity.getType());
        if (ticker == null) {
            return;
        }
        for (int i=0;i<this.speed;i++) {
            ticker.tick(level, blockPos, blockEntity.getBlockState(), blockEntity);
        }
    }
}