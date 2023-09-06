package anmao.idoll.nekochantment.enchantment;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.enchantment.neko.item.nekoblade.NekoBlade;
import anmao.idoll.nekochantment.enchantment.neko.armor.nekoblessing.NekoBlessing;
import anmao.idoll.nekochantment.enchantment.neko.item.nekochop.NekoChop;
import anmao.idoll.nekochantment.enchantment.neko.item.nekoday.NekoDay;
import anmao.idoll.nekochantment.enchantment.neko.item.nekoemperor.NekoEmperor;
import anmao.idoll.nekochantment.enchantment.neko.item.nekogod.NekoGod;
import anmao.idoll.nekochantment.enchantment.neko.item.nekoking.NekoKing;
import anmao.idoll.nekochantment.enchantment.neko.armor.nekolife.NekoLife;
import anmao.idoll.nekochantment.enchantment.neko.item.nekolove.NekoLove;
import anmao.idoll.nekochantment.enchantment.neko.item.nekomeow.NekoMeow;
import anmao.idoll.nekochantment.enchantment.neko.armor.nekomirror.NekoMirror;
import anmao.idoll.nekochantment.enchantment.neko.item.nekonight.NekoNight;
import anmao.idoll.nekochantment.enchantment.neko.armor.nekoninja.NekoNinja;
import anmao.idoll.nekochantment.enchantment.neko.armor.nekosoul.NekoSoul;
import anmao.idoll.nekochantment.enchantment.spirit.armor.adaptive.Adaptive;
import anmao.idoll.nekochantment.enchantment.spirit.armor.natural.Natural;
import anmao.idoll.nekochantment.enchantment.spirit.armor.redlotus.RedLotus;
import anmao.idoll.nekochantment.enchantment.spirit.armor.stance.Stance;
import anmao.idoll.nekochantment.enchantment.spirit.armor.warlord.Warlord;
import anmao.idoll.nekochantment.enchantment.spirit.sword.angel.Angel;
import anmao.idoll.nekochantment.enchantment.spirit.sword.cross.Cross;
import anmao.idoll.nekochantment.enchantment.spirit.sword.deathsickle.DeathSickle;
import anmao.idoll.nekochantment.enchantment.spirit.sword.ganjiang.GanJiang;
import anmao.idoll.nekochantment.enchantment.spirit.sword.judgment.Judgment;
import anmao.idoll.nekochantment.enchantment.spirit.sword.mahogany.Mahogany;
import anmao.idoll.nekochantment.enchantment.spirit.sword.moye.MoYe;
import anmao.idoll.nekochantment.enchantment.spirit.sword.zenstick.ZenStick;
import anmao.idoll.nekochantment.enchantment.zero.item.confusion.Confusion;
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
    public static RegistryObject<Enchantment> NEKO_CHOP = Enchantments.register("neko_chop",()->new NekoChop(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> NEKO_LOVE= Enchantments.register("neko_love",()->new NekoLove(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> E_ANGEL = Enchantments.register("e_angel", Angel::new);
    public static RegistryObject<Enchantment> E_CROSS = Enchantments.register("e_cross", Cross::new);
    public static RegistryObject<Enchantment> E_DEATH_SICKLE = Enchantments.register("e_death_sickle", DeathSickle::new);
    public static RegistryObject<Enchantment> E_GAN_JIANG = Enchantments.register("e_gan_jiang", GanJiang::new);
    public static RegistryObject<Enchantment> E_JUDGMENT = Enchantments.register("e_judgment", Judgment::new);
    public static RegistryObject<Enchantment> E_MAHOGANY = Enchantments.register("e_mahogany", Mahogany::new);
    public static RegistryObject<Enchantment> E_MO_YE = Enchantments.register("e_mo_ye", MoYe::new);
    public static RegistryObject<Enchantment> E_Zen_Stick = Enchantments.register("e_zen_stick", ZenStick::new);


    // armor
    public static RegistryObject<Enchantment> NEKO_NINJA = Enchantments.register("neko_ninja",()->new NekoNinja(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, EquipmentSlot.CHEST));
    public static RegistryObject<Enchantment> NEKO_SOUL = Enchantments.register("neko_soul",()->new NekoSoul(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlot.CHEST));
    public static RegistryObject<Enchantment> NEKO_BLESSING = Enchantments.register("neko_blessing",()->new NekoBlessing(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlot.FEET));
    public static RegistryObject<Enchantment> NEKO_MIRROR = Enchantments.register("neko_mirror",()->new NekoMirror(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR,EquipmentSlot.CHEST));
    public static RegistryObject<Enchantment> NEKO_LIFE = Enchantments.register("neko_life",()->new NekoLife(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR,EquipmentSlot.CHEST));
    public static RegistryObject<Enchantment> E_ADAPTIVE = Enchantments.register("e_adaptive", Adaptive::new);
    public static RegistryObject<Enchantment> E_NATURAL = Enchantments.register("e_natural", Natural::new);
    public static RegistryObject<Enchantment> E_REDLOTUS = Enchantments.register("e_red_lotus", RedLotus::new);
    public static RegistryObject<Enchantment> E_STANCE = Enchantments.register("e_stance", Stance::new);
    public static RegistryObject<Enchantment> E_WARLORD = Enchantments.register("e_warlord", Warlord::new);


    //item
    public static RegistryObject<Enchantment> Z_CONFUSION = Enchantments.register("z_confusion", Confusion::new);

    public static void register(IEventBus eventBus){Enchantments.register(eventBus);}
}
