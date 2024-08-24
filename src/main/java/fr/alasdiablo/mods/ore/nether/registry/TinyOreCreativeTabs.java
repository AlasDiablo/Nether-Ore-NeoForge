package fr.alasdiablo.mods.ore.nether.registry;

import fr.alasdiablo.mods.lib.api.item.GroundCreativeModeTab;
import fr.alasdiablo.mods.ore.nether.NetherOre;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TinyOreCreativeTabs {
    static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            NetherOre.MOD_ID
    );

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("tab", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();
        GroundCreativeModeTab.createBaseBuilder(builder);
        builder.title(Component.translatable("item_group." + NetherOre.MOD_ID + ".tab"));
        builder.icon(() -> new ItemStack(NetherOreBlocks.NETHER_DIAMOND_ORE.get()));
        builder.displayItems(NetherOreBlocks::displayItemsGenerator);
        return builder.build();
    });


    public static void init(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
