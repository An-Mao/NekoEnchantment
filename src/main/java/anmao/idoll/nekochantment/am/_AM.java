package anmao.idoll.nekochantment.am;

import net.minecraft.ChatFormatting;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.Collection;

public class _AM {
    private static final ChatFormatting[] Colors =
            {
            ChatFormatting.BLACK,//0
            ChatFormatting.DARK_BLUE,//1
            ChatFormatting.DARK_GREEN,//2
            ChatFormatting.DARK_AQUA,//3
            ChatFormatting.DARK_RED,//4
            ChatFormatting.DARK_PURPLE,//5
            ChatFormatting.GOLD,//6
            ChatFormatting.GRAY,//7
            ChatFormatting.DARK_GRAY,//8
            ChatFormatting.BLUE,//9
            ChatFormatting.GREEN,//10
            ChatFormatting.AQUA,//11
            ChatFormatting.RED,//12
            ChatFormatting.LIGHT_PURPLE,//13
            ChatFormatting.YELLOW,//14
            ChatFormatting.WHITE//15
    };
    public static int getSysSec(){
        return  (int) (System.currentTimeMillis() / 1000);
    }
    public static double getAdddamage(Collection<AttributeModifier> attlist) {
        double dadd = 0;
        double dbase = 0;
        double dtotal = 1;
        for (AttributeModifier al : attlist) {
            if(al.getOperation() == AttributeModifier.Operation.ADDITION){
                dadd += al.getAmount();
            } else if (al.getOperation() == AttributeModifier.Operation.MULTIPLY_BASE) {
                dbase += al.getAmount();
            } else if (al.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL) {
                dtotal *= 1.0D + al.getAmount();
            }
        }
        return (dadd + dadd * dbase) * dtotal;
    }
    private static float NumP(int k,int b){
        int x = k;
        float y = 0;
        while (x > b){
            y++;
            x = x / b;
        }
        return y / 100.0F;
    }
    private static float NumPLog(int k,int b){
        return (float) (Math.log(k)/Math.log(b));
    }
    public static int log2Floor(int n){
        assert n >= 1;
        int log = 0;
        if(n > 0xffff){
            n >>>= 16;
            log = 16;
        }
        if(n > 0xff){
            n >>>= 8;
            log |= 8;
        }
        if(n > 0xf){
            n >>>= 4;
            log |= 4;
        }
        if(n > 0b11){
            n >>>= 2;
            log |= 2;
        }
        return log + (n >>> 1);
    }
    public static int getRandomNumber(int min ,int max){
        return RandomSource.createNewThreadLocalInstance().nextInt(min,max);
        //Random random = new Random();
        //return random.nextInt(max) % (max - min + 1) + min;
    }
    public static ChatFormatting getColor(int a){
        if (a >=0) {
            if (a < Colors.length) {
                return Colors[a];
            }
            while (a >= Colors.length){
                a = a - Colors.length;
            }
            return Colors[a];
        }
        return Colors[0];
    }
    public static int getLuckP(float luck){
        //2147483647
        if (luck < 2 ){
            return 0;
        }
        return log2Floor((int) luck);
    }
    public static float getLvlP(int lvl){
        //2147483647
        int x = lvl;
        float y = 0;
        while (x > 2){
            y++;
            x = x / 2;
        }
        return y / 100.0F;
    }
}
