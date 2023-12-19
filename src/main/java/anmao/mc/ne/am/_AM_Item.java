package anmao.mc.ne.am;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public class _AM_Item {
    public static final int CHEST_SLOT = 102;
    public static double getMainItemDamage(LivingEntity livingEntity){
        return getItemDamage(livingEntity.getMainHandItem());
    }
    public static double getItemDamage(ItemStack itemStack){
        double damage = 0;
        Collection<AttributeModifier> atk = itemStack.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);
        damage = getAddDamage(atk);
        return damage;
    }
    public static double getAddDamage(Collection<AttributeModifier> attlist) {
        double dadd = 0;
        double dbase = 0;
        double dtotal = 1;
        for (AttributeModifier al : attlist) {
            if(al.getOperation() == AttributeModifier.Operation.ADDITION){
                dadd += al.getAmount();
            } else if (al.getOperation() == AttributeModifier.Operation.MULTIPLY_BASE) {
                dbase += al.getAmount();
            } else if (al.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL) {
                dtotal *= 1.0D + al.getAmount();
            }
        }
        return (dadd + dadd * dbase) * dtotal;
    }
    public static int getRandomNumber(int min ,int max){
        return RandomSource.createNewThreadLocalInstance().nextInt(min,max);
        //Random random = new Random();
        //return random.nextInt(max) % (max - min + 1) + min;
    }
}
