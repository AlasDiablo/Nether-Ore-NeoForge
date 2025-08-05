package fr.alasdiablo.mods.ore.nether.data.tag;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks.*;
import static fr.alasdiablo.mods.ore.nether.tag.NetherOreTags.Blocks.*;

@SuppressWarnings("unchecked")
public class BlocksTagsProvider extends BlockTagsProvider {

    public BlocksTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, NetherOre.MOD_ID);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider pProvider) {

        this.tag(ORES_NETHERITE_SCRAP).add(ANCIENT_DEBRIS_ORE.get());
        this.tag(ORES_NETHER_COAL).add(NETHER_COAL_ORE.get());
        this.tag(ORES_NETHER_COPPER).add(NETHER_COPPER_ORE.get());
        this.tag(ORES_NETHER_DIAMOND).add(NETHER_DIAMOND_ORE.get());
        this.tag(ORES_NETHER_EMERALD).add(NETHER_EMERALD_ORE.get());
        this.tag(ORES_NETHER_IRON).add(NETHER_IRON_ORE.get());
        this.tag(ORES_NETHER_LAPIS).add(NETHER_LAPIS_ORE.get());
        this.tag(ORES_NETHER_REDSTONE).add(NETHER_REDSTONE_ORE.get());

        this.tag(Tags.Blocks.ORES_NETHERITE_SCRAP).add(ANCIENT_DEBRIS_ORE.get());
        this.tag(Tags.Blocks.ORES_COAL).add(NETHER_COAL_ORE.get());
        this.tag(Tags.Blocks.ORES_COPPER).add(NETHER_COPPER_ORE.get());
        this.tag(Tags.Blocks.ORES_DIAMOND).add(NETHER_DIAMOND_ORE.get());
        this.tag(Tags.Blocks.ORES_EMERALD).add(NETHER_EMERALD_ORE.get());
        this.tag(Tags.Blocks.ORES_IRON).add(NETHER_IRON_ORE.get());
        this.tag(Tags.Blocks.ORES_LAPIS).add(NETHER_LAPIS_ORE.get());
        this.tag(Tags.Blocks.ORES_REDSTONE).add(NETHER_REDSTONE_ORE.get());

        this.tag(ORES_NETHER).addTags(
                ORES_NETHERITE_SCRAP, ORES_NETHER_COAL, ORES_NETHER_COPPER,
                ORES_NETHER_DIAMOND, ORES_NETHER_EMERALD, ORES_NETHER_IRON,
                ORES_NETHER_LAPIS, ORES_NETHER_REDSTONE
        );

        this.tag(Tags.Blocks.ORES).addTag(ORES_NETHER);
        this.tag(Tags.Blocks.ORE_RATES_SPARSE).addTag(ORES_NETHER);
        this.tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK).addTag(ORES_NETHER);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ANCIENT_DEBRIS_ORE.get(),
                NETHER_COAL_ORE.get(),
                NETHER_COPPER_ORE.get(),
                NETHER_DIAMOND_ORE.get(),
                NETHER_EMERALD_ORE.get(),
                NETHER_IRON_ORE.get(),
                NETHER_LAPIS_ORE.get(),
                NETHER_REDSTONE_ORE.get()
        );

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                NETHER_COPPER_ORE.get(),
                NETHER_IRON_ORE.get(),
                NETHER_LAPIS_ORE.get()
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                NETHER_DIAMOND_ORE.get(),
                NETHER_EMERALD_ORE.get(),
                NETHER_REDSTONE_ORE.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ANCIENT_DEBRIS_ORE.get()
        );
    }
}
