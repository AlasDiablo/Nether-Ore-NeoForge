package fr.alasdiablo.mods.ore.nether.data.recipe;

import fr.alasdiablo.mods.lib.data.DioRecipieProvider;
import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks;
import fr.alasdiablo.mods.resources.registry.ExtendedResourcesItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class RecipesProvider extends DioRecipieProvider {

    public RecipesProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(NetherOre.MOD_ID, registries, output);
    }

    @Override
    protected void buildRecipes() {
        this.oreCooking(NetherOreBlocks.ANCIENT_DEBRIS_ORE, ExtendedResourcesItems.NETHERITE_FRAGMENT, 1.0F, getItemName(ExtendedResourcesItems.NETHERITE_FRAGMENT));

        this.oreCooking(NetherOreBlocks.NETHER_COAL_ORE, Items.COAL, 0.1f, getItemName(Items.COAL));
        this.oreCooking(NetherOreBlocks.NETHER_COPPER_ORE, Items.COPPER_INGOT, 0.7F, getItemName(Items.COPPER_INGOT));
        this.oreCooking(NetherOreBlocks.NETHER_DIAMOND_ORE, Items.DIAMOND, 1.0F, getItemName(Items.DIAMOND));
        this.oreCooking(NetherOreBlocks.NETHER_EMERALD_ORE, Items.EMERALD, 1.0F, getItemName(Items.EMERALD));
        this.oreCooking(NetherOreBlocks.NETHER_IRON_ORE, Items.IRON_INGOT, 0.7F, getItemName(Items.IRON_INGOT));
        this.oreCooking(NetherOreBlocks.NETHER_LAPIS_ORE, Items.LAPIS_LAZULI, 0.2F, getItemName(Items.LAPIS_LAZULI));
        this.oreCooking(NetherOreBlocks.NETHER_REDSTONE_ORE, Items.REDSTONE, 0.7F, getItemName(Items.REDSTONE));
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput output) {
            return new RecipesProvider(provider, output);
        }

        @Override
        public @NotNull String getName() {
            return "Dio's Nether Ore Recipes Provider";
        }
    }
}
