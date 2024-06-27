package anmao.mc.ne.config;

import anmao.mc.amlib.system._File;

public class ConfigCore {
    public static final String ConfigDir = _File.getFileFullPathWithRun("config/NekoEnchantment/");
    static {
        _File.checkAndCreateDir(ConfigDir);
    }
    public static void init(){
    }
}
