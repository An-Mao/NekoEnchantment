package anmao.mc.ne.enchant.neko.item.nekoemperor;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.item.NekoEI;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class NekoEmperor extends NekoEI {
    public static final String ENCHANTMENT_KEY_KILL = "kill";
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_EMPEROR);
    private final float quota = EnchantmentsConfig.INSTANCE.getValue(EnchantReg.NEKO_EMPEROR,"quota");
    public NekoEmperor() {
        super();
    }

    @Override
    public float getDamageBonus(int level, Entity mobType, ItemStack enchantedItem) {
        float kill = 1;
        CompoundTag nbt = EnchantHelper.getEnchantData(enchantedItem).getTagCopy();
        CompoundTag em = nbt.getCompound("emperor.data");
        kill += em.getFloat(ENCHANTMENT_KEY_KILL) / quota;
        em.putFloat(ENCHANTMENT_KEY_KILL, kill);
        nbt.put("emperor.data", em);
        EnchantHelper.setEnchantData(enchantedItem, nbt);
        return kill;
    }
}
