package anmao.mc.ne.enchantment.neko.item.nekoemperor;

import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.enchantment.neko.NekoEC;
import anmao.mc.ne.enchantment.neko.item.NekoEI;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;

public class NekoEmperor extends NekoEI {
    public NekoEmperor() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        float kill = 0;
        if (enchantedItem.getTag() != null) {
            kill += enchantedItem.getTag().getFloat(_AM_Constant.ENCHANTMENT_KEY_KILL) / 50;
        }
        return kill + 1;
    }
}
