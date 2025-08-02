package fr.alasdiablo.mods.ore.nether.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class NetherOreConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue ZOMBIFIED_PIGLIN_ANGER = BUILDER
            .comment("Mining Nether Ore will anger zombified piglins.")
            .define("zombifiedPiglinAnger", true);

    public static final ModConfigSpec.IntValue ZOMBIFIED_PIGLIN_ANGER_RANGE = BUILDER
            .comment("Nether Ore will anger zombified piglins within this range of the player. (In blocks)")
            .defineInRange("zombifiedPiglinAngerRange", 10, 0, 127);

    public static final ModConfigSpec SPEC = BUILDER.build();
}
