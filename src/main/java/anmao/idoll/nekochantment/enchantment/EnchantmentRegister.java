package anmao.idoll.nekochantment.enchantment;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.enchantment.nekoblade.NekoBlade;
import anmao.idoll.nekochantment.enchantment.nekoemperor.NekoEmperor;
import anmao.idoll.nekochantment.enchantment.nekogod.NekoGod;
import anmao.idoll.nekochantment.enchantment.nekoking.NekoKing;
import anmao.idoll.nekochantment.enchantment.nekomeow.NekoMeow;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentRegister {
    public static final DeferredRegister<Enchantment> Enchantments = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, NekoEnchantment.MODID);
    public static RegistryObject<Enchantment> NEKO_BLADE = Enchantments.register("neko_blade",()->new NekoBlade(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_GOD = Enchantments.register("neko_god",()->new NekoGod(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_MEOW = Enchantments.register("neko_meow",()->new NekoMeow(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_KING = Enchantments.register("neko_king",()->new NekoKing(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_EMPEROR = Enchantments.register("neko_emperor",()->new NekoEmperor(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static void register(IEventBus eventBus){Enchantments.register(eventBus);}
}
