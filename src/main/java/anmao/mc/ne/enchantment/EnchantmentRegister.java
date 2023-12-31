package anmao.mc.ne.enchantment;

import anmao.mc.ne.NE;
import anmao.mc.ne.enchantment.blood.coagulation.Coagulation;
import anmao.mc.ne.enchantment.blood.vampirism.Vampirism;
import anmao.mc.ne.enchantment.curse.corrode.Corrode;
import anmao.mc.ne.enchantment.curse.disease.CurseDisease;
import anmao.mc.ne.enchantment.phenomenon.duality.Duality;
import anmao.mc.ne.enchantment.phenomenon.myriadphenomena.MyriadPhenomena;
import anmao.mc.ne.enchantment.neko.armor.nekoblessing.NekoBlessing;
import anmao.mc.ne.enchantment.neko.armor.nekolife.NekoLife;
import anmao.mc.ne.enchantment.neko.armor.nekomirror.NekoMirror;
import anmao.mc.ne.enchantment.neko.armor.nekoninja.NekoNinja;
import anmao.mc.ne.enchantment.neko.armor.nekosoul.NekoSoul;
import anmao.mc.ne.enchantment.neko.item.nekoblade.NekoBlade;
import anmao.mc.ne.enchantment.neko.item.nekochop.NekoChop;
import anmao.mc.ne.enchantment.neko.item.nekoday.NekoDay;
import anmao.mc.ne.enchantment.neko.item.nekoemperor.NekoEmperor;
import anmao.mc.ne.enchantment.neko.item.nekogod.NekoGod;
import anmao.mc.ne.enchantment.neko.item.nekoking.NekoKing;
import anmao.mc.ne.enchantment.neko.item.nekolove.NekoLove;
import anmao.mc.ne.enchantment.neko.item.nekomeow.NekoMeow;
import anmao.mc.ne.enchantment.neko.item.nekonight.NekoNight;
import anmao.mc.ne.enchantment.spirit.armor.adaptive.Adaptive;
import anmao.mc.ne.enchantment.spirit.armor.natural.Natural;
import anmao.mc.ne.enchantment.spirit.armor.redlotus.RedLotus;
import anmao.mc.ne.enchantment.spirit.armor.stance.Stance;
import anmao.mc.ne.enchantment.spirit.armor.warlord.Warlord;
import anmao.mc.ne.enchantment.spirit.sword.angel.Angel;
import anmao.mc.ne.enchantment.spirit.sword.cross.Cross;
import anmao.mc.ne.enchantment.spirit.sword.deathsickle.DeathSickle;
import anmao.mc.ne.enchantment.spirit.sword.ganjiang.GanJiang;
import anmao.mc.ne.enchantment.spirit.sword.judgment.Judgment;
import anmao.mc.ne.enchantment.spirit.sword.mahogany.Mahogany;
import anmao.mc.ne.enchantment.spirit.sword.moye.MoYe;
import anmao.mc.ne.enchantment.spirit.sword.zenstick.ZenStick;
import anmao.mc.ne.enchantment.zero.item.alone.Alone;
import anmao.mc.ne.enchantment.zero.item.breakdefense.BreakDefense;
import anmao.mc.ne.enchantment.zero.item.bright.Bright;
import anmao.mc.ne.enchantment.zero.item.confusion.Confusion;
import anmao.mc.ne.enchantment.zero.item.deathproclamation.DeathProclamation;
import anmao.mc.ne.enchantment.zero.item.fetters.Fetters;
import anmao.mc.ne.enchantment.zero.item.indestructible.Indestructible;
import anmao.mc.ne.enchantment.zero.item.purify.Purify;
import anmao.mc.ne.enchantment.zero.item.unbreakable.Unbreakable;
import anmao.mc.ne.enchantment.phenomenon.theworld.TheWorld;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentRegister {
    public static final DeferredRegister<Enchantment> Enchantments = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, NE.MOD_ID);
    public static RegistryObject<Enchantment> NEKO_BLADE = Enchantments.register("neko_blade", NekoBlade::new);
    public static RegistryObject<Enchantment> NEKO_GOD = Enchantments.register("neko_god", NekoGod::new);
    public static RegistryObject<Enchantment> NEKO_MEOW = Enchantments.register("neko_meow", NekoMeow::new);
    public static RegistryObject<Enchantment> NEKO_KING = Enchantments.register("neko_king", NekoKing::new);
    public static RegistryObject<Enchantment> NEKO_EMPEROR = Enchantments.register("neko_emperor", NekoEmperor::new);
    public static RegistryObject<Enchantment> NEKO_DAY = Enchantments.register("neko_day", NekoDay::new);
    public static RegistryObject<Enchantment> NEKO_NIGHT = Enchantments.register("neko_night", NekoNight::new);
    public static RegistryObject<Enchantment> NEKO_CHOP = Enchantments.register("neko_chop", NekoChop::new);
    public static RegistryObject<Enchantment> NEKO_LOVE= Enchantments.register("neko_love", NekoLove::new);
    public static RegistryObject<Enchantment> E_ANGEL = Enchantments.register("e_angel", Angel::new);
    public static RegistryObject<Enchantment> E_CROSS = Enchantments.register("e_cross", Cross::new);
    public static RegistryObject<Enchantment> E_DEATH_SICKLE = Enchantments.register("e_death_sickle", DeathSickle::new);
    public static RegistryObject<Enchantment> E_GAN_JIANG = Enchantments.register("e_gan_jiang", GanJiang::new);
    public static RegistryObject<Enchantment> E_JUDGMENT = Enchantments.register("e_judgment", Judgment::new);
    public static RegistryObject<Enchantment> E_MAHOGANY = Enchantments.register("e_mahogany", Mahogany::new);
    public static RegistryObject<Enchantment> E_MO_YE = Enchantments.register("e_mo_ye", MoYe::new);
    public static RegistryObject<Enchantment> E_Zen_Stick = Enchantments.register("e_zen_stick", ZenStick::new);


    // armor
    public static RegistryObject<Enchantment> NEKO_NINJA =
            Enchantments.register("neko_ninja", NekoNinja::new);
    public static RegistryObject<Enchantment> NEKO_SOUL =
            Enchantments.register("neko_soul", NekoSoul::new);
    public static RegistryObject<Enchantment> NEKO_BLESSING =
            Enchantments.register("neko_blessing", NekoBlessing::new);
    public static RegistryObject<Enchantment> NEKO_MIRROR =
            Enchantments.register("neko_mirror", NekoMirror::new);
    public static RegistryObject<Enchantment> NEKO_LIFE =
            Enchantments.register("neko_life", NekoLife::new);
    public static RegistryObject<Enchantment> E_ADAPTIVE =
            Enchantments.register("e_adaptive", Adaptive::new);
    public static RegistryObject<Enchantment> E_NATURAL =
            Enchantments.register("e_natural", Natural::new);
    public static RegistryObject<Enchantment> E_REDLOTUS =
            Enchantments.register("e_red_lotus", RedLotus::new);
    public static RegistryObject<Enchantment> E_STANCE =
            Enchantments.register("e_stance", Stance::new);
    public static RegistryObject<Enchantment> E_WARLORD =
            Enchantments.register("e_warlord", Warlord::new);


    //item
    public static RegistryObject<Enchantment> Z_CONFUSION = Enchantments.register("z_confusion", Confusion::new);
    public static RegistryObject<Enchantment> Z_PURIFY = Enchantments.register("zi_purify", Purify::new);
    public static RegistryObject<Enchantment> Z_BREAK_DEFENSE = Enchantments.register("zi_break_defense", BreakDefense::new);
    public static RegistryObject<Enchantment> Z_BRIGHT = Enchantments.register("zi_bright", Bright::new);
    public static RegistryObject<Enchantment> Z_ALONE = Enchantments.register("zi_alone", Alone::new);

    public static RegistryObject<Enchantment> Z_DP = Enchantments.register("zi_dp", DeathProclamation::new);
    public static RegistryObject<Enchantment> Z_FETTERS = Enchantments.register("zi_fetters", Fetters::new);
    public static RegistryObject<Enchantment> Z_INDESTRUCTIBLE = Enchantments.register("zi_indestructible", Indestructible::new);
    public static RegistryObject<Enchantment> Z_UNBREAKABLE = Enchantments.register("zi_unbreakable", Unbreakable::new);


    public static RegistryObject<Enchantment> B_DRINK_BLOOD = Enchantments.register("b_vampirism", Vampirism::new);
    public static RegistryObject<Enchantment> B_COAGULATION = Enchantments.register("b_coagulation", Coagulation::new);

    public static RegistryObject<Enchantment> CURSE_DISEASE = Enchantments.register("curse_disease", CurseDisease::new);
    public static RegistryObject<Enchantment> CORRODE = Enchantments.register("corrode", Corrode::new);


    public static RegistryObject<Enchantment> DUALITY = Enchantments.register("duality", Duality::new);
    public static RegistryObject<Enchantment> THE_WORLD = Enchantments.register("the_world", TheWorld::new);
    public static RegistryObject<Enchantment> MYRIAD_PHENOMENA = Enchantments.register("myriad_phenomena", MyriadPhenomena::new);
    public static void register(IEventBus eventBus){Enchantments.register(eventBus);}
}
