package anmao.mc.ne.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getMobLooting", at = @At("RETURN"),cancellable = true)
    private static void nekoEnchantment$getMobLooting$uploot(LivingEntity entity, CallbackInfoReturnable<Integer> i){
        int looting = i.getReturnValue();
        int a = 0;
        if (entity instanceof ServerPlayer player){
            ItemStack item = player.getMainHandItem();
            if (item.getTag() != null) {
                a = item.getTag().getInt("duality");
                if (a > 0){
                    a /= 5;
                    looting += a;
                }
            }
        }
        i.setReturnValue(looting);
    }
}
