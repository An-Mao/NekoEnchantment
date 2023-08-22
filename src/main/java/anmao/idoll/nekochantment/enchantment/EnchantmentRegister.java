package anmao.idoll.nekochantment.enchantment;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.enchantment.nekoblade.NekoBlade;
import anmao.idoll.nekochantment.enchantment.nekoblessing.NekoBlessing;
import anmao.idoll.nekochantment.enchantment.nekoday.NekoDay;
import anmao.idoll.nekochantment.enchantment.nekoemperor.NekoEmperor;
import anmao.idoll.nekochantment.enchantment.nekogod.NekoGod;
import anmao.idoll.nekochantment.enchantment.nekoking.NekoKing;
import anmao.idoll.nekochantment.enchantment.nekomeow.NekoMeow;
import anmao.idoll.nekochantment.enchantment.nekomirror.NekoMirror;
import anmao.idoll.nekochantment.enchantment.nekonight.NekoNight;
import anmao.idoll.nekochantment.enchantment.nekoninja.NekoNinja;
import anmao.idoll.nekochantment.enchantment.nekosoul.NekoSoul;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentRegister {
    public static final DeferredRegister<Enchantment> Enchantments = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, NekoEnchantment.MODID);
    public static RegistryObject<Enchantment> NEKO_BLADE = Enchantments.register("neko_blade",()->new NekoBlade(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_GOD = Enchantments.register("neko_god",()->new NekoGod(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_MEOW = Enchantments.register("neko_meow",()->new NekoMeow(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_KING = Enchantments.register("neko_king",()->new NekoKing(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_EMPEROR = Enchantments.register("neko_emperor",()->new NekoEmperor(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_DAY = Enchantments.register("neko_day",()->new NekoDay(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_NIGHT = Enchantments.register("neko_night",()->new NekoNight(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_NINJA = Enchantments.register("neko_ninja",()->new NekoNinja(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, EquipmentSlot.CHEST));
    public static RegistryObject<Enchantment> NEKO_SOUL = Enchantments.register("neko_soul",()->new NekoSoul(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlot.CHEST));
    public static RegistryObject<Enchantment> NEKO_BLESSING = Enchantments.register("neko_blessing",()->new NekoBlessing(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlot.FEET));
    public static RegistryObject<Enchantment> NEKO_MIRROR = Enchantments.register("neko_mirror",()->new NekoMirror(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR,EquipmentSlot.CHEST));
    public static void register(IEventBus eventBus){Enchantments.register(eventBus);}
}
