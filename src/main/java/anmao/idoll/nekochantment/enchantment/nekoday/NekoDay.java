package anmao.idoll.nekochantment.enchantment.nekoday;

import anmao.idoll.nekochantment.enchantment.EnchantmentRegister;
import anmao.idoll.nekochantment.enchantment.nekonight.NekoNight;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.common.MinecraftForge;

public class NekoDay extends Enchantment {
    public NekoDay(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        if (Minecraft.getInstance().level != null) {
            float damage = 1 + level * 0.5F;
            int time = (int) Minecraft.getInstance().level.getDayTime();
            if (time > 7200 && time < 22800){
                return damage;
            }
            return -damage;
        }
        return 0;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof NekoNight);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
