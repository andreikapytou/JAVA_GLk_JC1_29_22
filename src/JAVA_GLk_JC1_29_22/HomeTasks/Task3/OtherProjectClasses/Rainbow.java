package JAVA_GLk_JC1_29_22.HomeTasks.Task3.OtherProjectClasses;

import java.util.Scanner;

/**
 * Класс Rainbow.
 * В данном класе создны глобальные переменные всех типов(примитивы и обертки).
 * И для каждой глобальной переменной реализованы методы - геттеры и сеттеры.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class Rainbow {

    public static final int MODE_BASIC_COLOR = 1; // Номер режима. Режим определения основного цвета.
    public static final int MODE_MIXED_COLOR = 2; // Номер режима. Режим опредеелния полу-цвета (смешанного цвета).

    public Rainbow() { // Конструктор класса Rainbow

    }

    public void runDialogUser() {

        int numMode = 0;
        int codeColor1 = 0;
        int codeColor2 = 0;
        String resultColor = Colors.NAME_BASIC_COLOR_NONE;

        System.out.println("\nРежим №1. Для идентификации названия основного цвета введите цифру - 1");
        System.out.println("Режим №2. Для идентификации названия полу-цвета введите цифру - 2");

        numMode = inputConsoleData("\nВведите-Задайте номер режима: ");

        if ( numMode == MODE_BASIC_COLOR ) {

            resultColor = identifyNameColor( inputConsoleData("\nВведите номер основного цвета в диапазоне от 1 .. 7 : ") );

        } else if ( numMode == MODE_MIXED_COLOR ) {

            codeColor1 =  inputConsoleData("\nВведите номер основного цвета №1 в диапазоне от 1 .. 7 : ");
            codeColor2 =  inputConsoleData("Введите номер основного цвета №2 в диапазоне от 1 .. 7 : ");

            System.out.printf("\nНазвание основного цвета №1 согласно его №: %d = %s \n",
                                codeColor1, identifyNameColor( codeColor1 ));
            System.out.printf("Название основного цвета №2 согласно его №: %d = %s \n",
                                codeColor2, identifyNameColor( codeColor2 ));

            resultColor = identifyNameColor( codeColor1, codeColor2);

        } else {

            System.out.printf("\nВведен-Задан неизвестный №: %d режим работы.\nЗавершение работы программы.\n", numMode);
        }

        printResultIdentificationColor(numMode, resultColor);
    }


    private int inputConsoleData(String strWelcomeInput) {

        System.out.print(strWelcomeInput);

        Scanner inputData = new Scanner(System.in);
        return inputData.nextInt();
    }

    private void printResultIdentificationColor(int numMode, String colorResult){

        if ( numMode == MODE_BASIC_COLOR )  {

                System.out.println("\nНазвание основного цвета = " + colorResult);

        } else if ( numMode == MODE_MIXED_COLOR ) {

            System.out.println("\nНазвание полу-цвета = " + colorResult);
        }
    }

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

    // Перегрузка метода.
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

