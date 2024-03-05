package com.spiralsky.accelerator.Init;

import com.spiralsky.accelerator.Accelerator;
import com.spiralsky.accelerator.Blocks.AcceleratorBlock;
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

    //Blocks
    public static final RegistryObject<Block> ACCELERATOR_1_BLOCK = BLOCKS.register("accelerator_1",
            () -> new AcceleratorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().strength(2f,100f),1));
    public static final RegistryObject<Block> ACCELERATOR_2_BLOCK = BLOCKS.register("accelerator_2",
            () -> new AcceleratorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().strength(4f,100f),3));
    public static final RegistryObject<Block> ACCELERATOR_3_BLOCK = BLOCKS.register("accelerator_3",
            () -> new AcceleratorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().strength(6f,100f),10));
    public static final RegistryObject<Block> ACCELERATOR_4_BLOCK = BLOCKS.register("accelerator_4",
            () -> new AcceleratorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().strength(8f,100f),10));

    //BlockItems
    public static final RegistryObject<Item> ACCELERATOR_1_ITEM = ITEMS.register("accelerator_1",
            () -> new BlockItem(ACCELERATOR_1_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACCELERATOR_2_ITEM = ITEMS.register("accelerator_2",
            () -> new BlockItem(ACCELERATOR_2_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACCELERATOR_3_ITEM = ITEMS.register("accelerator_3",
            () -> new BlockItem(ACCELERATOR_3_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACCELERATOR_4_ITEM = ITEMS.register("accelerator_4",
            () -> new BlockItem(ACCELERATOR_4_BLOCK.get(), new Item.Properties()));
}
