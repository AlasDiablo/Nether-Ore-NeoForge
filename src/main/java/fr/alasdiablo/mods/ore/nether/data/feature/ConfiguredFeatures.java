package fr.alasdiablo.mods.ore.nether.data.feature;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.NetherOreRegistries;
import fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ConfiguredFeatures {
    private static final RuleTest NETHERRACK_ORE_REPLACEABLES = new BlockMatchTest(Blocks.NETHERRACK);

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_COAL     = register(NetherOreRegistries.NETHER_COAL_ORE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_COPPER   = register(NetherOreRegistries.NETHER_COPPER_ORE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_DIAMOND  = register(NetherOreRegistries.NETHER_DIAMOND_ORE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_EMERALD  = register(NetherOreRegistries.NETHER_EMERALD_ORE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_IRON     = register(NetherOreRegistries.NETHER_IRON_ORE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_LAPIS    = register(NetherOreRegistries.NETHER_LAPIS_ORE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_REDSTONE = register(NetherOreRegistries.NETHER_REDSTONE_ORE);

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_COAL_EXTRA     = register(NetherOreRegistries.NETHER_COAL_ORE + "_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_COPPER_EXTRA   = register(NetherOreRegistries.NETHER_COPPER_ORE + "_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_DIAMOND_EXTRA  = register(NetherOreRegistries.NETHER_DIAMOND_ORE + "_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_IRON_EXTRA     = register(NetherOreRegistries.NETHER_IRON_ORE + "_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_LAPIS_EXTRA    = register(NetherOreRegistries.NETHER_LAPIS_ORE + "_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NETHER_REDSTONE_EXTRA = register(NetherOreRegistries.NETHER_REDSTONE_ORE + "_extra");

    private static @NotNull ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> createConfiguredFeature(
            @NotNull Block netherOre
    ) {
        return createConfiguredFeature(netherOre, 6);
    }

    private static @NotNull ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> createConfiguredFeature(
            @NotNull Block netherOre,
            int size
    ) {
        List<OreConfiguration.TargetBlockState> targetStates = List.of(
                OreConfiguration.target(NETHERRACK_ORE_REPLACEABLES, netherOre.defaultBlockState())
        );

        return new ConfiguredFeature<>(
                Feature.ORE,
                new OreConfiguration(targetStates, size)
        );
    }

    public static void bootstrap(@NotNull BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(ORE_NETHER_COAL, createConfiguredFeature(NetherOreBlocks.NETHER_COAL_ORE.get()));
        context.register(ORE_NETHER_COPPER, createConfiguredFeature(NetherOreBlocks.NETHER_COPPER_ORE.get()));
        context.register(ORE_NETHER_DIAMOND, createConfiguredFeature(NetherOreBlocks.NETHER_DIAMOND_ORE.get()));
        context.register(ORE_NETHER_EMERALD, createConfiguredFeature(NetherOreBlocks.NETHER_EMERALD_ORE.get()));
        context.register(ORE_NETHER_IRON, createConfiguredFeature(NetherOreBlocks.NETHER_IRON_ORE.get()));
        context.register(ORE_NETHER_LAPIS, createConfiguredFeature(NetherOreBlocks.NETHER_LAPIS_ORE.get()));
        context.register(ORE_NETHER_REDSTONE, createConfiguredFeature(NetherOreBlocks.NETHER_REDSTONE_ORE.get()));

        context.register(ORE_NETHER_COAL_EXTRA, createConfiguredFeature(NetherOreBlocks.NETHER_COAL_ORE.get(), 18));
        context.register(ORE_NETHER_COPPER_EXTRA, createConfiguredFeature(NetherOreBlocks.NETHER_COPPER_ORE.get(), 14));
        context.register(ORE_NETHER_DIAMOND_EXTRA, createConfiguredFeature(NetherOreBlocks.NETHER_DIAMOND_ORE.get(), 12));
        context.register(ORE_NETHER_IRON_EXTRA, createConfiguredFeature(NetherOreBlocks.NETHER_IRON_ORE.get(), 14));
        context.register(ORE_NETHER_LAPIS_EXTRA, createConfiguredFeature(NetherOreBlocks.NETHER_LAPIS_ORE.get(), 12));
        context.register(ORE_NETHER_REDSTONE_EXTRA, createConfiguredFeature(NetherOreBlocks.NETHER_REDSTONE_ORE.get(), 12));
    }

    private static @NotNull ResourceKey<ConfiguredFeature<?, ?>> register(String name) {
        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(NetherOre.MOD_ID, name)
        );
    }
}
