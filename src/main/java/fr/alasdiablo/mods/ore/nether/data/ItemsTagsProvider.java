package fr.alasdiablo.mods.ore.nether.data;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.tag.NetherOreTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemsTagsProvider extends ItemTagsProvider {
    public ItemsTagsProvider(
            PackOutput output, CompletableFuture<HolderLookup.Provider> lookup,
            @NotNull TagsProvider<Block> blockTagsProvider,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(output, lookup, blockTagsProvider.contentsGetter(), NetherOre.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.copy(NetherOreTags.Blocks.ORES_NETHER_COAL, NetherOreTags.Items.ORES_NETHER_COAL);
        this.copy(NetherOreTags.Blocks.ORES_NETHER_COPPER, NetherOreTags.Items.ORES_NETHER_COPPER);
        this.copy(NetherOreTags.Blocks.ORES_NETHER_DIAMOND, NetherOreTags.Items.ORES_NETHER_DIAMOND);
        this.copy(NetherOreTags.Blocks.ORES_NETHER_EMERALD, NetherOreTags.Items.ORES_NETHER_EMERALD);
        this.copy(NetherOreTags.Blocks.ORES_NETHER_IRON, NetherOreTags.Items.ORES_NETHER_IRON);
        this.copy(NetherOreTags.Blocks.ORES_NETHER_LAPIS, NetherOreTags.Items.ORES_NETHER_LAPIS);
        this.copy(NetherOreTags.Blocks.ORES_NETHER_REDSTONE, NetherOreTags.Items.ORES_NETHER_REDSTONE);

        this.copy(Tags.Blocks.ORES_COAL, Tags.Items.ORES_COAL);
        this.copy(Tags.Blocks.ORES_COPPER, Tags.Items.ORES_COPPER);
        this.copy(Tags.Blocks.ORES_DIAMOND, Tags.Items.ORES_DIAMOND);
        this.copy(Tags.Blocks.ORES_EMERALD, Tags.Items.ORES_EMERALD);
        this.copy(Tags.Blocks.ORES_IRON, Tags.Items.ORES_IRON);
        this.copy(Tags.Blocks.ORES_LAPIS, Tags.Items.ORES_LAPIS);
        this.copy(Tags.Blocks.ORES_REDSTONE, Tags.Items.ORES_REDSTONE);

        this.copy(NetherOreTags.Blocks.ORES_NETHER, NetherOreTags.Items.ORES_NETHER);

        this.copy(Tags.Blocks.ORES, Tags.Items.ORES);
    }
}
