package com.spiralsky.accelerator;

import com.mojang.logging.LogUtils;
import com.spiralsky.accelerator.Init.BlockEntityInit;
import com.spiralsky.accelerator.Init.BlockInit;
import com.spiralsky.accelerator.Init.CreativeTabInit;
import com.spiralsky.accelerator.Init.ItemInit;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.spiralsky.accelerator.Config.SPEC;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Accelerator.MODID)
public class Accelerator
{
    public static final String MODID = "accelerator";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Accelerator() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        CreativeTabInit.CREATIVE_MODE_TABS.register(modEventBus);
        BlockEntityInit.TILE_ENTITY_TYPES.register(modEventBus);


        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC);
    }
}
