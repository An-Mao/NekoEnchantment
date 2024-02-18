package anmao.mc.ne.enchantment.neko.item.nekoking;

import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.enchantment.neko.item.NekoEI;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;

public class NekoKing extends NekoEI {
    public NekoKing() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        float refine = 0;
        if (enchantedItem.getTag() != null) {
            refine += enchantedItem.getTag().getFloat(_AM_Constant.ENCHANTMENT_KEY_REFINE) / 20;
        }
        return refine + 1;
    }
}
