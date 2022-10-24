package JAVA_GLk_JC1_29_22.HomeTasks.Task3.OtherProjectClasses;

import java.util.Scanner;

/**
 * Класс Rainbow.
 * Реализован вывод на консоль названия оснвоного цветва по его введеному номеру.
 * Реализован вывод на консоль названия полу-цветва по его введенным номерам двух базовых цветов.
 * Глобальные переемнные в данном класе не используются - так как в заадче
 * не пердусматривалось хранеие и передача введенных данных в другие объкты.
 * Все переменные в данном класе - локальные.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class Rainbow {

    public static final int MODE_BASIC_COLOR = 1; // Номер режима. Режим определения основного цвета.
    public static final int MODE_MIXED_COLOR = 2; // Номер режима. Режим опредеелния полу-цвета (смешанного цвета).

    public Rainbow() { // Конструктор класса Rainbow

    }

    // Начало работы программы. В данном методе так или иначе вызываются все остальные методы.
    public void runDialogUser() {

        int numMode = 0;
        int codeInputColor1 = 0;
        int codeInputColor2 = 0;
        int codeIdentificationColor = 0;
        String nameIdentificationColor = Colors.NAME_BASIC_COLOR_NONE;

        System.out.println("\nРежим №1. Для идентификации названия основного цвета введите цифру - 1");
        System.out.println("Режим №2. Для идентификации названия полу-цвета введите цифру - 2");

        numMode = inputConsoleData("\nВведите-Задайте номер режима: ");

        if ( numMode == MODE_BASIC_COLOR ) {

            codeInputColor1 = inputConsoleData("\nВведите номер основного цвета в диапазоне от 1 .. 7 : ");
            nameIdentificationColor = identifyNameColor( codeInputColor1 );

        } else if ( numMode == MODE_MIXED_COLOR ) {

            codeInputColor1 =  inputConsoleData("\nВведите номер основного цвета №1 в диапазоне от 1 .. 7 : ");
            codeInputColor2 =  inputConsoleData("Введите номер основного цвета №2 в диапазоне от 1 .. 7 : ");

            System.out.printf("\nНазвание основного цвета №1 согласно его №: %d = %s \n",
                                codeInputColor1, identifyNameColor( codeInputColor1 ));
            System.out.printf("Название основного цвета №2 согласно его №: %d = %s \n",
                                codeInputColor2, identifyNameColor( codeInputColor2 ));

            nameIdentificationColor = identifyNameColor( codeInputColor1, codeInputColor2);

        } else {

            System.out.printf("\nВведен-Задан неизвестный №: %d режим работы.\nЗавершение работы программы.\n", numMode);
        }

        if ( (numMode == MODE_BASIC_COLOR) || (numMode == MODE_MIXED_COLOR) ) {

                codeIdentificationColor = calculateCodeIdentificationColor(numMode,codeInputColor1, codeInputColor2);
                printCodeNameIdentificationColor(codeIdentificationColor, nameIdentificationColor);
        }
    }

    // Ввод входных данных из консоли. Метод предусматривает ввод строки-приглашения перед вводом данных.
    private int inputConsoleData(String strWelcomeInput) {

        System.out.print(strWelcomeInput);

        Scanner inputData = new Scanner(System.in);
        return inputData.nextInt();
    }

    // Рассчет номера ввееднного цвета. Актуально для полу-цветов.
    private int calculateCodeIdentificationColor( int numMode, int codeBasicColor1, int codeBasicColor2) {

        int code = 0;
        String strCodeColor1 = Integer.toString(codeBasicColor1);
        String strCodeColor2 = Integer.toString(codeBasicColor2);
        String strResultCodeColor = strCodeColor1 + strCodeColor2;

        if ( numMode == 1 ) {

                code = codeBasicColor1;

        } else if ( numMode == 2 ) {

                code = Integer.parseInt(strResultCodeColor);
        }

        return code;
    }

    // Вывод на консоль результата идентификации. Название цвета и его номер.
    private void printCodeNameIdentificationColor( int codeColor, String colorResult){

        if ( colorResult.contains("-") )  {

                System.out.println("\nНазвание полу-цвета = " + colorResult + " № = " + codeColor);

        } else  {

                System.out.println("\nОсновной цвета. Название = " + colorResult + " № = " + codeColor);
        }
    }

    // Иденитификация-идентифицировать Нозвание цвета по его введенному номеру-коду.
    private String identifyNameColor(int codeBasicColor) {

        String nameBasicColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameBasicColor = Colors.NAME_BASIC_COLOR_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameBasicColor = Colors.NAME_BASIC_COLOR_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameBasicColor = Colors.NAME_BASIC_COLOR_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameBasicColor =  Colors.NAME_BASIC_COLOR_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameBasicColor =  Colors.NAME_BASIC_COLOR_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameBasicColor =  Colors.NAME_BASIC_COLOR_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameBasicColor =  Colors.NAME_BASIC_COLOR_PURPLE;
                break;

            default :

                nameBasicColor = nameBasicColor + "\nОшибка. Ввееднный номер цвета №: " + codeBasicColor + " не входит в диапазон от 1 .. 7 \n";
                break;
        }

        return nameBasicColor;
    }

    // Перегрузка метода. Два входных параметра. Двано номера-кода цвета.
    private String identifyNameColor(int codeBasicColor1, int codeBasicColor2) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor1) {

           case Colors.COD_BASIC_COLOR_RED:

               nameMixColor = identifyNameMixColorRed(codeBasicColor2);
               break;

           case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = identifyNameMixColorOrange(codeBasicColor2);
                break;

           case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = identifyNameMixColorYellow(codeBasicColor2);
                break;

           case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  identifyNameMixColorGreen(codeBasicColor2);
                break;

           case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  identifyNameMixColorBlue(codeBasicColor2);
                break;

           case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  identifyNameMixColorNavyBlue(codeBasicColor2);
                break;

           case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  identifyNameMixColorPurple(codeBasicColor2);
                break;

           default :

               nameMixColor = identifyNameMixColorDefault(codeBasicColor2);
               break;

        }

        return nameMixColor;
    }

    /* Идентификация-идентифицировать название полу-цвета.
       Метод перебирает все комбинации 7-и цветов радуги с Красным цветом.
       Первый введенный базовый цвет - Красный. */
    private String identifyNameMixColorRed(int codeBasicColor) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameMixColor = Colors.NAME_MIX_COLOR_RED_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = Colors.NAME_MIX_COLOR_RED_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = Colors.NAME_MIX_COLOR_RED_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  Colors.NAME_MIX_COLOR_RED_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_RED_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_RED_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  Colors.NAME_MIX_COLOR_RED_PURPLE;
                break;

            default :

                nameMixColor =  Colors.NAME_MIX_COLOR_RED_NONE;
                break;
        }

        return nameMixColor;
    }

    private String identifyNameMixColorOrange(int codeBasicColor) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameMixColor = Colors.NAME_MIX_COLOR_ORANGE_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = Colors.NAME_MIX_COLOR_ORANGE_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = Colors.NAME_MIX_COLOR_ORANGE_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  Colors.NAME_MIX_COLOR_ORANGE_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_ORANGE_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_ORANGE_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  Colors.NAME_MIX_COLOR_ORANGE_PURPLE;
                break;

            default :

                nameMixColor =  Colors.NAME_MIX_COLOR_ORANGE_NONE;
                break;
        }

        return nameMixColor;
    }

    private String identifyNameMixColorYellow(int codeBasicColor) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameMixColor = Colors.NAME_MIX_COLOR_YELLOW_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = Colors.NAME_MIX_COLOR_YELLOW_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = Colors.NAME_MIX_COLOR_YELLOW_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  Colors.NAME_MIX_COLOR_YELLOW_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_YELLOW_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_YELLOW_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  Colors.NAME_MIX_COLOR_YELLOW_PURPLE;
                break;

            default :

                nameMixColor =  Colors.NAME_MIX_COLOR_YELLOW_NONE;
                break;
        }

        return nameMixColor;
    }

    private String identifyNameMixColorGreen(int codeBasicColor) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameMixColor = Colors.NAME_MIX_COLOR_GREEN_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = Colors.NAME_MIX_COLOR_GREEN_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = Colors.NAME_MIX_COLOR_GREEN_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  Colors.NAME_MIX_COLOR_GREEN_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_GREEN_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_GREEN_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  Colors.NAME_MIX_COLOR_GREEN_PURPLE;
                break;

            default :

                nameMixColor =  Colors.NAME_MIX_COLOR_GREEN_NONE;
                break;
        }

        return nameMixColor;
    }

    private String identifyNameMixColorBlue(int codeBasicColor) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameMixColor = Colors.NAME_MIX_COLOR_BLUE_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = Colors.NAME_MIX_COLOR_BLUE_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = Colors.NAME_MIX_COLOR_BLUE_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  Colors.NAME_MIX_COLOR_BLUE_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_BLUE_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_BLUE_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  Colors.NAME_MIX_COLOR_BLUE_PURPLE;
                break;

            default :

                nameMixColor =  Colors.NAME_MIX_COLOR_BLUE_NONE;
                break;
        }

        return nameMixColor;
    }

    private String identifyNameMixColorNavyBlue(int codeBasicColor) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameMixColor = Colors.NAME_MIX_COLOR_NAVYBLUE_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = Colors.NAME_MIX_COLOR_NAVYBLUE_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = Colors.NAME_MIX_COLOR_NAVYBLUE_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  Colors.NAME_MIX_COLOR_NAVYBLUE_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_NAVYBLUE_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_NAVYBLUE_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  Colors.NAME_MIX_COLOR_NAVYBLUE_PURPLE;
                break;

            default :

                nameMixColor =  Colors.NAME_MIX_COLOR_NAVYBLUE_NONE;
                break;
        }

        return nameMixColor;
    }

    /* Идентификация-идентифицировать название полу-цвета.
       Метод перебирает все комбинации 7-и цветов радуги с Фиолетовым цветом.
       Первый введенный базовый цвет - Фиолетовый. */
    private String identifyNameMixColorPurple(int codeBasicColor) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameMixColor = Colors.NAME_MIX_COLOR_PURPLE_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = Colors.NAME_MIX_COLOR_PURPLE_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = Colors.NAME_MIX_COLOR_PURPLE_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  Colors.NAME_MIX_COLOR_PURPLE_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_PURPLE_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_PURPLE_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  Colors.NAME_MIX_COLOR_PURPLE_PURPLE;
                break;

            default :

                nameMixColor =  Colors.NAME_MIX_COLOR_PURPLE_NONE;
                break;
        }

        return nameMixColor;
    }

    /* Идентификация-идентифицировать название полу-цвета.
       Метод перебирает все комбинации 7-и цветов радуги с НЕИЗВЕСТНЫМ цветом.
       Первый введенный базовый цвет - НЕИЗВЕСТНЫЙ. */
    private String identifyNameMixColorDefault(int codeBasicColor) {

        String nameMixColor = Colors.NAME_BASIC_COLOR_NONE;

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                nameMixColor = Colors.NAME_MIX_COLOR_DEFAULT_RED;
                break;

            case Colors.COD_BASIC_COLOR_ORANGE:

                nameMixColor = Colors.NAME_MIX_COLOR_DEFAULT_ORANGE;
                break;

            case Colors.COD_BASIC_COLOR_YELLOW:

                nameMixColor = Colors.NAME_MIX_COLOR_DEFAULT_YELLOW;
                break;

            case Colors.COD_BASIC_COLOR_GREEN:

                nameMixColor =  Colors.NAME_MIX_COLOR_DEFAULT_GREEN;
                break;

            case Colors.COD_BASIC_COLOR_BLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_DEFAULT_BLUE;
                break;

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                nameMixColor =  Colors.NAME_MIX_COLOR_DEFAULT_NAVYBLUE;
                break;

            case Colors.COD_BASIC_COLOR_PURPLE:

                nameMixColor =  Colors.NAME_MIX_COLOR_DEFAULT_PURPLE;
                break;

            default :

                nameMixColor = Colors.NAME_MIX_COLOR_NONE_NONE;
                break;
        }

        return nameMixColor;
    }
}

