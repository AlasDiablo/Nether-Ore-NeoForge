package fr.alasdiablo.mods.ore.nether.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class NetherOreTags {
    public static class Items {
        public static void init() {}

        public static final TagKey<Item> ORES_NETHER = commonTag("ores/nether");

        public static final TagKey<Item> ORES_NETHER_COAL     = commonTag("ores/nether/coal");
        public static final TagKey<Item> ORES_NETHER_COPPER   = commonTag("ores/nether/copper");
        public static final TagKey<Item> ORES_NETHER_DIAMOND  = commonTag("ores/nether/diamond");
        public static final TagKey<Item> ORES_NETHER_EMERALD  = commonTag("ores/nether/emerald");
        public static final TagKey<Item> ORES_NETHER_IRON     = commonTag("ores/nether/iron");
        public static final TagKey<Item> ORES_NETHER_LAPIS    = commonTag("ores/nether/lapis");
        public static final TagKey<Item> ORES_NETHER_REDSTONE = commonTag("ores/nether/redstone");


        private static @NotNull TagKey<Item> commonTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Blocks {
        public static void init() {}

        public static final TagKey<Block> ORES_NETHER = commonTag("ores/nether");

        public static final TagKey<Block> ORES_NETHER_COAL     = commonTag("ores/nether/coal");
        public static final TagKey<Block> ORES_NETHER_COPPER   = commonTag("ores/nether/copper");
        public static final TagKey<Block> ORES_NETHER_DIAMOND  = commonTag("ores/nether/diamond");
        public static final TagKey<Block> ORES_NETHER_EMERALD  = commonTag("ores/nether/emerald");
        public static final TagKey<Block> ORES_NETHER_IRON     = commonTag("ores/nether/iron");
        public static final TagKey<Block> ORES_NETHER_LAPIS    = commonTag("ores/nether/lapis");
        public static final TagKey<Block> ORES_NETHER_REDSTONE = commonTag("ores/nether/redstone");


        private static @NotNull TagKey<Block> commonTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
