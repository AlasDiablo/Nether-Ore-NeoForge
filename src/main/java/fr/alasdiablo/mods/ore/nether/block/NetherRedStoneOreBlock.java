package fr.alasdiablo.mods.ore.nether.block;

import fr.alasdiablo.mods.lib.api.block.AngerZombifiedPiglin;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NetherRedStoneOreBlock extends RedStoneOreBlock implements AngerZombifiedPiglin {
    private final IntProvider xpRange;

    public NetherRedStoneOreBlock(IntProvider xpRange) {
        super(BlockBehaviour.Properties.of()
                      .mapColor(MapColor.NETHER)
                      .instrument(NoteBlockInstrument.BASEDRUM)
                      .requiresCorrectToolForDrops()
                      .strength(3.0F, 3.0F)
                      .sound(SoundType.NETHER_GOLD_ORE)
                      .randomTicks()
                      .lightLevel(value -> value.getValue(BlockStateProperties.LIT) ? 6 : 0));

        this.xpRange = xpRange;
    }

    @Override
    public int getExpDrop(
            @NotNull BlockState state,
            @NotNull LevelAccessor level,
            @NotNull BlockPos pos,
            @Nullable BlockEntity blockEntity,
            @Nullable Entity breaker,
            @NotNull ItemStack tool
    ) {
        return this.xpRange.sample(level.getRandom());
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
