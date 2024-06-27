package anmao.mc.ne.enchant.neko.armor.nekoblessing;

import anmao.mc.amlib.math._Math;
import anmao.mc.ne.NE;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantData;
import anmao.mc.ne.core.EnchantDataReg;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.core.Enchants;
import net.minecraft.nbt.CompoundTag;
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
        private static final int add = (int) EnchantmentsConfig.INSTANCE.getValue(EnchantReg.NEKO_BLESSING,"add");
        private static final int dec = (int) EnchantmentsConfig.INSTANCE.getValue(EnchantReg.NEKO_BLESSING,"dec");
        @SubscribeEvent
        public static void onBaby(BabyEntitySpawnEvent event){
            if (NekoBlessing.ENABLE) {
                if (event.getChild() != null && !event.getChild().level().isClientSide && event.getChild() instanceof Cat) {
                    if (event.getCausedByPlayer() instanceof ServerPlayer player) {
                        Iterable<ItemStack> slotlist = player.getArmorSlots();
                        for (ItemStack slot : slotlist) {
                            if (EnchantHelper.hasEnchant(slot, Enchants.na_blessing)) {
                                changeBless(slot,add);
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
                            if (EnchantHelper.hasEnchant(slot, Enchants.na_blessing)) {
                                changeBless(slot,-dec);
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

                            int lvl = EnchantHelper.getEnchantLevel(slot, Enchants.na_blessing);
                            if (lvl > 0) {
                                EnchantData enchantData = EnchantHelper.getEnchantData(slot);
                                CompoundTag nbt = enchantData.getTagCopy();
                                CompoundTag blessData = nbt.getCompound("bless.data");
                                int blessing = blessData.getInt(NekoBlessing.ENCHANTMENT_KEY_BLESSING);
                                if (blessing >= 1) {
                                    blessData.putInt(NekoBlessing.ENCHANTMENT_KEY_BLESSING, blessing - 1);
                                    nbt.put("bless.data", blessData);
                                    enchantData = new EnchantData(nbt);
                                    slot.set(EnchantDataReg.Enchant_Data.get(), enchantData);
                                    amount *= 0.9F - (float) _Math.log2Floor(blessing) / 100.0f;
                                }
                            }
                        }
                        event.setAmount(amount);
                    }
                }
            }
        }
    }
    public static int changeBless(ItemStack itemStack, int value) {
        EnchantData enchantData = EnchantHelper.getEnchantData(itemStack);
        CompoundTag nbt = enchantData.getTagCopy();
        CompoundTag blessData = nbt.getCompound("bless.data");
        int blessing = blessData.getInt(NekoBlessing.ENCHANTMENT_KEY_BLESSING);
        blessing += value;
        blessData.putInt(NekoBlessing.ENCHANTMENT_KEY_BLESSING, blessing);
        nbt.put("bless.data", blessData);
        enchantData = new EnchantData(nbt);
        itemStack.set(EnchantDataReg.Enchant_Data.get(), enchantData);
        return blessing;
    }
}
