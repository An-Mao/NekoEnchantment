package anmao.mc.ne.enchant;

import anmao.dev.core.color._ColorCDT;
import anmao.mc.amlib.component.ComponentStyle;
import anmao.mc.ne.NE;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.core.Enchants;
import anmao.mc.ne.enchant.neko.armor.nekoblessing.NekoBlessing;
import anmao.mc.ne.enchant.neko.armor.nekosoul.NekoSoul;
import anmao.mc.ne.enchant.neko.item.nekoemperor.NekoEmperor;
import anmao.mc.ne.enchant.neko.item.nekoking.NekoKing;
import anmao.mc.ne.enchant.neko.item.nekolove.NekoLove;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class EnchantEvents {
    private static final String TOOLTIPS_REFINE = "tooltips.ne.refine";
    private static final String TOOLTIPS_KILLS = "tooltips.ne.kills";
    private static final String TOOLTIPS_SOULS = "tooltips.ne.souls";
    private static final String TOOLTIPS_BLESSING = "tooltips.ne.blessing";
    private static final String TOOLTIPS_DUALITY_G = "tooltips.ne.duality.g";
    private static final String TOOLTIPS_DUALITY_B = "tooltips.ne.duality.b";
    private static final String[] TOOLTIPS_LOVE = {
            "tooltips.ne.love_y",
            "tooltips.ne.love_n"
    };
    private static final boolean duality = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.DUALITY);
    private static final boolean love = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_LOVE);
    private static final boolean king = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_KING);
    private static final boolean emperor = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_EMPEROR);
    private static final boolean soul = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_SOUL);
    //blessing
    private static final boolean blessing = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_BLESSING);
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        @NotNull ItemStack item = event.getItemStack();
        int indexs = 1;
        Player player = event.getEntity();
        List<Component> tooltip = event.getToolTip();
        if (player != null) {
            MutableComponent ens = Component.literal("");
            float[] damage = {0};

            EnchantHelper.getEnchants(item).forEach((ench, lvl) -> {
                ens.append(Component.literal("[").withColor(_ColorCDT.black)).append(ench.getFullname(lvl)).append(Component.literal("]").withColor(_ColorCDT.white));
                damage[0] += ench.getDamageBonus(lvl, player, item);
            }) ;
            tooltip.add(indexs,ens);
            indexs++;
            /*
            indexs += Duality(item,tooltip,indexs);
            indexs += Love(player,item,tooltip,indexs);
            indexs += King(player,item,tooltip,indexs);
            indexs += Emperor(player,item,tooltip,indexs);
            indexs += Soul(player,item,tooltip,indexs);
            indexs += Blessing(player,item,tooltip,indexs);

             */
            if (duality) {
                indexs += Duality(item,tooltip,indexs);
            }
            if (love) {
                indexs += Love(player,item,tooltip,indexs);
            }
            if (king) {
                indexs += King(player,item,tooltip,indexs);
            }
            if (emperor) {
                indexs += Emperor(player,item,tooltip,indexs);
            }
            if (soul) {
                indexs += Soul(player,item,tooltip,indexs);
            }
            if (blessing) {
                indexs += Blessing(player,item,tooltip,indexs);
            }
            if (damage[0] > 0) {
                tooltip.add(indexs, Component.literal("+").withColor(_ColorCDT.yellow).append(damage[0] + " ").withColor(_ColorCDT.red).append(Component.translatable("tooltips.ne.extra_attack_damage").withColor(_ColorCDT.blue)));
            }

        }
    }
    public static int Duality(ItemStack itemStack , List<Component> tooltip, int index){
        if (EnchantHelper.hasEnchant(itemStack, Enchants.duality)) {
            CompoundTag dat = EnchantHelper.getEnchantData(itemStack).getTagCopy().getCompound("duality.data");
            float a = dat.getFloat("duality");
            String s;
            ChatFormatting cr;
            if (a < 0) {
                s = TOOLTIPS_DUALITY_B;
                cr = ChatFormatting.RED;
            } else {
                s = TOOLTIPS_DUALITY_G;
                cr = ChatFormatting.GOLD;
            }
            tooltip.add(index, Component.translatable(s).append(" : ").append(String.valueOf(a)).withStyle(cr));
            return 1;
        }
        return 0;
    }
    public static int Love(Player player,ItemStack item , List<Component> tooltip, int index){
        if (EnchantHelper.hasEnchant(item, Enchants.ni_love)) {
            CompoundTag dat = EnchantHelper.getEnchantData(item).getTagCopy().getCompound("love.data");
            if (dat.hasUUID(NekoLove.ENCHANTMENT_KEY_LOVE)) {
                UUID uuid = dat.getUUID(NekoLove.ENCHANTMENT_KEY_LOVE);
                if (uuid.equals(player.getUUID())) {
                    tooltip.add(index, ComponentStyle.Flash(Component.translatable(TOOLTIPS_LOVE[0]).getString(), player.level().getDayTime()));
                } else {
                    tooltip.add(index, Component.translatable(TOOLTIPS_LOVE[1]).withStyle(ChatFormatting.RED));
                }
                return 1;
            }
        }
        return 0;
    }
    public static int King(Player player,ItemStack item , List<Component> tooltip, int index){
        if (EnchantHelper.hasEnchant(item, Enchants.ni_king)) {

            CompoundTag dat = EnchantHelper.getEnchantData(item).getTagCopy().getCompound("king.data");
            int tmp = dat.getInt(NekoKing.ENCHANTMENT_KEY_REFINE);
            if (tmp < 200) {
                ChatFormatting color = ChatFormatting.WHITE;
                if (tmp < 100 && tmp >= 50) {
                    color = ChatFormatting.YELLOW;
                }
                if (tmp >= 100) {
                    color = ChatFormatting.DARK_BLUE;
                }
                tooltip.add(index, Component.translatable(TOOLTIPS_REFINE).append(" : ").append(String.valueOf(tmp)).withStyle(color));
            } else {
                MutableComponent str = Component.translatable(TOOLTIPS_REFINE).append(" : ").append(String.valueOf(tmp));
                tooltip.add(index, ComponentStyle.Flash(str.getString(), player.level().getDayTime()));
            }
            return 1;
        }
        return 0;
    }
    public static int Emperor(Player player,ItemStack item , List<Component> tooltip, int index){
        if (EnchantHelper.hasEnchant(item, Enchants.ni_emperor)) {
            CompoundTag dat = EnchantHelper.getEnchantData(item).getTagCopy().getCompound("emperor.data");
            int tmp = dat.getInt(NekoEmperor.ENCHANTMENT_KEY_KILL);
            if (tmp < 1000) {
                ChatFormatting color = ChatFormatting.WHITE;
                if (tmp < 700 && tmp >= 300) {
                    color = ChatFormatting.RED;
                }
                if (tmp >= 700) {
                    color = ChatFormatting.DARK_RED;
                }
                tooltip.add(index, Component.translatable(TOOLTIPS_KILLS)
                        .append(" : ")
                        .append(String.valueOf(tmp))
                        .withStyle(color));
            } else {
                MutableComponent str = Component.translatable(TOOLTIPS_KILLS).append(" : ").append(String.valueOf(tmp));
                tooltip.add(index, ComponentStyle.Flash(str.getString(), player.level().getDayTime()));
            }
            return 1;
        }
        return 0;
    }
    public static int Soul(Player player,ItemStack item , List<Component> tooltip, int index){
        if (EnchantHelper.hasEnchant(item, Enchants.na_soul)) {
            CompoundTag dat = EnchantHelper.getEnchantData(item).getTagCopy().getCompound("soul.data");
            int tmp = dat.getInt(NekoSoul.ENCHANTMENT_KEY_SOUL);
            if (tmp < 10000) {
                ChatFormatting color = ChatFormatting.WHITE;
                if (tmp < 6000 && tmp >= 3000) {
                    color = ChatFormatting.GRAY;
                }
                if (tmp >= 6000) {
                    color = ChatFormatting.DARK_GRAY;
                }
                tooltip.add(index, Component.translatable(TOOLTIPS_SOULS)
                        .append(" : ")
                        .append(String.valueOf(tmp))
                        .withStyle(color));
            } else {
                MutableComponent str = Component.translatable(TOOLTIPS_SOULS).append(" : ").append(String.valueOf(tmp));
                tooltip.add(index, ComponentStyle.Flash(str.getString(), player.level().getDayTime()));
            }
            return 1;
        }
        return 0;
    }
    public static int Blessing(Player player,ItemStack item , List<Component> tooltip, int index){
        if (EnchantHelper.hasEnchant(item, Enchants.na_blessing)) {
            CompoundTag dat = EnchantHelper.getEnchantData(item).getTagCopy().getCompound("blessing.data");
            int tmp = dat.getInt(NekoBlessing.ENCHANTMENT_KEY_BLESSING);
            if (tmp < 1000) {
                ChatFormatting color = ChatFormatting.WHITE;
                if (tmp < 300 && tmp >= 100) {
                    color = ChatFormatting.LIGHT_PURPLE;
                }
                if (tmp >= 300) {
                    color = ChatFormatting.DARK_PURPLE;
                }
                tooltip.add(index, Component.translatable(TOOLTIPS_BLESSING)
                        .append(" : ")
                        .append(String.valueOf(tmp))
                        .withStyle(color));
            } else {
                MutableComponent str = Component.translatable(TOOLTIPS_BLESSING).append(" : ").append(String.valueOf(tmp));
                tooltip.add(index, ComponentStyle.Flash(str.getString(), player.level().getDayTime()));
            }
            return 1;
        }
        return 0;
    }
}
