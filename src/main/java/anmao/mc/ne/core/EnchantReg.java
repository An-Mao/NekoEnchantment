package anmao.mc.ne.core;

import anmao.mc.ne.NE;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchant.blood.coagulation.Coagulation;
import anmao.mc.ne.enchant.blood.vampirism.Vampirism;
import anmao.mc.ne.enchant.curse.corrode.Corrode;
import anmao.mc.ne.enchant.curse.disease.CurseDisease;
import anmao.mc.ne.enchant.neko.armor.nekoblessing.NekoBlessing;
import anmao.mc.ne.enchant.neko.armor.nekolife.NekoLife;
import anmao.mc.ne.enchant.neko.armor.nekomirror.NekoMirror;
import anmao.mc.ne.enchant.neko.armor.nekoninja.NekoNinja;
import anmao.mc.ne.enchant.neko.armor.nekosoul.NekoSoul;
import anmao.mc.ne.enchant.neko.item.nekoblade.NekoBlade;
import anmao.mc.ne.enchant.neko.item.nekochop.NekoChop;
import anmao.mc.ne.enchant.neko.item.nekoday.NekoDay;
import anmao.mc.ne.enchant.neko.item.nekoemperor.NekoEmperor;
import anmao.mc.ne.enchant.neko.item.nekogod.NekoGod;
import anmao.mc.ne.enchant.neko.item.nekoking.NekoKing;
import anmao.mc.ne.enchant.neko.item.nekolove.NekoLove;
import anmao.mc.ne.enchant.neko.item.nekomeow.NekoMeow;
import anmao.mc.ne.enchant.neko.item.nekonight.NekoNight;
import anmao.mc.ne.enchant.phenomenon.duality.Duality;
import anmao.mc.ne.enchant.phenomenon.theworld.TheWorldEnchant;
import anmao.mc.ne.enchant.spirit.armor.adaptive.Adaptive;
import anmao.mc.ne.enchant.spirit.armor.natural.Natural;
import anmao.mc.ne.enchant.spirit.armor.redlotus.RedLotus;
import anmao.mc.ne.enchant.spirit.armor.stance.Stance;
import anmao.mc.ne.enchant.spirit.armor.warlord.Warlord;
import anmao.mc.ne.enchant.spirit.sword.angel.Angel;
import anmao.mc.ne.enchant.spirit.sword.cross.Cross;
import anmao.mc.ne.enchant.spirit.sword.deathsickle.DeathSickle;
import anmao.mc.ne.enchant.spirit.sword.ganjiang.GanJiang;
import anmao.mc.ne.enchant.spirit.sword.judgment.Judgment;
import anmao.mc.ne.enchant.spirit.sword.mahogany.Mahogany;
import anmao.mc.ne.enchant.spirit.sword.moye.MoYe;
import anmao.mc.ne.enchant.spirit.sword.zenstick.ZenStick;
import anmao.mc.ne.enchant.zero.bow.rain_of_arrows.RainOfArrows;
import anmao.mc.ne.enchant.zero.bow.tori_no_uta.ToriNoUta;
import anmao.mc.ne.enchant.zero.item.alone.Alone;
import anmao.mc.ne.enchant.zero.item.breakdefense.BreakDefense;
import anmao.mc.ne.enchant.zero.item.bright.Bright;
import anmao.mc.ne.enchant.zero.item.confusion.Confusion;
import anmao.mc.ne.enchant.zero.item.deathproclamation.DeathProclamation;
import anmao.mc.ne.enchant.zero.item.fetters.Fetters;
import anmao.mc.ne.enchant.zero.item.indestructible.Indestructible;
import anmao.mc.ne.enchant.zero.item.purify.Purify;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class EnchantReg {

    public static final ResourceLocation KEY =  ResourceLocation.tryBuild(NE.MOD_ID, "enchant");
    public static final DeferredRegister<Enchant> ENCHANT = DeferredRegister.create(KEY, NE.MOD_ID);
    public static final Supplier<IForgeRegistry<Enchant>> REGISTRY = ENCHANT.makeRegistry(RegistryBuilder::new);

    //public static final RegistryObject<EnchantmentCore> BASE = ENCHANT.register("base", BaseSkill::new);

    public static RegistryObject<Enchant> NEKO_BLADE = reg("neko_blade", NekoBlade::new);
    public static RegistryObject<Enchant> NEKO_GOD = reg("neko_god", NekoGod::new);
    public static RegistryObject<Enchant> NEKO_MEOW = reg("neko_meow", NekoMeow::new);
    public static RegistryObject<Enchant> NEKO_KING = reg("neko_king", NekoKing::new);
    public static RegistryObject<Enchant> NEKO_EMPEROR = reg("neko_emperor", NekoEmperor::new);
    public static RegistryObject<Enchant> NEKO_DAY = reg("neko_day", NekoDay::new);
    public static RegistryObject<Enchant> NEKO_NIGHT = reg("neko_night", NekoNight::new);
    public static RegistryObject<Enchant> NEKO_CHOP = reg("neko_chop", NekoChop::new);
    public static RegistryObject<Enchant> NEKO_LOVE= reg("neko_love", NekoLove::new);
    public static RegistryObject<Enchant> E_ANGEL = reg("e_angel", Angel::new);
    public static RegistryObject<Enchant> E_CROSS = reg("e_cross", Cross::new);
    public static RegistryObject<Enchant> E_DEATH_SICKLE = reg("e_death_sickle", DeathSickle::new);
    public static RegistryObject<Enchant> E_GAN_JIANG = reg("e_gan_jiang", GanJiang::new);
    public static RegistryObject<Enchant> E_JUDGMENT = reg("e_judgment", Judgment::new);
    public static RegistryObject<Enchant> E_MAHOGANY = reg("e_mahogany", Mahogany::new);
    public static RegistryObject<Enchant> E_MO_YE = reg("e_mo_ye", MoYe::new);
    public static RegistryObject<Enchant> E_Zen_Stick = reg("e_zen_stick", ZenStick::new);

    // armor
    public static RegistryObject<Enchant> NEKO_NINJA = reg("neko_ninja", NekoNinja::new);
    public static RegistryObject<Enchant> NEKO_SOUL = reg("neko_soul", NekoSoul::new);
    public static RegistryObject<Enchant> NEKO_BLESSING = reg("neko_blessing", NekoBlessing::new);
    public static RegistryObject<Enchant> NEKO_MIRROR = reg("neko_mirror", NekoMirror::new);
    public static RegistryObject<Enchant> NEKO_LIFE = reg("neko_life", NekoLife::new);
    public static RegistryObject<Enchant> E_ADAPTIVE = reg("e_adaptive", Adaptive::new);
    public static RegistryObject<Enchant> E_NATURAL = reg("e_natural", Natural::new);
    public static RegistryObject<Enchant> E_REDLOTUS = reg("e_red_lotus", RedLotus::new);
    public static RegistryObject<Enchant> E_STANCE = reg("e_stance", Stance::new);
    public static RegistryObject<Enchant> E_WARLORD = reg("e_warlord", Warlord::new);


    //item
    public static RegistryObject<Enchant> Z_CONFUSION = reg("z_confusion", Confusion::new);
    public static RegistryObject<Enchant> Z_PURIFY = reg("zi_purify", Purify::new);
    public static RegistryObject<Enchant> Z_BREAK_DEFENSE = reg("zi_break_defense", BreakDefense::new);
    public static RegistryObject<Enchant> Z_BRIGHT = reg("zi_bright", Bright::new);
    public static RegistryObject<Enchant> Z_ALONE = reg("zi_alone", Alone::new);

    public static RegistryObject<Enchant> Z_DP = reg("zi_dp", DeathProclamation::new);
    public static RegistryObject<Enchant> Z_FETTERS = reg("zi_fetters", Fetters::new);
    public static RegistryObject<Enchant> Z_INDESTRUCTIBLE = reg("zi_indestructible", Indestructible::new);
    //public static RegistryObject<Enchant> Z_UNBREAKABLE = reg("zi_unbreakable", Unbreakable::new);
    public static RegistryObject<Enchant> RAIN_OF_ARROWS = reg("rain_of_arrows", RainOfArrows::new);
    public static RegistryObject<Enchant> TORI_NO_UTA = reg("tori_no_uta", ToriNoUta::new);

    public static RegistryObject<Enchant> ChainHarvesting = reg("chain_harvesting", anmao.mc.ne.enchant.zero.tool.ChainHarvesting::new);

    public static RegistryObject<Enchant> B_DRINK_BLOOD = reg("b_vampirism", Vampirism::new);
    public static RegistryObject<Enchant> B_COAGULATION = reg("b_coagulation", Coagulation::new);

    public static RegistryObject<Enchant> CURSE_DISEASE = reg("curse_disease", CurseDisease::new);
    public static RegistryObject<Enchant> CORRODE = reg("corrode", Corrode::new);


    public static RegistryObject<Enchant> DUALITY = reg("duality", Duality::new);
    public static RegistryObject<Enchant> THE_WORLD = reg("the_world", TheWorldEnchant::new);
    //public static RegistryObject<Enchant> MYRIAD_PHENOMENA = reg("myriad_phenomena", MyriadPhenomena::new);





    public static RegistryObject<Enchant> reg(String name , Function<String , Enchant> function){
        if (EnchantmentsConfig.INSTANCE.isEnable(name)) {
            return ENCHANT.register(name, () -> function.apply(name));
        }
        return null;
    }
    public static RegistryObject<Enchant> reg(String name, Supplier<? extends Enchant> sup) {
        if (EnchantmentsConfig.INSTANCE.isEnable(name)) {
            return ENCHANT.register(name, sup);
        }else {
            return null;
        }
    }


    public static void register(IEventBus eventBus){
        ENCHANT.register(eventBus);
    }
    public static Enchant getEnchant(String resourceLocation){
        return getEnchant(ResourceLocation.tryParse(resourceLocation));
    }
    public static Enchant getEnchant(ResourceLocation resourceLocation){
        return REGISTRY.get().getValue(resourceLocation);
    }
    public static ResourceLocation getResourceLocation(Enchant enchant){
        return REGISTRY.get().getKey(enchant);
    }
}
