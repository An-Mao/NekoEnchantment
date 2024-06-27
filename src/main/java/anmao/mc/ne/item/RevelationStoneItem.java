package anmao.mc.ne.item;

import anmao.mc.ne.core.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class RevelationStoneItem extends Item {
    private static EnchantRandom enchantRandom = null;
    public RevelationStoneItem() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public @NotNull Component getName(ItemStack pStack) {
        CompoundTag enchantData = EnchantHelper.getAllData(pStack);
        if (enchantData.getString("revelation").isEmpty()) {
            return super.getName(pStack);
        }
        return  Component.translatable("item.ne.revelation_stone.show").append(EnchantReg.getEnchant(enchantData.getString("revelation")).getFullname(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        CompoundTag enchantData = EnchantHelper.getAllData(itemstack);
        if (enchantData.getString("revelation").isEmpty()){
            if (enchantRandom == null) {
                enchantRandom = new EnchantRandom(EnchantHelper.getAllEnchants());
            }
            enchantData.putString("revelation", EnchantReg.getResourceLocation(enchantRandom.getRandomItem()).toString());
            itemstack.set(EnchantDataReg.Enchant_Data.get(), new EnchantData(enchantData));
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        CompoundTag enchantData = EnchantHelper.getAllData(pStack);
        String revelation = enchantData.getString("revelation");
        if (!revelation.isEmpty()){
            Enchant enchant = EnchantReg.getEnchant(revelation);
            pTooltipComponents.add(1,Component.literal(" -->").append(Component.translatable(enchant.getDescriptionId()+".desc")));
        }else {
            pTooltipComponents.add(1,Component.translatable("item.ne.revelation_stone.tooltip"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
