package anmao.mc.ne.enchant.phenomenon.duality;

import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = NE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DualityEvent {
    public static final int maxDuality = 40;
    public static final int minDuality = -40;
    public static int ticks = 0;
    public static HashMap<UUID,Boolean> playerData = new HashMap<>();
    @SubscribeEvent
    public static void onBaby(BabyEntitySpawnEvent event){
        if (Duality.ENABLE && event.getChild() != null && event.getCausedByPlayer() instanceof ServerPlayer player){
            ItemStack item = player.getMainHandItem();
            if (EnchantHelper.hasEnchant(item, Enchants.duality)){
                CompoundTag nbt = EnchantHelper.getEnchantData(item).getTagCopy();
                CompoundTag dualityData = nbt.getCompound("duality.data");
                dualityData.putInt("duality",dualityData.getInt("duality")+1);
                nbt.put("duality.data",dualityData);
                EnchantHelper.setEnchantData(item,nbt);
            }
        }
    }
    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event){
        if (Duality.ENABLE && event.getSource().getEntity() instanceof ServerPlayer player){
            ItemStack item = player.getMainHandItem();
            if (EnchantHelper.hasEnchant(item, Enchants.duality)){
                CompoundTag nbt = EnchantHelper.getEnchantData(item).getTagCopy();
                CompoundTag dualityData = nbt.getCompound("duality.data");
                dualityData.putInt("duality",Math.max(minDuality,dualityData.getInt("duality")-1));
                nbt.put("duality.data",dualityData);
                EnchantHelper.setEnchantData(item,nbt);
            }
        }
    }

    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
            ItemStack item = serverPlayer.getMainHandItem();
            if (EnchantHelper.hasEnchant(item, Enchants.duality)){
                for (ItemEntity drop : event.getDrops()) {
                    ItemStack di = drop.getItem();
                    di.setCount(di.getCount() * 2);
                }
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (Duality.ENABLE) {
            ticks++;
            if (event.player instanceof ServerPlayer serverPlayer && event.phase == TickEvent.Phase.END && ticks > 600) {
                ticks = 0;
                ItemStack item = serverPlayer.getMainHandItem();
                if (EnchantHelper.hasEnchant(item, Enchants.duality)) {
                    boolean sub = playerData.getOrDefault(serverPlayer.getUUID(), true);
                    CompoundTag nbt = EnchantHelper.getEnchantData(item).getTagCopy();
                    CompoundTag dualityData = nbt.getCompound("duality.data");
                    int d = dualityData.getInt("duality");
                    if (sub) {
                        d++;
                    } else {
                        d--;
                    }
                    if (d >= maxDuality || d <= minDuality) {
                        playerData.put(serverPlayer.getUUID(), !sub);
                    }
                    dualityData.putInt("duality", d);
                    nbt.put("duality.data", dualityData);
                    EnchantHelper.setEnchantData(item, nbt);
                }
            }
        }
    }
    @SubscribeEvent
    public static void onLooting(LootingLevelEvent event){
        if (Duality.ENABLE) {
            if (event.getDamageSource() != null && event.getDamageSource().getEntity() instanceof ServerPlayer player) {
                int looting = event.getLootingLevel();
                int a = 0;
                ItemStack item = player.getMainHandItem();
                CompoundTag nbt = EnchantHelper.getAllData(item);
                CompoundTag dualityData = nbt.getCompound("duality.data");
                a = dualityData.getInt("duality");
                if (a > 0) {
                    a /= 5;
                    looting += a;
                }
                event.setLootingLevel(looting);
            }
        }
    }
}
