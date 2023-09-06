package anmao.idoll.nekochantment.enchantment.neko.armor.nekoblessing;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.am._AM;
import anmao.idoll.nekochantment.am._AM_Constant;
import anmao.idoll.nekochantment.enchantment.NE;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoBlessingEvent {
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class NBE{
        @SubscribeEvent
        public static void onBaby(BabyEntitySpawnEvent event){
            if (event.getChild() != null && !event.getChild().level().isClientSide && event.getChild() instanceof Cat){
                if (event.getCausedByPlayer() instanceof ServerPlayer player) {
                    Iterable<ItemStack> slotlist = player.getArmorSlots();
                    for (ItemStack slot : slotlist) {
                        int lvl = slot.getEnchantmentLevel(NE.na_blessing);
                        if (lvl > 0) {
                            if (slot.getTag() != null) {
                                int blessing = slot.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING);
                                slot.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING, blessing + 1);
                            }
                        }
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (!event.getEntity().level().isClientSide && event.getEntity() instanceof Cat){
                if (event.getSource().getEntity() instanceof ServerPlayer player) {
                    Iterable<ItemStack> slotlist = player.getArmorSlots();
                    for (ItemStack slot : slotlist) {
                        int lvl = slot.getEnchantmentLevel(NE.na_blessing);
                        if (lvl > 0) {
                            if (slot.getTag() != null) {
                                int blessing = slot.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING);
                                slot.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING, blessing - 2);
                            }
                        }
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if(!event.getEntity().level().isClientSide){
                if (event.getEntity() instanceof ServerPlayer serverPlayer){
                    Iterable<ItemStack> slotlist = serverPlayer.getArmorSlots();
                    float amount = event.getAmount();
                    for (ItemStack slot : slotlist){
                        int lvl = slot.getEnchantmentLevel(NE.na_blessing);
                        if (lvl > 0){
                            if (slot.getTag() != null) {
                                int blessing =slot.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING);
                                if (blessing >= 1){
                                    slot.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING,blessing-1);
                                    amount *= 0.9F - (float) _AM.log2Floor(blessing) / 100.0f;
                                }
                            }
                        }
                    }
                    event.setAmount(amount);
                }
            }
        }
    }
}
