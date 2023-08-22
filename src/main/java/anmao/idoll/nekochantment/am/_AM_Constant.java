package anmao.idoll.nekochantment.am;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class _AM_Constant {
    public static final String ENCHANTMENT_KEY_SOUL = "soul";
    public static final String ENCHANTMENT_KEY_REFINE = "refine";
    public static final String ENCHANTMENT_KEY_KILL = "kill";
    public static final MobEffectInstance[] EFFECTS = {
            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,1000,3)
    };
    public static final DamageSource[] DAMAGE_SOURCES = {
    };
}
