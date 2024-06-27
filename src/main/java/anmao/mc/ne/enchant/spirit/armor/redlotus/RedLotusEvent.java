package anmao.mc.ne.enchant.spirit.armor.redlotus;

import anmao.mc.amlib.entity.player.PlayerInvasionSlotCDT;
import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.effect.Effects;
import anmao.mc.ne.core.Enchants;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class RedLotusEvent {
    private static final MobEffectInstance EvilCreature = new MobEffectInstance(Effects.EVIL_CREATURE.getHolder().get(),1,20);
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class RLE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (RedLotus.ENABLE && event.getEntity() instanceof ServerPlayer serverPlayer){
                if (EnchantHelper.hasEnchant(serverPlayer.getSlot(PlayerInvasionSlotCDT.CHEST_SLOT).get(), Enchants.oa_red_lotus)){
                    if (event.getSource().getEntity() instanceof LivingEntity livingEntity){
                        livingEntity.hurt(serverPlayer.damageSources().fellOutOfWorld(),event.getAmount()* 0.5f);
                        livingEntity.addEffect(EvilCreature);
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onDamage(LivingDamageEvent event){
            if (RedLotus.ENABLE && event.getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item = serverPlayer.getSlot(PlayerInvasionSlotCDT.CHEST_SLOT).get();
                if (EnchantHelper.hasEnchant(item, Enchants.oa_red_lotus)){
                    if (event.getSource().getEntity() instanceof LivingEntity livingEntity){
                        if (livingEntity.hasEffect(Effects.EVIL_CREATURE.getHolder().get())){
                            item.setDamageValue(Math.min(item.getDamageValue()+1,item.getMaxDamage()));
                        }
                    }
                }
            }
        }
    }
}
