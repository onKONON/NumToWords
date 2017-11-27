package hello;

/**
 * Класс содержит метод для перевода числа в строку.
 *
 */
public class Num {

    public final int DG_POWER=6;

    /**
     * Значение степеней.
     */
    private final String[][] scale = new String[][]{
            {"0", ""            , ""             ,""              },  // 1
            {"1", "тысяча"     , "тысячи"      ,"тысяч"        },  // 2
            {"0", "миллион"    , "миллиона"    ,"миллионов"    },  // 3
            {"0", "миллиард"   , "миллиарда"   ,"миллиардов"   },  // 4
            {"0", "триллион"   , "триллиона"   ,"триллионов"   },  // 5
            {"0", "квадриллион", "квадриллиона","квадриллионов"},  // 6
    };

    private final String[][] num = new String[][] {
            {""       ,""       , "десять"      , ""            ,""          },
            {"один"  ,"одна"  , "одиннадцать" , "десять"     ,"сто"      },
            {"два"   ,"две"   , "двенадцать"  , "двадцать"   ,"двести"   },
            {"три"   ,"три"   , "тринадцать"  , "тридцать"   ,"триста"   },
            {"четыре","четыре", "четырнадцать", "сорок"      ,"четыреста"},
            {"пять"  ,"пять"  , "пятнадцать"  , "пятьдесят"  ,"пятьсот"  },
            {"шесть" ,"шесть" , "шестнадцать" , "шестьдесят" ,"шестьсот" },
            {"семь"  ,"семь"  , "семнадцать"  , "семьдесят"  ,"семьсот"  },
            {"восемь","восемь", "восемнадцать", "восемьдесят","восемьсот"},
            {"девять","девять", "девятнадцать", "девяносто"  ,"девятьсот"}
    };

    /**
     * Перевод числа из цифровой записи в строковую.
     *
     * @param sum строка чисел, которая будет преобразована в слова.
     * @return число, преобразованное в слова.
     */
    public String NumToString (long sum){
        int i,mny;
        StringBuffer result= new StringBuffer("");
        long divisor; //делитель
        long psum = sum;

        //индексы степеней
        int one  = 1;
        int four = 2;
        int many = 3;

        int sex  = 0;
        int hun  = 4;
        int dec  = 3;
        int dec2 = 2;

        if(sum == 0) return "ноль";

        if(sum <  0){
            result.append("минус ");
            psum = -psum;
        }

        for(i=0,divisor=1; i<DG_POWER; i++){
            divisor *= 1000;
        }

        for(i=DG_POWER-1; i>=0; i--){
            divisor /= 1000;
            mny = (int)(psum / divisor);
            psum %= divisor;
            if(mny==0){
                if(i>0) continue;
                result.append( scale[i][one] + " ");
            } else{
                if(mny>=100){ result.append( num[mny/100][hun] + " "); mny%=100; }
                if(mny>=20 ){ result.append( num[mny/10 ][dec] + " "); mny%=10; }
                if(mny>=10 ){
                    result.append( num[mny-10 ][dec2] + " ");
                }else{
                    if(mny>=1  ) result.append( num[mny][ "0".equals(scale[i][0]) ? 0 : 1 ] + " ");
                }
                switch(mny){
                    case  1: result.append( scale[i][one] + " "); break;
                    case  2:
                    case  3:
                    case  4: result.append( scale[i][four] + " "); break;
                    default: result.append( scale[i][many] + " "); break;
                }
            }
        }
        return result.toString().trim();
    }
}
