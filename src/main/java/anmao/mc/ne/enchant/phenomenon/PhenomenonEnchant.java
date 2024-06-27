package anmao.mc.ne.enchant.phenomenon;

import anmao.mc.amlib.component.ComponentStyle;
import anmao.mc.ne.core.Enchant;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PhenomenonEnchant extends Enchant {
    protected PhenomenonEnchant( ) {
        super();
    }
    @Override
    public @NotNull Component getFullname(int pLevel) {
        return ComponentStyle.Flash(Component.translatable(this.getDescriptionId()).getString(),System.currentTimeMillis()/50);
        //return _AM_Color.RainbowTextColor(Component.translatable(this.getDescriptionId()).getString(),System.currentTimeMillis()/50);
    }
    @Override
    public boolean canEnchant(ItemStack stack) {
        if (isWeapon(stack)) {
            return true;
        }
        return super.canEnchant(stack);
    }
}
