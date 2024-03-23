package com.spiralsky.accelerator;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Accelerator.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue ACCELERATOR_1_SPEED = BUILDER
            .comment("Speed for Tier 1 Accelerator")
            .defineInRange("accelerator1Speed", 1, 0, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue ACCELERATOR_2_SPEED = BUILDER
            .comment("Speed for Tier 2 Accelerator")
            .defineInRange("accelerator2Speed", 3, 0, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue ACCELERATOR_3_SPEED = BUILDER
            .comment("Speed for Tier 3 Accelerator")
            .defineInRange("accelerator3Speed", 7, 0, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue ACCELERATOR_4_SPEED = BUILDER
            .comment("Speed for Tier 4 Accelerator")
            .defineInRange("accelerator4Speed", 10, 0, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int
            accelerator1Speed,
            accelerator2Speed,
            accelerator3Speed,
            accelerator4Speed;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        accelerator1Speed = ACCELERATOR_1_SPEED.get();
        accelerator2Speed = ACCELERATOR_2_SPEED.get();
        accelerator3Speed = ACCELERATOR_3_SPEED.get();
        accelerator4Speed = ACCELERATOR_4_SPEED.get();
    }
}