package anmao.mc.ne.config;

import anmao.mc.amlib.system._File;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;

public class ConfigCore {
    public static final String ConfigDir = _File.getFileFullPathWithRun("config/NekoEnchantment/");
    static {
        _File.checkAndCreateDir(ConfigDir);
    }
    public static void init(){
    }
}
