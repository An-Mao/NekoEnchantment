package anmao.mc.ne.enchantment.phenomenon.myriadphenomena;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.phenomenon.PhenomenonEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class MyriadPhenomena extends PhenomenonEnchantment {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.MYRIAD_PHENOMENA);
    public MyriadPhenomena() {
        super(EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND);
    }
}
