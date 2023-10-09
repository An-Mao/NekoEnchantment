package anmao.mc.ne.am;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class _AM_Effect {
    public static final MobEffect[] DE_BUFF = {
            MobEffects.MOVEMENT_SLOWDOWN,
            MobEffects.DIG_SLOWDOWN,
            MobEffects.HARM,
            MobEffects.CONFUSION,
            MobEffects.BLINDNESS,

            MobEffects.HUNGER,
            MobEffects.WEAKNESS,
            MobEffects.POISON,
            MobEffects.WITHER,
            MobEffects.LEVITATION,

            MobEffects.UNLUCK,
            MobEffects.DARKNESS
    };
    public static final int DEnum = 11;
    public static MobEffect getRandomEffect(){
        return DE_BUFF[_AM.getRandomNumber(0,DEnum)];
    }

    public static MobEffectInstance getRandomEffectI(int time,int lvl){
        return new MobEffectInstance(getRandomEffect(),time,lvl);
    }
}
