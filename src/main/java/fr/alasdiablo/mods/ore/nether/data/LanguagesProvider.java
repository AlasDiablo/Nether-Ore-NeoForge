package fr.alasdiablo.mods.ore.nether.data;

import fr.alasdiablo.mods.ore.nether.NetherOre;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static fr.alasdiablo.mods.ore.nether.registry.NetherOreBlocks.*;

public class LanguagesProvider {
    private static class Global extends LanguageProvider {
        protected Global(PackOutput output, String locale) {
            super(output, NetherOre.MOD_ID, locale);
        }

        @Override
        protected void addTranslations() {
            this.add("item_group." + NetherOre.MOD_ID + ".tab", "Dio's Nether Ore");
        }
    }

    public static class English {
        private static class Common extends Global {
            protected Common(PackOutput output, String locale) {
                super(output, locale);
            }

            @Override
            protected void addTranslations() {
                super.addTranslations();

                this.add(NETHER_COAL_ORE.get(), "Nether Coal Ore");
                this.add(NETHER_COPPER_ORE.get(), "Nether Copper Ore");
                this.add(NETHER_DIAMOND_ORE.get(), "Nether Diamond Ore");
                this.add(NETHER_EMERALD_ORE.get(), "Nether Emerald Ore");
                this.add(NETHER_IRON_ORE.get(), "Nether Iron Ore");
                this.add(NETHER_LAPIS_ORE.get(), "Nether Lapis Lazuli Ore");
                this.add(NETHER_REDSTONE_ORE.get(), "Nether Redstone Ore");
            }
        }

        public static class UnitedKingdom extends Common {
            public UnitedKingdom(PackOutput output) {
                super(output, "en_gb");
            }
        }

        public static class UnitedStates extends Common {
            public UnitedStates(PackOutput output) {
                super(output, "en_us");
            }
        }

        public static class Canada extends Common {
            public Canada(PackOutput output) {
                super(output, "en_ca");
            }
        }

        public static class Australia extends Common {
            public Australia(PackOutput output) {
                super(output, "en_au");
            }
        }

        public static class NewZealand extends Common {
            public NewZealand(PackOutput output) {
                super(output, "en_nz");
            }
        }
    }

    public static class French {
        private static class Common extends Global {
            protected Common(PackOutput output, String locale) {
                super(output, locale);
            }

            @Override
            protected void addTranslations() {
                super.addTranslations();

                this.add(NETHER_COAL_ORE.get(), "Minerai de charbon minuscule");
                this.add(NETHER_COPPER_ORE.get(), "Minerai de cuivre minuscule");
                this.add(NETHER_DIAMOND_ORE.get(), "Minerai de diamant minuscule");
                this.add(NETHER_EMERALD_ORE.get(), "Minerai d'émeraude minuscule");
                this.add(NETHER_IRON_ORE.get(), "Minerai de fer minuscule");
                this.add(NETHER_LAPIS_ORE.get(), "Minerai de lapis-lazuli minuscule");
                this.add(NETHER_REDSTONE_ORE.get(), "Minerai de redstone minuscule");
            }
        }

        public static class France extends Common {
            public France(PackOutput output) {
                super(output, "fr_fr");
            }
        }

        public static class Canada extends Common {
            public Canada(PackOutput output) {
                super(output, "fr_ca");
            }
        }
    }
}

