package fr.alasdiablo.mods.ore.nether.data.feature;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.NetherOreRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlacedFeatures {

    public static final ResourceKey<PlacedFeature> ORE_NETHER_COAL     = register(NetherOreRegistries.NETHER_COAL_ORE);
    public static final ResourceKey<PlacedFeature> ORE_NETHER_COPPER   = register(NetherOreRegistries.NETHER_COPPER_ORE);
    public static final ResourceKey<PlacedFeature> ORE_NETHER_DIAMOND  = register(NetherOreRegistries.NETHER_DIAMOND_ORE);
    public static final ResourceKey<PlacedFeature> ORE_NETHER_EMERALD  = register(NetherOreRegistries.NETHER_EMERALD_ORE);
    public static final ResourceKey<PlacedFeature> ORE_NETHER_IRON     = register(NetherOreRegistries.NETHER_IRON_ORE);
    public static final ResourceKey<PlacedFeature> ORE_NETHER_LAPIS    = register(NetherOreRegistries.NETHER_LAPIS_ORE);
    public static final ResourceKey<PlacedFeature> ORE_NETHER_REDSTONE = register(NetherOreRegistries.NETHER_REDSTONE_ORE);

    public static final ResourceKey<PlacedFeature> ORE_NETHER_COAL_EXTRA     = register(NetherOreRegistries.NETHER_COAL_ORE + "_extra");
    public static final ResourceKey<PlacedFeature> ORE_NETHER_COPPER_EXTRA   = register(NetherOreRegistries.NETHER_COPPER_ORE + "_extra");
    public static final ResourceKey<PlacedFeature> ORE_NETHER_DIAMOND_EXTRA  = register(NetherOreRegistries.NETHER_DIAMOND_ORE + "_extra");
    public static final ResourceKey<PlacedFeature> ORE_NETHER_IRON_EXTRA     = register(NetherOreRegistries.NETHER_IRON_ORE + "_extra");
    public static final ResourceKey<PlacedFeature> ORE_NETHER_LAPIS_EXTRA    = register(NetherOreRegistries.NETHER_LAPIS_ORE + "_extra");
    public static final ResourceKey<PlacedFeature> ORE_NETHER_REDSTONE_EXTRA = register(NetherOreRegistries.NETHER_REDSTONE_ORE + "_extra");

    private static @NotNull PlacedFeature createPlacedFeature(
            Holder.Reference<ConfiguredFeature<?, ?>> configuredFeature, int count
    ) {
        return new PlacedFeature(
                configuredFeature, List.of(CountPlacement.of(count), InSquarePlacement.spread(), PlacementUtils.RANGE_10_10, BiomeFilter.biome()));
    }

    private static @NotNull PlacedFeature createDefaultPlacedFeature(
            Holder.Reference<ConfiguredFeature<?, ?>> configuredFeature
    ) {
        return createPlacedFeature(configuredFeature, 8);
    }

    private static @NotNull PlacedFeature createExtraPlacedFeature(
            Holder.Reference<ConfiguredFeature<?, ?>> configuredFeature
    ) {
        return createPlacedFeature(configuredFeature, 20);
    }

    public static void bootstrap(@NotNull BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(ORE_NETHER_COAL, createDefaultPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_COAL)));
        context.register(ORE_NETHER_COPPER, createDefaultPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_COPPER)));
        context.register(ORE_NETHER_DIAMOND, createDefaultPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_DIAMOND)));
        context.register(ORE_NETHER_EMERALD, createDefaultPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_EMERALD)));
        context.register(ORE_NETHER_IRON, createDefaultPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_IRON)));
        context.register(ORE_NETHER_LAPIS, createDefaultPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_LAPIS)));
        context.register(ORE_NETHER_REDSTONE, createDefaultPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_REDSTONE)));

        context.register(ORE_NETHER_COAL_EXTRA, createExtraPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_COAL_EXTRA)));
        context.register(ORE_NETHER_COPPER_EXTRA, createExtraPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_COPPER_EXTRA)));
        context.register(ORE_NETHER_DIAMOND_EXTRA, createExtraPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_DIAMOND_EXTRA)));
        context.register(ORE_NETHER_IRON_EXTRA, createExtraPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_IRON_EXTRA)));
        context.register(ORE_NETHER_LAPIS_EXTRA, createExtraPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_LAPIS_EXTRA)));
        context.register(ORE_NETHER_REDSTONE_EXTRA, createExtraPlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ORE_NETHER_REDSTONE_EXTRA)));
    }

    private static @NotNull ResourceKey<PlacedFeature> register(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NetherOre.MOD_ID, name));
    }
}
