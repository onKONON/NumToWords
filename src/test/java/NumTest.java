import hello.Num;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.Objects;

public class NumTest {

    Num num = new Num();

    private BufferedReader buffReader = null;

    @Before
    public void buffStart() throws Exception {
        buffReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("TestFolder/TestNumber.txt"), "UTF8"));
    }

    @After
    public void buffClose() throws Exception {
        if (buffReader != null) {
            buffReader.close();
        }
        buffReader = null;
    }

    @Test
    public void testConvert_0to19() throws Exception {
        String[] nameNum = new String[]{"ноль", "один", "два", "три", "четыре",
                "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать",
                "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

        System.out.println();
        System.out.println("Junit test: Convert to words numbers 0-19");

        for (int i = 0; i < 20; i++) {
            assertEquals(" Error in the numbers  0-19", nameNum[i],
                    num.NumToString(i));
            System.out.println(i + " = " + nameNum[i]);
        }
    }


    @Test
    public void testConvert_20to999() throws Exception {

        String[] nameNum = new String[]{"сорок", "семьдесят два", "четыреста", "двести два",
                "пятьсот пятьдесят пять", "триста десять", "шестьсот шестьдесят шесть", "девятьсот девяносто девять"};
        int numbers[] = new int[]{40, 72, 400, 202, 555, 310, 666, 999};

        System.out.println();
        System.out.println("Junit test: Convert to words numbers 20-999");

        for (int i = 0; i < 8; i++) {
            assertEquals(" Error in the numbers  20-999", nameNum[i],
                    num.NumToString(numbers[i]));
            System.out.println(numbers[i] + " = " + nameNum[i]);
        }
    }


    @Test
    public void testConvert_BigNumber() throws Exception {

        String[] nameNum = new String[]{"два миллиарда сто сорок семь миллионов четыреста восемьдесят три тысячи шестьсот сорок семь",
                "минус один миллион одиннадцать",
                "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять"};
        int numbers[] = new int[]{Integer.MAX_VALUE, -1000011, 123456789};

        System.out.println();
        System.out.println("Junit test: Convert to words big numbers ");

        for (int i = 0; i < 3; i++) {
            assertEquals(" Error in the big numbers", nameNum[i],
                    num.NumToString(numbers[i]));
            System.out.println(numbers[i] + " = " + nameNum[i]);
        }
    }


    @Test
    public void testConvert_genderForms_1and2() throws Exception {

        String[] nameNum = new String[]{"две тысячи", "одна тысяча", "один миллион", "два миллиона"};
        int numbers[] = new int[]{2000, 1000, 1000000, 2000000};

        System.out.println();
        System.out.println("Junit test: Convert to words number exist units 1/2");

        for (int i = 0; i < 4; i++) {
            assertEquals(" Error in the numbers exist units 1/2", nameNum[i],
                    num.NumToString(numbers[i]));
            System.out.println(numbers[i] + " = " + nameNum[i]);
        }
    }

    /*
    Для этого теста необходимо ввести в файл TestNumber.txt, который находится в корне проекта в папке TestFolder, следующее
    "число"="число прописью".
     */
    @Test
    public void testConvertDataFromFile() throws Exception {
        String tmpLineStr;
        String numbers[];
        System.out.println();
        System.out.println("Junit test: Convert Data From .txt File");
        while ((tmpLineStr = buffReader.readLine()) != null) {
            if (!Objects.equals(tmpLineStr, "")) {
                numbers = tmpLineStr.split("=");
                long myNumbers = new Long(numbers[0]);
                assertEquals("Error in the equals on file",numbers[1],num.NumToString(myNumbers));
                System.out.println(numbers[0] + " = " + num.NumToString(myNumbers));
            }
        }
    }
}
