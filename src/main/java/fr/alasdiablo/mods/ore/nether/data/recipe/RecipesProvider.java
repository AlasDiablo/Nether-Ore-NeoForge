package fr.alasdiablo.mods.ore.nether.data.recipe;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks;
import fr.alasdiablo.mods.resources.ExtendedResources;
import fr.alasdiablo.mods.resources.registry.ExtendedResourcesItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class RecipesProvider extends RecipeProvider {

    public RecipesProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        this.registerNetherOre(NetherOreBlocks.ANCIENT_DEBRIS_ORE, ExtendedResourcesItems.NETHERITE_FRAGMENT, 1.0F);

        this.registerNetherOre(NetherOreBlocks.NETHER_COAL_ORE, Items.COAL, 0.1f);
        this.registerNetherOre(NetherOreBlocks.NETHER_COPPER_ORE, Items.COPPER_INGOT, 0.7F);
        this.registerNetherOre(NetherOreBlocks.NETHER_DIAMOND_ORE, Items.DIAMOND, 1.0F);
        this.registerNetherOre(NetherOreBlocks.NETHER_EMERALD_ORE, Items.EMERALD, 1.0F);
        this.registerNetherOre(NetherOreBlocks.NETHER_IRON_ORE, Items.IRON_INGOT, 0.7F);
        this.registerNetherOre(NetherOreBlocks.NETHER_LAPIS_ORE, Items.LAPIS_LAZULI, 0.2F);
        this.registerNetherOre(NetherOreBlocks.NETHER_REDSTONE_ORE, Items.REDSTONE, 0.7F);
    }

    private void registerNetherOre(ItemLike ingredient, ItemLike result, float experience) {

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ingredient),
                        RecipeCategory.MISC,
                        result,
                        experience,
                        200
                ).group(RecipesProvider.getItemName(result))
                .unlockedBy(RecipesProvider.getHasName(ingredient), this.has(ingredient))
                .save(this.output, ResourceLocation.fromNamespaceAndPath(NetherOre.MOD_ID, RecipesProvider.getItemName(ingredient) + "_smelting").toString());
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(ingredient),
                        RecipeCategory.MISC,
                        result,
                        experience,
                        100
                ).group(RecipesProvider.getItemName(result))
                .unlockedBy(RecipesProvider.getHasName(ingredient), this.has(ingredient))
                .save(this.output, ResourceLocation.fromNamespaceAndPath(NetherOre.MOD_ID, RecipesProvider.getItemName(ingredient) + "_blasting").toString());
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
