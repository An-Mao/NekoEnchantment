package anmao.mc.ne.mixin;

import anmao.mc.ne.config.C_E_O;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityTickList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.function.Consumer;


@Mixin(EntityTickList.class)
public abstract class EntityTickListMixin {
    @Shadow
    private Int2ObjectMap<Entity> active;
    @Shadow
    @Nullable
    private Int2ObjectMap<Entity> iterated;
    /**
     * @author AnMao
     * @reason The World Enchantment
     */
    @Overwrite
    public void forEach(Consumer<Entity> pEntity) {
        if (this.iterated != null) {
            throw new UnsupportedOperationException("Only one concurrent iteration supported");
        } else {
            this.iterated = this.active;

            try {
                for(Entity entity : this.active.values()) {
                    long theWorld = entity.getPersistentData().getLong("theWorld");
                    //Log.LOG.debug("the World:" + theWorld);
                    if (theWorld > 0 && entity.level().getGameTime() - theWorld < C_E_O.theWorldStopTick) {
                        continue;
                    }
                    pEntity.accept(entity);
                }
            } finally {
                this.iterated = null;
            }

        }
    }
}
