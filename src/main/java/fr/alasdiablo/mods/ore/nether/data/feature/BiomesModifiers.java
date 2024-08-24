package fr.alasdiablo.mods.ore.nether.data.feature;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.NetherOreRegistries;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BiomesModifiers {

    public static final ResourceKey<BiomeModifier> ORE_NETHER_COAL     = register(NetherOreRegistries.NETHER_COAL_ORE);
    public static final ResourceKey<BiomeModifier> ORE_NETHER_COPPER   = register(NetherOreRegistries.NETHER_COPPER_ORE);
    public static final ResourceKey<BiomeModifier> ORE_NETHER_DIAMOND  = register(NetherOreRegistries.NETHER_DIAMOND_ORE);
    public static final ResourceKey<BiomeModifier> ORE_NETHER_EMERALD  = register(NetherOreRegistries.NETHER_EMERALD_ORE);
    public static final ResourceKey<BiomeModifier> ORE_NETHER_IRON     = register(NetherOreRegistries.NETHER_IRON_ORE);
    public static final ResourceKey<BiomeModifier> ORE_NETHER_LAPIS    = register(NetherOreRegistries.NETHER_LAPIS_ORE);
    public static final ResourceKey<BiomeModifier> ORE_NETHER_REDSTONE = register(NetherOreRegistries.NETHER_REDSTONE_ORE);

    public static final ResourceKey<BiomeModifier> ORE_NETHER_COAL_BASALT_DELTAS     = register(NetherOreRegistries.NETHER_COAL_ORE + "_basalt_deltas");
    public static final ResourceKey<BiomeModifier> ORE_NETHER_COPPER_CRIMSON_FOREST  = register(NetherOreRegistries.NETHER_COPPER_ORE + "_crimson_forest");
    public static final ResourceKey<BiomeModifier> ORE_NETHER_DIAMOND_WARPED_FOREST  = register(NetherOreRegistries.NETHER_DIAMOND_ORE + "_warped_forest");
    public static final ResourceKey<BiomeModifier> ORE_NETHER_IRON_CRIMSON_FOREST    = register(NetherOreRegistries.NETHER_IRON_ORE + "_crimson_forest");
    public static final ResourceKey<BiomeModifier> ORE_NETHER_LAPIS_SOUL_SAND_VALLY  = register(NetherOreRegistries.NETHER_LAPIS_ORE + "_soul_sand_vally");
    public static final ResourceKey<BiomeModifier> ORE_NETHER_REDSTONE_NETHER_WASTES = register(NetherOreRegistries.NETHER_REDSTONE_ORE + "_nether_wastes");

    @Contract(value = "_, _ -> new", pure = true)
    private static BiomeModifiers.@NotNull AddFeaturesBiomeModifier createBiomeModifier(HolderSet<Biome> biomes, HolderSet<PlacedFeature> features) {
        return new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes,
                features,
                GenerationStep.Decoration.UNDERGROUND_ORES
        );
    }

    public static void bootstrap(@NotNull BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome>         biomes         = context.lookup(Registries.BIOME);

        context.register(ORE_NETHER_COAL, createBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_COAL))
        ));
        context.register(ORE_NETHER_COPPER, createBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_COPPER))
        ));
        context.register(ORE_NETHER_DIAMOND, createBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_DIAMOND))
        ));
        context.register(ORE_NETHER_EMERALD, createBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_EMERALD))
        ));
        context.register(ORE_NETHER_IRON, createBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_IRON))
        ));
        context.register(ORE_NETHER_LAPIS, createBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_LAPIS))
        ));
        context.register(ORE_NETHER_REDSTONE, createBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_REDSTONE))
        ));

        context.register(ORE_NETHER_COAL_BASALT_DELTAS, createBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BASALT_DELTAS)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_COAL_EXTRA))
        ));
        context.register(ORE_NETHER_COPPER_CRIMSON_FOREST, createBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.CRIMSON_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_COPPER_EXTRA))
        ));
        context.register(ORE_NETHER_DIAMOND_WARPED_FOREST, createBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.WARPED_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_DIAMOND_EXTRA))
        ));
        context.register(ORE_NETHER_IRON_CRIMSON_FOREST, createBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.CRIMSON_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_IRON_EXTRA))
        ));
        context.register(ORE_NETHER_LAPIS_SOUL_SAND_VALLY, createBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_LAPIS_EXTRA))
        ));
        context.register(ORE_NETHER_REDSTONE_NETHER_WASTES, createBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.NETHER_WASTES)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ORE_NETHER_REDSTONE_EXTRA))
        ));
    }

    private static @NotNull ResourceKey<BiomeModifier> register(String name) {
        return ResourceKey.create(
                NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                ResourceLocation.fromNamespaceAndPath(NetherOre.MOD_ID, name)
        );
    }
}
