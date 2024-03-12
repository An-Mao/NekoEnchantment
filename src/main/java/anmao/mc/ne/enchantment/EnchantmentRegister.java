package anmao.mc.ne.enchantment;

import anmao.mc.ne.NE;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.blood.coagulation.Coagulation;
import anmao.mc.ne.enchantment.blood.vampirism.Vampirism;
import anmao.mc.ne.enchantment.curse.corrode.Corrode;
import anmao.mc.ne.enchantment.curse.disease.CurseDisease;
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
import anmao.mc.ne.enchantment.phenomenon.duality.Duality;
import anmao.mc.ne.enchantment.phenomenon.myriadphenomena.MyriadPhenomena;
import anmao.mc.ne.enchantment.phenomenon.theworld.TheWorldEnchantment;
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
import anmao.mc.ne.enchantment.zero.bow.rain_of_arrows.RainOfArrows;
import anmao.mc.ne.enchantment.zero.bow.tori_no_uta.ToriNoUta;
import anmao.mc.ne.enchantment.zero.item.alone.Alone;
import anmao.mc.ne.enchantment.zero.item.breakdefense.BreakDefense;
import anmao.mc.ne.enchantment.zero.item.bright.Bright;
import anmao.mc.ne.enchantment.zero.item.confusion.Confusion;
import anmao.mc.ne.enchantment.zero.item.deathproclamation.DeathProclamation;
import anmao.mc.ne.enchantment.zero.item.fetters.Fetters;
import anmao.mc.ne.enchantment.zero.item.indestructible.Indestructible;
import anmao.mc.ne.enchantment.zero.item.purify.Purify;
import anmao.mc.ne.enchantment.zero.item.unbreakable.Unbreakable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class EnchantmentRegister {
    public static final DeferredRegister<Enchantment> Enchantments = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, NE.MOD_ID);



    public static RegistryObject<Enchantment> NEKO_BLADE = reg("neko_blade", NekoBlade::new);
    public static RegistryObject<Enchantment> NEKO_GOD = reg("neko_god", NekoGod::new);
    public static RegistryObject<Enchantment> NEKO_MEOW = reg("neko_meow", NekoMeow::new);
    public static RegistryObject<Enchantment> NEKO_KING = reg("neko_king", NekoKing::new);
    public static RegistryObject<Enchantment> NEKO_EMPEROR = reg("neko_emperor", NekoEmperor::new);
    public static RegistryObject<Enchantment> NEKO_DAY = reg("neko_day", NekoDay::new);
    public static RegistryObject<Enchantment> NEKO_NIGHT = reg("neko_night", NekoNight::new);
    public static RegistryObject<Enchantment> NEKO_CHOP = reg("neko_chop", NekoChop::new);
    public static RegistryObject<Enchantment> NEKO_LOVE= reg("neko_love", NekoLove::new);
    public static RegistryObject<Enchantment> E_ANGEL = reg("e_angel", Angel::new);
    public static RegistryObject<Enchantment> E_CROSS = reg("e_cross", Cross::new);
    public static RegistryObject<Enchantment> E_DEATH_SICKLE = reg("e_death_sickle", DeathSickle::new);
    public static RegistryObject<Enchantment> E_GAN_JIANG = reg("e_gan_jiang", GanJiang::new);
    public static RegistryObject<Enchantment> E_JUDGMENT = reg("e_judgment", Judgment::new);
    public static RegistryObject<Enchantment> E_MAHOGANY = reg("e_mahogany", Mahogany::new);
    public static RegistryObject<Enchantment> E_MO_YE = reg("e_mo_ye", MoYe::new);
    public static RegistryObject<Enchantment> E_Zen_Stick = reg("e_zen_stick", ZenStick::new);

    // armor
    public static RegistryObject<Enchantment> NEKO_NINJA = reg("neko_ninja", NekoNinja::new);
    public static RegistryObject<Enchantment> NEKO_SOUL = reg("neko_soul", NekoSoul::new);
    public static RegistryObject<Enchantment> NEKO_BLESSING = reg("neko_blessing", NekoBlessing::new);
    public static RegistryObject<Enchantment> NEKO_MIRROR = reg("neko_mirror", NekoMirror::new);
    public static RegistryObject<Enchantment> NEKO_LIFE = reg("neko_life", NekoLife::new);
    public static RegistryObject<Enchantment> E_ADAPTIVE = reg("e_adaptive", Adaptive::new);
    public static RegistryObject<Enchantment> E_NATURAL = reg("e_natural", Natural::new);
    public static RegistryObject<Enchantment> E_REDLOTUS = reg("e_red_lotus", RedLotus::new);
    public static RegistryObject<Enchantment> E_STANCE = reg("e_stance", Stance::new);
    public static RegistryObject<Enchantment> E_WARLORD = reg("e_warlord", Warlord::new);


    //item
    public static RegistryObject<Enchantment> Z_CONFUSION = reg("z_confusion", Confusion::new);
    public static RegistryObject<Enchantment> Z_PURIFY = reg("zi_purify", Purify::new);
    public static RegistryObject<Enchantment> Z_BREAK_DEFENSE = reg("zi_break_defense", BreakDefense::new);
    public static RegistryObject<Enchantment> Z_BRIGHT = reg("zi_bright", Bright::new);
    public static RegistryObject<Enchantment> Z_ALONE = reg("zi_alone", Alone::new);

    public static RegistryObject<Enchantment> Z_DP = reg("zi_dp", DeathProclamation::new);
    public static RegistryObject<Enchantment> Z_FETTERS = reg("zi_fetters", Fetters::new);
    public static RegistryObject<Enchantment> Z_INDESTRUCTIBLE = reg("zi_indestructible", Indestructible::new);
    public static RegistryObject<Enchantment> Z_UNBREAKABLE = reg("zi_unbreakable", Unbreakable::new);
    public static RegistryObject<Enchantment> RAIN_OF_ARROWS = reg("rain_of_arrows", RainOfArrows::new);
    public static RegistryObject<Enchantment> TORI_NO_UTA = reg("tori_no_uta", ToriNoUta::new);


    public static RegistryObject<Enchantment> B_DRINK_BLOOD = reg("b_vampirism", Vampirism::new);
    public static RegistryObject<Enchantment> B_COAGULATION = reg("b_coagulation", Coagulation::new);

    public static RegistryObject<Enchantment> CURSE_DISEASE = reg("curse_disease", CurseDisease::new);
    public static RegistryObject<Enchantment> CORRODE = reg("corrode", Corrode::new);


    public static RegistryObject<Enchantment> DUALITY = reg("duality", Duality::new);
    public static RegistryObject<Enchantment> THE_WORLD = reg("the_world", TheWorldEnchantment::new);
    public static RegistryObject<Enchantment> MYRIAD_PHENOMENA = reg("myriad_phenomena", MyriadPhenomena::new);
    public static RegistryObject<Enchantment> reg(String name , Function<String , Enchantment> function){
        if (EnchantmentsConfig.INSTANCE.isEnable(name)) {
            return Enchantments.register(name, () -> function.apply(name));
        }
        return null;
    }
    public static RegistryObject<Enchantment> reg(String name, Supplier<? extends Enchantment> sup) {
        if (EnchantmentsConfig.INSTANCE.isEnable(name)) {
            return Enchantments.register(name, sup);
        }else {
            return null;
        }
    }
    public static void register(IEventBus eventBus){Enchantments.register(eventBus);}
}
