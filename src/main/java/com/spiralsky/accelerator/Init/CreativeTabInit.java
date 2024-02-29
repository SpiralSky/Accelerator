package com.spiralsky.accelerator.Init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.spiralsky.accelerator.Accelerator.MODID;
import static com.spiralsky.accelerator.Init.BlockInit.ACCELERATOR_1_ITEM;

public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> HEAVENS_ADDONS_TAB = CREATIVE_MODE_TABS.register("heavens_addons_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.literal("Heavens Addons"))
            .icon(() -> ACCELERATOR_1_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ACCELERATOR_1_ITEM.get());
            }).build());
}

