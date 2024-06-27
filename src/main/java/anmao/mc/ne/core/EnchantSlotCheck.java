package anmao.mc.ne.core;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public class EnchantSlotCheck {
    public static boolean isWeapon(Item stack) {
         return stack instanceof SwordItem;
    }
    public static boolean isWeapon(ItemStack stack) {
        return isWeapon(stack.getItem());
    }
    public static boolean isArmor(Item stack) {
        return stack instanceof ArmorItem;
    }
    public static boolean isArmor(ItemStack stack) {
        return isArmor(stack.getItem());
    }
    public static boolean isDigger(Item stack) {
        return stack instanceof DiggerItem;
    }
    public static boolean isDigger(ItemStack stack) {
        return isDigger(stack.getItem());
    }
    public static boolean isFishingRod(Item stack) {
        return stack instanceof FishingRodItem;
    }
    public static boolean isFishingRod(ItemStack stack) {
        return isFishingRod(stack.getItem());
    }
    public static boolean isHoe(Item stack) {
        return stack instanceof HoeItem;
    }
    public static boolean isHoe(ItemStack stack) {
        return isHoe(stack.getItem());
    }
    public static boolean isPickaxe(Item stack) {
        return stack instanceof PickaxeItem;
    }
    public static boolean isPickaxe(ItemStack stack) {
        return isPickaxe(stack.getItem());
    }
    public static boolean isShovel(Item stack) {
        return stack instanceof ShovelItem;
    }
    public static boolean isShovel(ItemStack stack) {
        return isShovel(stack.getItem());
    }
    public static boolean isSword(Item stack) {
        return stack instanceof SwordItem;
    }
    public static boolean isSword(ItemStack stack) {
        return isSword(stack.getItem());
    }
    public static boolean isBow(Item stack) {
        return stack instanceof BowItem;
    }
    public static boolean isBow(ItemStack stack) {
        return isBow(stack.getItem());
    }
    public static boolean isHead(Item item){
        return isArmor(item) && ((ArmorItem) item).getEquipmentSlot() == EquipmentSlot.HEAD;
    }
    public static boolean isChest(Item item){
        return isArmor(item)  && ((ArmorItem) item).getEquipmentSlot() == EquipmentSlot.CHEST;
    }
    public static boolean isLegs(Item item){
        return isArmor(item)  && ((ArmorItem) item).getEquipmentSlot() == EquipmentSlot.LEGS;
    }
    public static boolean isFeet(Item item){
        return isArmor(item) && ((ArmorItem) item).getEquipmentSlot() == EquipmentSlot.FEET;
    }
    public static boolean isHead(ItemStack item){
        return isArmor(item) &&  item.getEquipmentSlot() == EquipmentSlot.HEAD;
    }
    public static boolean isChest(ItemStack item){
        return isArmor(item)  && item.getEquipmentSlot() == EquipmentSlot.CHEST;
    }
    public static boolean isLegs(ItemStack item){
        return isArmor(item)  && item.getEquipmentSlot() == EquipmentSlot.LEGS;
    }
    public static boolean isFeet(ItemStack item){
        return isArmor(item) && item.getEquipmentSlot() == EquipmentSlot.FEET;
    }

}
