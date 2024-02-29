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

public class Accelerator1BlockEntity extends BlockEntity implements TickableBlockEntity{
    int ticks;
    public Accelerator1BlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.ACCELERATOR_1_BLOCKENTITY.get(), pos, state);
    }

   //@Override
    public void tick() {
        ticks += ticks;
        if (level != null && !level.isClientSide) {
            BlockPos pos = worldPosition.offset(0,0,0);
            BlockPos.betweenClosed(pos.offset(2,2,2),pos.offset(-2,-2,-2)).forEach(blockPos -> {
                BlockEntity tickedEntity = level.getBlockEntity(blockPos);
                if (tickedEntity != null &&!(tickedEntity instanceof Accelerator1BlockEntity)) {
                    BlockEntityTicker<BlockEntity> ticker = tickedEntity.getBlockState().getTicker(level, (BlockEntityType<BlockEntity>) tickedEntity.getType());
                    if (ticker != null) {
                        for (int i=0;i<10;i++) {
                            ticker.tick(level, pos, tickedEntity.getBlockState(), tickedEntity);
                        }
                    }
                }
                else {
                    BlockState cropState = level.getBlockState(blockPos);
                    Block cropBlock = cropState.getBlock();
                    if (cropBlock instanceof IPlantable) {
                        if ((ticks % 2) == 0) {
                            ticks = 0;
                            cropBlock.randomTick(cropState, (ServerLevel) level, blockPos, level.random);
                        }
                    }
                }
            });
        }

}}