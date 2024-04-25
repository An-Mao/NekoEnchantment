package anmao.mc.ne.enchantment.zero.tool;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.zero.ZeroEnchantmentCore;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ChainHarvesting extends ZeroEnchantmentCore {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.TORI_NO_UTA);
    public static final int radius = (int) EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.ChainHarvesting,"radius");
    public static final int depths = (int) EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.ChainHarvesting,"depths");
    public ChainHarvesting() {
        super(Rarity.VERY_RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND);
    }
}
