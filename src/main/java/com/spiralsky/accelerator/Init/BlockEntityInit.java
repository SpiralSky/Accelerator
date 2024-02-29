package com.spiralsky.accelerator.Init;

import com.spiralsky.accelerator.Accelerator;
import com.spiralsky.accelerator.BlockEntities.Accelerator1BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Accelerator.MODID);
    public static final RegistryObject<BlockEntityType<Accelerator1BlockEntity>> ACCELERATOR_1_BLOCKENTITY = TILE_ENTITY_TYPES.register("accelerator_1",
            () -> BlockEntityType.Builder.of(Accelerator1BlockEntity::new, BlockInit.ACCELERATOR_1_BLOCK.get()).build(null));

}