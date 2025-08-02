package fr.alasdiablo.mods.ore.nether.block;

import fr.alasdiablo.mods.ore.nether.config.NetherOreConfig;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public interface AngerZombifiedPiglin {
    default void anger(Player player, Level level) {
        if (!NetherOreConfig.ZOMBIFIED_PIGLIN_ANGER.getAsBoolean()) {
            return;
        }

        int aggroRange = NetherOreConfig.ZOMBIFIED_PIGLIN_ANGER_RANGE.getAsInt();
        Vec3 position = player.position();

        final float x = (float) position.x(), y = (float) position.y(), z = (float) position.z();
        List<ZombifiedPiglin> list = level.getEntitiesOfClass(
                ZombifiedPiglin.class,
                AABB.of(new BoundingBox(
                                Math.round(x - aggroRange),
                                Math.round(y - aggroRange),
                                Math.round(z - aggroRange),
                                Math.round(x + aggroRange + 1),
                                Math.round(y + aggroRange + 1),
                                Math.round(z + aggroRange + 1)
                        )
                )
        );
        list.forEach(e -> e.setTarget(player));
    }
}
