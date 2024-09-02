package fr.alasdiablo.mods.ore.nether.data;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import fr.alasdiablo.mods.ore.nether.NetherOreRegistries;
import fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks;
import fr.alasdiablo.mods.resources.ExtendedResourcesRegistries;
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

    public RecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        super.buildRecipes(recipeOutput);

        this.registerNetherOre(NetherOreBlocks.NETHER_COAL_ORE, Items.COAL, 0.1f, recipeOutput, NetherOreRegistries.NETHER_COAL_ORE);
        this.registerNetherOre(NetherOreBlocks.NETHER_COPPER_ORE, Items.COPPER_INGOT, 0.7F, recipeOutput, NetherOreRegistries.NETHER_COPPER_ORE);
        this.registerNetherOre(NetherOreBlocks.NETHER_DIAMOND_ORE, Items.DIAMOND, 1.0F, recipeOutput, NetherOreRegistries.NETHER_DIAMOND_ORE);
        this.registerNetherOre(NetherOreBlocks.NETHER_EMERALD_ORE, Items.EMERALD, 1.0F, recipeOutput, NetherOreRegistries.NETHER_EMERALD_ORE);
        this.registerNetherOre(NetherOreBlocks.NETHER_IRON_ORE, Items.IRON_INGOT, 0.7F, recipeOutput, NetherOreRegistries.NETHER_IRON_ORE);
        this.registerNetherOre(NetherOreBlocks.NETHER_LAPIS_ORE, Items.LAPIS_LAZULI, 0.2F, recipeOutput, NetherOreRegistries.NETHER_LAPIS_ORE);
        this.registerNetherOre(NetherOreBlocks.NETHER_REDSTONE_ORE, Items.REDSTONE, 0.7F, recipeOutput, NetherOreRegistries.NETHER_REDSTONE_ORE);
    }

    private void registerNetherOre(ItemLike ingredient, ItemLike result, float experience, RecipeOutput recipeOutput, String name) {
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ingredient),
                        RecipeCategory.MISC,
                        result,
                        experience,
                        200
                ).group(getItemName(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NetherOre.MOD_ID, name + "_smelting"));
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(ingredient),
                        RecipeCategory.MISC,
                        result,
                        experience,
                        100
                ).group(getItemName(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NetherOre.MOD_ID, name + "_blasting"));
    }
}
