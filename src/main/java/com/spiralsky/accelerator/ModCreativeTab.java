package com.spiralsky.accelerator;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.spiralsky.accelerator.Accelerator.MODID;
import static com.spiralsky.accelerator.Init.BlockInit.*;

public class ModCreativeTab extends CreativeModeTab {
    public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.builder()
            .icon(() -> ACCELERATOR_1_BLOCK.get().asItem().getDefaultInstance())
            .title(Component.literal("Block Accelerators")));

    protected ModCreativeTab(Builder builder) {
        super(builder);
    }

}

