package fr.alasdiablo.mods.ore.nether.data;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks.*;

public class BlockStatesProvider extends BlockStateProvider {
    public BlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NetherOre.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlockWithItem(NETHER_COAL_ORE.get());
        this.simpleBlockWithItem(NETHER_COPPER_ORE.get());
        this.simpleBlockWithItem(NETHER_DIAMOND_ORE.get());
        this.simpleBlockWithItem(NETHER_EMERALD_ORE.get());
        this.simpleBlockWithItem(NETHER_IRON_ORE.get());
        this.simpleBlockWithItem(NETHER_LAPIS_ORE.get());
        this.simpleBlockWithItem(NETHER_REDSTONE_ORE.get());
    }

    public void simpleBlockWithItem(Block block) {
        this.simpleBlockWithItem(block, this.cubeAll(block));
    }
}
