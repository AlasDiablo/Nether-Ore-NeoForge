package fr.alasdiablo.mods.ore.nether;

import com.mojang.logging.LogUtils;
import fr.alasdiablo.mods.ore.nether.data.*;
import fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks;
import fr.alasdiablo.mods.ore.nether.registry.TinyOreCreativeTabs;
import fr.alasdiablo.mods.ore.nether.tag.NetherOreTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

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
    }

    private void gatherData(@NotNull GatherDataEvent event) {
        NetherOre.LOGGER.debug("Start data generator");
        final DataGenerator                            generator          = event.getGenerator();
        final PackOutput                               output             = generator.getPackOutput();
        final CompletableFuture<HolderLookup.Provider> lookup             = event.getLookupProvider();
        final ExistingFileHelper                       existingFileHelper = event.getExistingFileHelper();

        NetherOre.LOGGER.debug("Add Client Provider");

        NetherOre.LOGGER.debug("Add Block State Provider");
        generator.addProvider(event.includeClient(), new BlockStatesProvider(output, existingFileHelper));

        NetherOre.LOGGER.debug("Add Language Provider");
        generator.addProvider(event.includeClient(), new LanguagesProvider.French.Canada(output));
        generator.addProvider(event.includeClient(), new LanguagesProvider.French.France(output));

        generator.addProvider(event.includeClient(), new LanguagesProvider.English.Australia(output));
        generator.addProvider(event.includeClient(), new LanguagesProvider.English.Canada(output));
        generator.addProvider(event.includeClient(), new LanguagesProvider.English.NewZealand(output));
        generator.addProvider(event.includeClient(), new LanguagesProvider.English.UnitedKingdom(output));
        generator.addProvider(event.includeClient(), new LanguagesProvider.English.UnitedStates(output));

        NetherOre.LOGGER.debug("Add Server Provider");

        NetherOre.LOGGER.debug("Add Tags Provider");
        final BlocksTagsProvider blockTagsProvider = new BlocksTagsProvider(output, lookup, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ItemsTagsProvider(output, lookup, blockTagsProvider, existingFileHelper));

        NetherOre.LOGGER.debug("Add Datapack Provider");
        generator.addProvider(event.includeServer(), new DatapackEntriesProvider(output, lookup));

        NetherOre.LOGGER.debug("Add Loot Table Provider");
        generator.addProvider(event.includeServer(), new LootTablesProvider(output, lookup));

        NetherOre.LOGGER.debug("Add Recipes Provider");
        generator.addProvider(event.includeServer(), new RecipesProvider(output, lookup));
    }
}
