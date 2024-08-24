package fr.alasdiablo.mods.ore.nether.data;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks.*;
import static fr.alasdiablo.mods.ore.nether.tag.NetherOreTags.Blocks.*;

@SuppressWarnings("unchecked")
public class BlocksTagsProvider extends BlockTagsProvider {

    public BlocksTagsProvider(
            PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(output, lookupProvider, NetherOre.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider pProvider) {
        this.tag(ORES_NETHER_COAL).add(NETHER_COAL_ORE.get());
        this.tag(ORES_NETHER_COPPER).add(NETHER_COPPER_ORE.get());
        this.tag(ORES_NETHER_DIAMOND).add(NETHER_DIAMOND_ORE.get());
        this.tag(ORES_NETHER_EMERALD).add(NETHER_EMERALD_ORE.get());
        this.tag(ORES_NETHER_IRON).add(NETHER_IRON_ORE.get());
        this.tag(ORES_NETHER_LAPIS).add(NETHER_LAPIS_ORE.get());
        this.tag(ORES_NETHER_REDSTONE).add(NETHER_REDSTONE_ORE.get());

        this.tag(Tags.Blocks.ORES_COAL).add(NETHER_COAL_ORE.get());
        this.tag(Tags.Blocks.ORES_COPPER).add(NETHER_COPPER_ORE.get());
        this.tag(Tags.Blocks.ORES_DIAMOND).add(NETHER_DIAMOND_ORE.get());
        this.tag(Tags.Blocks.ORES_EMERALD).add(NETHER_EMERALD_ORE.get());
        this.tag(Tags.Blocks.ORES_IRON).add(NETHER_IRON_ORE.get());
        this.tag(Tags.Blocks.ORES_LAPIS).add(NETHER_LAPIS_ORE.get());
        this.tag(Tags.Blocks.ORES_REDSTONE).add(NETHER_REDSTONE_ORE.get());

        this.tag(ORES_NETHER).addTags(
                ORES_NETHER_COAL, ORES_NETHER_COPPER, ORES_NETHER_DIAMOND,
                ORES_NETHER_EMERALD, ORES_NETHER_IRON, ORES_NETHER_LAPIS,
                ORES_NETHER_REDSTONE
        );

        this.tag(Tags.Blocks.ORES).addTags(
                ORES_NETHER, Tags.Blocks.ORES_COAL, Tags.Blocks.ORES_COPPER,
                Tags.Blocks.ORES_DIAMOND, Tags.Blocks.ORES_EMERALD, Tags.Blocks.ORES_IRON,
                Tags.Blocks.ORES_LAPIS, Tags.Blocks.ORES_REDSTONE
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
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
    }
}
