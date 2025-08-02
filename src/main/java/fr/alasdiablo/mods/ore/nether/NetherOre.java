package fr.alasdiablo.mods.ore.nether;

import com.mojang.logging.LogUtils;
import fr.alasdiablo.mods.ore.nether.config.NetherOreConfig;
import fr.alasdiablo.mods.ore.nether.data.datapack.DatapackEntriesProvider;
import fr.alasdiablo.mods.ore.nether.data.lang.LanguagesProvider;
import fr.alasdiablo.mods.ore.nether.data.loot.LootTablesProvider;
import fr.alasdiablo.mods.ore.nether.data.model.ModelsProvider;
import fr.alasdiablo.mods.ore.nether.data.recipe.RecipesProvider;
import fr.alasdiablo.mods.ore.nether.data.tag.BlocksTagsProvider;
import fr.alasdiablo.mods.ore.nether.data.tag.ItemsTagsProvider;
import fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks;
import fr.alasdiablo.mods.ore.nether.registry.TinyOreCreativeTabs;
import fr.alasdiablo.mods.ore.nether.tag.NetherOreTags;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(NetherOre.MOD_ID)
public class NetherOre {
    public static final String MOD_ID = "dio_nether_ore";
    public static final Logger LOGGER = LogUtils.getLogger();

    public NetherOre(IEventBus modEventBus, ModContainer modContainer) {
        NetherOreTags.Items.init();
        NetherOreTags.Blocks.init();

        NetherOreBlocks.init(modEventBus);
        TinyOreCreativeTabs.init(modEventBus);

        modEventBus.addListener(this::gatherData);

        modContainer.registerConfig(ModConfig.Type.COMMON, NetherOreConfig.SPEC);
    }

    private void gatherData(@NotNull GatherDataEvent.Client event) {
        NetherOre.LOGGER.debug("Start data generator");

        NetherOre.LOGGER.debug("Add Client Provider");

        NetherOre.LOGGER.debug("Add Block State Provider");
        event.createProvider(ModelsProvider::new);

        NetherOre.LOGGER.debug("Add Language Provider");
        event.createProvider(LanguagesProvider.French.Canada::new);
        event.createProvider(LanguagesProvider.French.France::new);

        event.createProvider(LanguagesProvider.English.Australia::new);
        event.createProvider(LanguagesProvider.English.Canada::new);
        event.createProvider(LanguagesProvider.English.NewZealand::new);
        event.createProvider(LanguagesProvider.English.UnitedKingdom::new);
        event.createProvider(LanguagesProvider.English.UnitedStates::new);

        NetherOre.LOGGER.debug("Add Server Provider");

        NetherOre.LOGGER.debug("Add Tags Provider");
        event.createBlockAndItemTags(BlocksTagsProvider::new, ItemsTagsProvider::new);

        NetherOre.LOGGER.debug("Add Datapack Provider");
        event.createProvider(DatapackEntriesProvider::new);

        NetherOre.LOGGER.debug("Add Loot Table Provider");
        event.createProvider(LootTablesProvider::new);

        NetherOre.LOGGER.debug("Add Recipes Provider");
        event.createProvider(RecipesProvider.Runner::new);
    }
}
