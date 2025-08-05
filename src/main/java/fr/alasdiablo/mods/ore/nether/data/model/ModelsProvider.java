package fr.alasdiablo.mods.ore.nether.data.model;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

import static fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks.*;

public class ModelsProvider extends ModelProvider {
    public ModelsProvider(PackOutput output) {
        super(output, NetherOre.MOD_ID);
    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(ANCIENT_DEBRIS_ORE.get());

        blockModels.createTrivialCube(NETHER_COAL_ORE.get());
        blockModels.createTrivialCube(NETHER_COPPER_ORE.get());
        blockModels.createTrivialCube(NETHER_DIAMOND_ORE.get());
        blockModels.createTrivialCube(NETHER_EMERALD_ORE.get());
        blockModels.createTrivialCube(NETHER_IRON_ORE.get());
        blockModels.createTrivialCube(NETHER_LAPIS_ORE.get());
        blockModels.createTrivialCube(NETHER_REDSTONE_ORE.get());
    }
}
