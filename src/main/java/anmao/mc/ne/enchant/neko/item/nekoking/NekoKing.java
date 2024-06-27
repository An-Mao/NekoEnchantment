package anmao.mc.ne.enchant.neko.item.nekoking;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.item.NekoEI;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class NekoKing extends NekoEI {
    public static final String ENCHANTMENT_KEY_REFINE = "refine";
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_KING);
    private final float quota = EnchantmentsConfig.INSTANCE.getConfig(EnchantReg.NEKO_KING).getParameters().get("quota").getAsFloat();
    public NekoKing() {
        super();
    }

    @Override
    public float getDamageBonus(int level, Entity mobType, ItemStack enchantedItem) {
        float refine = 1;
        CompoundTag nbt = EnchantHelper.getEnchantData(enchantedItem).getTagCopy();
        CompoundTag em = nbt.getCompound("king.data");
        refine += em.getFloat(ENCHANTMENT_KEY_REFINE) / quota;
        return refine;
    }
}
