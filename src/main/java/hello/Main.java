package hello;

import java.util.Scanner;

/**
 * Created by onKONON
 *
 * @author Artyom Kononovich
 * @version 1.0
 */

/*
    Перевод числа в цифровой записи в строковую. Например 134345 будет "сто
тридцать четыре тысячи триста сорок пять". * Учесть склонения - разница
в окончаниях (к примеру, две и два).
    Алгоритм должен работать для сколько угодно большого числа, соответственно,
значения степеней - миллион, тысяча, миллиад и т.д. - должны браться их
справочника, к примеру, текстового файла.
    Обязательно создать Data Driven Test (я, как пользователь, должен иметь
возможность ввести множество наборов 1.число 2.правильный эталонный результат,
 тест самостоятельно проверяет все наборы и говорит, что неверное), который
 доказывает, что Ваш алгоритм работает правильно. Использовать JUnit.
    По возможности, применить ООП.
*/

public class Main {

    public static void main(String[] args) {
        Num num = new Num();
        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter some number: ");

                long input = in.nextLong();
                System.out.println(num.NumToString(input));
            }
        }catch (Exception e){
            System.out.println(e + " - недопустимо большое число");
        }
    }
}
