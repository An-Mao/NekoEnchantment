package anmao.mc.ne.enchantment.neko.armor.nekoblessing;

import anmao.mc.amlib.math._Math;
import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.NekoEnchantments;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoBlessingEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class NBE{
        private static final float add = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.NEKO_BLESSING,"add");
        private static final float dec = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.NEKO_BLESSING,"dec");
        @SubscribeEvent
        public static void onBaby(BabyEntitySpawnEvent event){
            if (NekoBlessing.ENABLE) {
                if (event.getChild() != null && !event.getChild().level().isClientSide && event.getChild() instanceof Cat) {
                    if (event.getCausedByPlayer() instanceof ServerPlayer player) {
                        Iterable<ItemStack> slotlist = player.getArmorSlots();
                        for (ItemStack slot : slotlist) {
                            int lvl = slot.getEnchantmentLevel(NekoEnchantments.na_blessing);
                            if (lvl > 0) {
                                if (slot.getTag() != null) {
                                    int blessing = slot.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING);
                                    slot.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING, (int) (blessing + add));
                                }
                            }
                        }
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (NekoBlessing.ENABLE) {
                if (!event.getEntity().level().isClientSide && event.getEntity() instanceof Cat) {
                    if (event.getSource().getEntity() instanceof ServerPlayer player) {
                        Iterable<ItemStack> slotlist = player.getArmorSlots();
                        for (ItemStack slot : slotlist) {
                            int lvl = slot.getEnchantmentLevel(NekoEnchantments.na_blessing);
                            if (lvl > 0) {
                                if (slot.getTag() != null) {
                                    int blessing = slot.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING);
                                    slot.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING, (int) (blessing - dec));
                                }
                            }
                        }
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (NekoBlessing.ENABLE) {
                if (!event.getEntity().level().isClientSide) {
                    if (event.getEntity() instanceof ServerPlayer serverPlayer) {
                        Iterable<ItemStack> slotlist = serverPlayer.getArmorSlots();
                        float amount = event.getAmount();
                        for (ItemStack slot : slotlist) {
                            int lvl = slot.getEnchantmentLevel(NekoEnchantments.na_blessing);
                            if (lvl > 0) {
                                if (slot.getTag() != null) {
                                    int blessing = slot.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING);
                                    if (blessing >= 1) {
                                        slot.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING, blessing - 1);
                                        amount *= 0.9F - (float) _Math.log2Floor(blessing) / 100.0f;
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
}
