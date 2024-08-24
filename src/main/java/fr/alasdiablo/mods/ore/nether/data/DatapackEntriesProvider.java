package fr.alasdiablo.mods.ore.nether.data;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.data.feature.BiomesModifiers;
import fr.alasdiablo.mods.ore.nether.data.feature.ConfiguredFeatures;
import fr.alasdiablo.mods.ore.nether.data.feature.PlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DatapackEntriesProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomesModifiers::bootstrap);

    public DatapackEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup, BUILDER, Set.of(NetherOre.MOD_ID));
    }
}
