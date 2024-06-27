package anmao.mc.ne.mixin;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.gui.ToriNoUtaGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.LayeredDraw;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(Gui.class)
public class GuiMixin {
    @Unique
    private static final boolean nekoEnchantment$ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.TORI_NO_UTA);
    @Final
    @Shadow
    private LayeredDraw layers;
    @Inject(method = "<init>", at = @At("RETURN"))
    public void ne$gui(Minecraft pMinecraft, CallbackInfo ci){
        if  (nekoEnchantment$ENABLE) {
            ToriNoUtaGui nekoUI$toriNoUtaGui = new ToriNoUtaGui(pMinecraft);
            LayeredDraw seg = new LayeredDraw()
                    .add(nekoUI$toriNoUtaGui::render);
            layers.add(seg, () -> !pMinecraft.options.hideGui);
        }
    }
}
