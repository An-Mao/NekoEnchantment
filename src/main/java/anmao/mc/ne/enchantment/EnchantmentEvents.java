package anmao.mc.ne.enchantment;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM;
import anmao.mc.ne.am._AM_Color;
import anmao.mc.ne.am._AM_Constant;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class EnchantmentEvents {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class FEE{
        private static final int[] REFINE_COLOR = {14,6};
        private static final int[] KILLS_COLOR = {12,4};
        private static final int[] SOUL_COLOR = {7,8};
        private static final int[] BLESSING_COLOR = {13,5};
        private static final String TOOLTIPS_REFINE = "tooltips.nekoenchantment.refine";
        private static final String TOOLTIPS_KILLS = "tooltips.nekoenchantment.kills";
        private static final String TOOLTIPS_SOULS = "tooltips.nekoenchantment.souls";
        private static final String TOOLTIPS_BLESSING = "tooltips.nekoenchantment.blessing";
        private static final String[] TOOLTIPS_LOVE = {
                "tooltips.nekoenchantment.lovey",
                "tooltips.nekoenchantment.loven"
        };
        @SubscribeEvent
        public static void onTooltip(ItemTooltipEvent event) {
            @NotNull ItemStack item = event.getItemStack();
            int tmp;
            int indexs = 1;
            int colo = 15;
            Player player = event.getEntity();
            if (player != null && item.getTag() != null) {
                if (item.getEnchantmentLevel(N_E_S.ni_love) > 0) {
                    if (item.getTag().hasUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE)) {
                        UUID uuid = item.getOrCreateTag().getUUID(_AM_Constant.ENCHANTMENT_KEY_LOVE);
                        System.out.println("item:"+uuid +"]player:"+player.getUUID());
                        if (uuid.equals(player.getUUID())) {
                            event.getToolTip().add(indexs, _AM_Color.RainbowTextColor(Component.translatable(TOOLTIPS_LOVE[0]).getString(), player.level().getDayTime()));
                        }else {
                            event.getToolTip().add(indexs, Component.literal(Component.translatable(TOOLTIPS_LOVE[1]).getString()).withStyle(_AM.getColor(colo)));
                        }
                        indexs++;
                    }
                }
                if (item.getEnchantmentLevel(N_E_S.ni_king) > 0) {
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
                            event.getToolTip().add(indexs, _AM_Color.RainbowTextColor(str.getString(), player.level().getDayTime()));
                        }
                        indexs++;


                }
                if (item.getEnchantmentLevel(N_E_S.ni_emperor) > 0) {
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
                            event.getToolTip().add(indexs, _AM_Color.RainbowTextColor(str.getString(), player.level().getDayTime()));
                        }
                        indexs++;

                }
                if (item.getEnchantmentLevel(N_E_S.na_soul) > 0) {
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
                            event.getToolTip().add(indexs, _AM_Color.RainbowTextColor(str.getString(), player.level().getDayTime()));
                        }
                        indexs++;

                }
                if (item.getEnchantmentLevel(N_E_S.na_blessing) > 0) {
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
                            event.getToolTip().add(indexs, _AM_Color.RainbowTextColor(str.getString(), player.level().getDayTime()));
                        }

                }
            }
        }
    }


}
