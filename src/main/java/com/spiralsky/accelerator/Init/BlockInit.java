package com.spiralsky.accelerator.Init;

import com.spiralsky.accelerator.Accelerator;
import com.spiralsky.accelerator.Blocks.Accelerator1Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.spiralsky.accelerator.Init.ItemInit.ITEMS;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Accelerator.MODID);

    public static final RegistryObject<Block> ACCELERATOR_4_BLOCK = BLOCKS.register("accelerator_4",
            () -> new Accelerator1Block(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().strength(4f,100f)));

    //BlockItems
    public static final RegistryObject<Item> ACCELERATOR_1_ITEM = ITEMS.register("accelerator_4",
            () -> new BlockItem(ACCELERATOR_4_BLOCK.get(), new Item.Properties()));
}
