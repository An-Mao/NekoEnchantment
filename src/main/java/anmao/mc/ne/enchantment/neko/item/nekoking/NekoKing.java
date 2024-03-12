package anmao.mc.ne.enchantment.neko.item.nekoking;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.neko.item.NekoEI;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;

public class NekoKing extends NekoEI {
    public static final String ENCHANTMENT_KEY_REFINE = "refine";
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_KING);
    private final float quota = EnchantmentsConfig.INSTANCE.getConfig(EnchantmentRegister.NEKO_KING).getParameters().get("quota").getAsFloat();
    public NekoKing() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        float refine = 1;
        if (enchantedItem.getTag() != null) {
            refine += enchantedItem.getTag().getFloat(ENCHANTMENT_KEY_REFINE) / quota ;
        }
        return refine;
    }
}
