package anmao.mc.ne.enchantment.phenomenon.theworld;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Item;
import anmao.mc.ne.enchantment.N_E_S;
import anmao.mc.ne.mixin.EntityTickListMixin;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class TheWorldEvent {
    @SubscribeEvent
    public static void onAttack(LivingAttackEvent event){
        Entity entity = event.getEntity();
        Entity sEntity = event.getSource().getEntity();
        if (entity == null || sEntity == null){
            return;
        }
        if (entity instanceof ServerPlayer player && !(sEntity instanceof ServerPlayer)){
            if (EnchantmentHelper.getEnchantmentLevel(N_E_S.the_world,player) > 0) {
                setTheWorldTime(sEntity);
            }
        }else if (sEntity instanceof ServerPlayer serverPlayer) {
            if (_AM_Item.hasEnchant(serverPlayer.getMainHandItem(), N_E_S.the_world)) {
                setTheWorldTime(entity);
                //entity.load(nbt);
                //System.out.println(gameTime+"::::" + entity.getPersistentData().getLong("theWorld"));
                /*
                if (entity instanceof Mob mob) {
                    mob.setNoAi(true);
                }
                 */
            }
        }
    }
    public static void setTheWorldTime(Entity e){
        CompoundTag nbt = e.getPersistentData();
        long gameTime = e.level().getGameTime();
        nbt.putLong("theWorld", gameTime);
    }
}
