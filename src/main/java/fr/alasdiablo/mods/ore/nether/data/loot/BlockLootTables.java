package fr.alasdiablo.mods.ore.nether.data.loot;

import fr.alasdiablo.mods.lib.api.data.loot.DioBlockLootSubProvider;
import fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks;
import fr.alasdiablo.mods.resources.registry.ExtendedResourcesItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class BlockLootTables extends DioBlockLootSubProvider {
    private HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup;

    public BlockLootTables(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected void generate() {
        this.enchantmentRegistryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.registerNetherOre(NetherOreBlocks.NETHER_COAL_ORE.get(), ExtendedResourcesItems.COAL_NUGGET.get());
        this.registerNetherOre(NetherOreBlocks.NETHER_COPPER_ORE.get(), ExtendedResourcesItems.COPPER_NUGGET.get());
        this.registerNetherOre(NetherOreBlocks.NETHER_DIAMOND_ORE.get(), ExtendedResourcesItems.DIAMOND_NUGGET.get());
        this.registerNetherOre(NetherOreBlocks.NETHER_EMERALD_ORE.get(), ExtendedResourcesItems.EMERALD_NUGGET.get());
        this.registerNetherOre(NetherOreBlocks.NETHER_IRON_ORE.get(), Items.IRON_NUGGET);
        this.registerNetherOre(NetherOreBlocks.NETHER_LAPIS_ORE.get(), ExtendedResourcesItems.LAPIS_NUGGET.get());
        this.registerNetherOre(NetherOreBlocks.NETHER_REDSTONE_ORE.get(), ExtendedResourcesItems.REDSTONE_NUGGET.get());
    }

    protected void registerNetherOre(Block block, Item item) {
        this.add(
                block,
                (netherOre) -> createSilkTouchDispatchTable(
                        netherOre,
                        applyExplosionDecay(netherOre, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 6.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(this.enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))
                        )
                )
        );
    }
}
