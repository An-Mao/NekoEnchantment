package anmao.mc.ne.enchantment.zero.item.bright;

import anmao.mc.ne.enchantment.zero.item.ZeroItemE;

public class Bright extends ZeroItemE {
    public Bright() {
        super(Rarity.VERY_RARE);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
