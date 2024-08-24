package fr.alasdiablo.mods.ore.nether.block;

import fr.alasdiablo.mods.lib.api.block.AngerZombifiedPiglin;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

public class NetherOreBlock extends DropExperienceBlock implements AngerZombifiedPiglin {

    public NetherOreBlock(IntProvider xpRange) {
        super(xpRange, BlockBehaviour.Properties.of()
                .mapColor(MapColor.NETHER)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 3.0F)
                .sound(SoundType.NETHER_GOLD_ORE));
    }

    @Override
    public boolean onDestroyedByPlayer(
            @NotNull BlockState state,
            @NotNull Level level,
            @NotNull BlockPos pos,
            @NotNull Player player,
            boolean willHarvest,
            @NotNull FluidState fluid
    ) {
        this.anger(player, level, pos);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
