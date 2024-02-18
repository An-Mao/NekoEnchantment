package anmao.mc.ne.mixin;

import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {
    @Shadow public abstract ItemStack getItem();

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void nekoEnchantment$hurt$preventDestroy(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        if (getItem().getEnchantmentLevel(N_E_S.zi_indestructible)>0){
            cir.setReturnValue(false);
        }
    }
}
