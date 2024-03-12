package anmao.mc.ne.event;

import anmao.mc.amlib.component.ComponentStyle;
import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.NekoEnchantments;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class EnchantmentEvents {
    private static final int[] REFINE_COLOR = {14, 6};
    private static final int[] KILLS_COLOR = {12, 4};
    private static final int[] SOUL_COLOR = {7, 8};
    private static final int[] BLESSING_COLOR = {13, 5};
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
    private static final boolean duality = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.DUALITY);
    private static final boolean love = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_LOVE);
    private static final boolean king = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_KING);
    private static final boolean emperor = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_EMPEROR);
    private static final boolean soul = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_SOUL);
    //blessing
    private static final boolean blessing = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_BLESSING);
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        @NotNull ItemStack item = event.getItemStack();
        int tmp;
        int indexs = 1;
        int colo = 15;
        Player player = event.getEntity();
        if (player != null && item.getTag() != null) {
            if (duality && item.getEnchantmentLevel(NekoEnchantments.duality) > 0) {
                float a = item.getTag().getFloat("duality");
                String s;
                ChatFormatting cr;
                if (a < 0) {
                    s = TOOLTIPS_DUALITY_B;
                    cr = ChatFormatting.RED;
                } else {
                    s = TOOLTIPS_DUALITY_G;
                    cr = ChatFormatting.GOLD;
                }
                event.getToolTip().add(indexs, Component.translatable(s).append(" : ").append(String.valueOf(a)).withStyle(cr));
                indexs++;
            }
            if (love && item.getEnchantmentLevel(NekoEnchantments.ni_love) > 0) {
                if (item.getTag().hasUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE)) {
                    UUID uuid = item.getOrCreateTag().getUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE);
                    //System.out.println("item:"+uuid +"]player:"+player.getUUID());
                    if (uuid.equals(player.getUUID())) {
                        event.getToolTip().add(indexs, ComponentStyle.Flash(Component.translatable(TOOLTIPS_LOVE[0]).getString(), player.level().getDayTime()));
                    } else {
                        event.getToolTip().add(indexs, Component.literal(Component.translatable(TOOLTIPS_LOVE[1]).getString()).withStyle(_AM.getColor(colo)));
                    }
                    indexs++;
                }
            }
            if (king && item.getEnchantmentLevel(NekoEnchantments.ni_king) > 0) {
                tmp = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_REFINE);
                if (tmp < 200) {
                    if (tmp < 100 && tmp >= 50) {
                        colo = REFINE_COLOR[0];
                    }
                    if (tmp >= 100) {
                        colo = REFINE_COLOR[1];
                    }
                    MutableComponent st = Component.translatable(TOOLTIPS_REFINE).append(" : ").append(String.valueOf(tmp));
                    StringBuilder builder = new StringBuilder();
                    st.getVisualOrderText().accept((index, style, ch) -> {
                        builder.append((char) ch);
                        return true;
                    });
                    String txt = builder.toString();
                    event.getToolTip().add(indexs, Component.literal(txt).withStyle(_AM.getColor(colo)));
                } else {
                    MutableComponent str = Component.translatable(TOOLTIPS_REFINE).append(" : ").append(String.valueOf(tmp));
                    event.getToolTip().add(indexs, ComponentStyle.Flash(str.getString(), player.level().getDayTime()));
                }
                indexs++;


            }
            if (emperor && item.getEnchantmentLevel(NekoEnchantments.ni_emperor) > 0) {
                tmp = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_KILL);
                if (tmp < 1000) {
                    if (tmp < 700 && tmp >= 300) {
                        colo = KILLS_COLOR[0];
                    }
                    if (tmp >= 700) {
                        colo = KILLS_COLOR[1];
                    }
                    event.getToolTip().add(indexs, Component.translatable(TOOLTIPS_KILLS)
                            .append(" : ")
                            .append(String.valueOf(tmp))
                            .withStyle(_AM.getColor(colo)));
                } else {
                    MutableComponent str = Component.translatable(TOOLTIPS_KILLS).append(" : ").append(String.valueOf(tmp));
                    event.getToolTip().add(indexs, ComponentStyle.Flash(str.getString(), player.level().getDayTime()));
                }
                indexs++;

            }
            if (soul && item.getEnchantmentLevel(NekoEnchantments.na_soul) > 0) {
                tmp = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_SOUL);
                if (tmp < 10000) {
                    if (tmp < 6000 && tmp >= 3000) {
                        colo = SOUL_COLOR[0];
                    }
                    if (tmp >= 6000) {
                        colo = SOUL_COLOR[1];
                    }
                    event.getToolTip().add(indexs, Component.translatable(TOOLTIPS_SOULS)
                            .append(" : ")
                            .append(String.valueOf(tmp))
                            .withStyle(_AM.getColor(colo)));
                } else {
                    MutableComponent str = Component.translatable(TOOLTIPS_SOULS).append(" : ").append(String.valueOf(tmp));
                    event.getToolTip().add(indexs, ComponentStyle.Flash(str.getString(), player.level().getDayTime()));
                }
                indexs++;

            }
            if (blessing  && item.getEnchantmentLevel(NekoEnchantments.na_blessing) > 0) {
                tmp = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_BLESSING);
                if (tmp < 1000) {
                    if (tmp < 300 && tmp >= 100) {
                        colo = BLESSING_COLOR[0];
                    }
                    if (tmp >= 300) {
                        colo = BLESSING_COLOR[1];
                    }
                    event.getToolTip().add(indexs, Component.translatable(TOOLTIPS_BLESSING)
                            .append(" : ")
                            .append(String.valueOf(tmp))
                            .withStyle(_AM.getColor(colo)));
                } else {
                    MutableComponent str = Component.translatable(TOOLTIPS_BLESSING).append(" : ").append(String.valueOf(tmp));
                    event.getToolTip().add(indexs, ComponentStyle.Flash(str.getString(), player.level().getDayTime()));
                }

            }
        }
    }
}
