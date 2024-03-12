package anmao.mc.ne.enchantment.neko.item.nekoemperor;

import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.neko.item.NekoEI;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;

public class NekoEmperor extends NekoEI {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_EMPEROR);
    private final float quota = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.NEKO_EMPEROR,"quota");
    public NekoEmperor() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        float kill = 1;
        if (enchantedItem.getTag() != null) {
            kill += enchantedItem.getTag().getFloat(_AM_Constant.ENCHANTMENT_KEY_KILL) / quota;
        }
        return kill;
    }
}
