package anmao.idoll.nekochantment.enchantment.neko.item.nekolove;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.am._AM_Constant;
import anmao.idoll.nekochantment.enchantment.NE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.UUID;

public class NekoLoveEvent {
    /*
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class NLES{
        private static List<Player> playerList = new ArrayList<>();

        public static List<Player> getPlayerList() {
            MinecraftForge.EVENT_BUS.register(NLES.class);
            return playerList;
        }

        @SubscribeEvent
        public static void onTick(TickEvent.ServerTickEvent event){
            if (event.phase == TickEvent.Phase.END){
                playerList.clear();
                for (Player player: //) {
                    playerList.add(player);
                }
                MinecraftForge.EVENT_BUS.unregister(NLES.class);
            }
        }
    }

     */
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class NLE{
        @SubscribeEvent
        public static void onSpawn(EntityJoinLevelEvent event){
            if (event.getEntity() instanceof ItemEntity item && !item.level().isClientSide){
                ItemStack oitem = item.getItem();
                if (oitem.getEnchantmentLevel(NE.ni_love) > 0){
                    if (oitem.getTag() != null) {
                        if (oitem.getTag().hasUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE)) {
                            UUID uuid = oitem.getTag().getUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE);
                            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
                            if (server != null) {
                                ServerPlayer serverPlayer = server.getPlayerList().getPlayer(uuid);
                                if (serverPlayer != null) {
                                    serverPlayer.getInventory().placeItemBackInInventory(oitem);
                                    event.setCanceled(true);
                                }
                            }
                        }
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onAnvil(AnvilUpdateEvent anvilUpdateEvent) {
            if (!anvilUpdateEvent.getPlayer().level().isClientSide && anvilUpdateEvent.getLeft().getEnchantmentLevel(NE.ni_love) > 0 ){
                if (anvilUpdateEvent.getLeft().getTag() != null && anvilUpdateEvent.getLeft().getTag().hasUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE)){
                    return;
                }
                Item ritem = anvilUpdateEvent.getRight().getItem();
                if (ritem == Items.TROPICAL_FISH){
                    ItemStack oitem = anvilUpdateEvent.getLeft().copy();
                    CompoundTag oitemnbt = oitem.getTag();
                    if (oitemnbt != null) {
                        oitemnbt.putUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE,anvilUpdateEvent.getPlayer().getUUID());
                    }
                    oitem.setTag(oitemnbt);
                    anvilUpdateEvent.setOutput(oitem);
                    anvilUpdateEvent.setCost(1);
                    anvilUpdateEvent.setMaterialCost(1);
                }
            }
        }
        @SubscribeEvent
        public static void onItemUse(LivingEntityUseItemEvent.Start event){
            if (!event.getEntity().level().isClientSide){
                LivingEntity e = event.getEntity();
                ItemStack oitem = event.getItem();
                if (oitem.getTag() != null && oitem.getTag().hasUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE)) {
                    UUID uuid = oitem.getTag().getUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE);
                    if (e.getUUID().equals(uuid)){
                        e.hurt(e.damageSources().fellOutOfWorld(),e.getMaxHealth() * 0.2F);
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onToss(ItemTossEvent event) {
            ItemEntity entity = event.getEntity();
            if (!entity.level().isClientSide){
                ItemStack ditem = entity.getItem();
                if (ditem.getEnchantmentLevel(NE.ni_love) > 0){
                    if (ditem.getTag() != null && ditem.getTag().hasUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE)) {
                        UUID uuid = ditem.getTag().getUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE);
                        if (event.getPlayer().getUUID().equals(uuid)) {
                            event.getPlayer().getInventory().placeItemBackInInventory(ditem);
                            event.setCanceled(true);
                        }
                    }
                }
            }
        }
    }

}
