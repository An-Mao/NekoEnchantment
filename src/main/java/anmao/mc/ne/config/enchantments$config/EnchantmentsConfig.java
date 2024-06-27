package anmao.mc.ne.config.enchantments$config;

import anmao.dev.easy_json.JsonConfig;
import anmao.mc.ne.config.ConfigCore;
import anmao.mc.ne.core.Enchant;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class EnchantmentsConfig extends JsonConfig<Map<String, EnchantmentsConfigData>> {
    public static final String file = ConfigCore.ConfigDir +"enchantments.json";
    public static final EnchantmentsConfig INSTANCE = new EnchantmentsConfig();
    public EnchantmentsConfig() {
        super(file, EnchantmentsConfigDefaultData.data, new TypeToken<>() {
        });
    }

    public EnchantmentsConfigData getConfig(RegistryObject<Enchant> enchantment){
        return getDatas().get(enchantment.getId().getPath());
    }
    public EnchantmentsConfigData getConfig(String id){
        return getDatas().get(id);
    }
    public JsonObject getParameters(RegistryObject<Enchant> enchantment){
        return getConfig(enchantment).getParameters();
    }
    public float getValue(RegistryObject<Enchant> enchantment, String key){
        if (enchantment == null){
            return 0;
        }
        return getParameters(enchantment).get(key).getAsFloat();
    }
    public boolean getBoolean(RegistryObject<Enchant> enchantment, String key){
        if (enchantment == null){
            return false;
        }
        return getParameters(enchantment).get(key).getAsBoolean();
    }
    public int getMaxLevel(RegistryObject<Enchant> enchantment){
        return (int) getValue(enchantment,"maxLevel");
    }
    public boolean isEnable(RegistryObject<Enchant> enchantment){
        if (enchantment == null){
            return false;
        }
        return getConfig(enchantment).isEnable();
    }
    public boolean isEnable(String id){
        EnchantmentsConfigData configData = getConfig(id);
        if (configData == null){
            return false;
        }
        return configData.isEnable();
    }
}
