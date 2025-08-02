package fr.alasdiablo.mods.ore.nether.registry;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.NetherOreRegistries;
import fr.alasdiablo.mods.ore.nether.block.NetherOreBlock;
import fr.alasdiablo.mods.ore.nether.block.NetherRedStoneOreBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class NetherOreBlocks {
    static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NetherOre.MOD_ID);
    static final DeferredRegister.Items  ITEMS  = DeferredRegister.createItems(NetherOre.MOD_ID);

    public static final DeferredBlock<Block> NETHER_COAL_ORE     = register(
            (registryName) -> new NetherOreBlock(UniformInt.of(0, 1), ResourceKey.create(Registries.BLOCK, registryName)), NetherOreRegistries.NETHER_COAL_ORE);
    public static final DeferredBlock<Block> NETHER_COPPER_ORE   = register(
            (registryName) -> new NetherOreBlock(UniformInt.of(0, 1), ResourceKey.create(Registries.BLOCK, registryName)), NetherOreRegistries.NETHER_COPPER_ORE);
    public static final DeferredBlock<Block> NETHER_DIAMOND_ORE  = register(
            (registryName) -> new NetherOreBlock(UniformInt.of(1, 3), ResourceKey.create(Registries.BLOCK, registryName)), NetherOreRegistries.NETHER_DIAMOND_ORE);
    public static final DeferredBlock<Block> NETHER_EMERALD_ORE  = register(
            (registryName) -> new NetherOreBlock(UniformInt.of(1, 3), ResourceKey.create(Registries.BLOCK, registryName)), NetherOreRegistries.NETHER_EMERALD_ORE);
    public static final DeferredBlock<Block> NETHER_IRON_ORE     = register(
            (registryName) -> new NetherOreBlock(UniformInt.of(0, 1), ResourceKey.create(Registries.BLOCK, registryName)), NetherOreRegistries.NETHER_IRON_ORE);
    public static final DeferredBlock<Block> NETHER_LAPIS_ORE    = register(
            (registryName) -> new NetherOreBlock(UniformInt.of(1, 2), ResourceKey.create(Registries.BLOCK, registryName)), NetherOreRegistries.NETHER_LAPIS_ORE);
    public static final DeferredBlock<Block> NETHER_REDSTONE_ORE = register(
            (registryName) -> new NetherRedStoneOreBlock(UniformInt.of(0, 2), ResourceKey.create(Registries.BLOCK, registryName)), NetherOreRegistries.NETHER_REDSTONE_ORE);

    private static <T extends Block> @NotNull DeferredBlock<T> register(Function<ResourceLocation, ? extends T> block, String name) {
        DeferredBlock<T> blockRegistry = BLOCKS.register(name, block);
        ITEMS.registerSimpleBlockItem(blockRegistry);
        return blockRegistry;
    }

    public static void displayItemsGenerator(CreativeModeTab.ItemDisplayParameters parameters, @NotNull CreativeModeTab.Output output) {
        output.accept(NETHER_COAL_ORE.get());

        output.accept(NETHER_COPPER_ORE.get());

        output.accept(NETHER_DIAMOND_ORE.get());

        output.accept(NETHER_EMERALD_ORE.get());

        output.accept(NETHER_IRON_ORE.get());

        output.accept(NETHER_LAPIS_ORE.get());

        output.accept(NETHER_REDSTONE_ORE.get());
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
}
