package com.spiralsky.accelerator;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.spiralsky.accelerator.Accelerator.MODID;
import static com.spiralsky.accelerator.Init.BlockInit.ACCELERATOR_1_ITEM;

public class ModCreativeTab extends CreativeModeTab {
    public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, MODID);
    private ModCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ACCELERATOR_1_ITEM.get());
    }
}

