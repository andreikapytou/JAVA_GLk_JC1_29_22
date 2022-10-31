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

    private static final int MODE_BASIC_COLOR = 1; // Номер режима. Режим определения основного цвета.
    private static final int MODE_MIXED_COLOR = 2; // Номер режима. Режим опредеелния полу-цвета (смешанного цвета).

    private int numMode;
    private int codeIdentificationColor;
    private String nameIdentificationColor;

    public Rainbow() { // Конструктор класса Rainbow

    }

    // Начало работы программы. В данном методе так или иначе вызываются все остальные методы.
    public int runDialogUser() {

       // int numMode = 0;
        int codeInputColor1 = 0;
        int codeInputColor2 = 0;
      //  int codeIdentificationColor = 0;
    //    String nameIdentificationColor = Colors.NAME_BASIC_COLOR_NONE;

        System.out.println("\nРежим №1. Для идентификации названия основного цвета введите цифру - 1");
        System.out.println("Режим №2. Для идентификации названия полу-цвета введите цифру - 2");

        this.numMode = inputConsoleData("\nВведите-Задайте номер режима: ");

        if ( this.numMode == MODE_BASIC_COLOR ) {

            codeInputColor1 = inputConsoleData("\nВведите номер основного цвета в диапазоне от 1 .. 7 : ");
            this.nameIdentificationColor = identifyNameColor( codeInputColor1 );

        } else if ( this.numMode == MODE_MIXED_COLOR ) {

            codeInputColor1 =  inputConsoleData("\nВведите номер основного цвета №1 в диапазоне от 1 .. 7 : ");
            codeInputColor2 =  inputConsoleData("Введите номер основного цвета №2 в диапазоне от 1 .. 7 : ");

            System.out.printf("\nНазвание основного цвета №1 согласно его №: %d = %s \n",
                                codeInputColor1, identifyNameColor( codeInputColor1 ));
            System.out.printf("Название основного цвета №2 согласно его №: %d = %s \n",
                                codeInputColor2, identifyNameColor( codeInputColor2 ));

            this.nameIdentificationColor = identifyNameColor( codeInputColor1, codeInputColor2);

        } else {

            System.out.printf("\nВведен-Задан неизвестный №: %d режим работы.\nЗавершение работы программы.\n", numMode);

            return -1;
        }

        this.codeIdentificationColor = calculateCodeIdentificationColor(numMode,codeInputColor1, codeInputColor2);
        printCodeNameIdentificationColor(this.codeIdentificationColor, this.nameIdentificationColor);

        return 0;
    }

    private int inputMode(String str) {
        return inputConsoleData("\nВведите-Задайте номер режима: ");
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

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:
                return Colors.NAME_BASIC_COLOR_RED;
            case Colors.COD_BASIC_COLOR_ORANGE:
                return Colors.NAME_BASIC_COLOR_ORANGE;
            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_BASIC_COLOR_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_BASIC_COLOR_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_BASIC_COLOR_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_BASIC_COLOR_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_BASIC_COLOR_PURPLE;
                

            default :

                return Colors.NAME_BASIC_COLOR_NONE + "\n Ошибка. Ввееднный номер цвета №: " + codeBasicColor + " не входит в диапазон от 1 .. 7 \n";
                
        }
    }

    // Перегрузка метода. Два входных параметра. Двано номера-кода цвета.
    private String identifyNameColor(int codeBasicColor1, int codeBasicColor2) {
        

        switch (codeBasicColor1) {

           case Colors.COD_BASIC_COLOR_RED:

               return identifyNameMixColorRed(codeBasicColor2);
               

           case Colors.COD_BASIC_COLOR_ORANGE:

                return identifyNameMixColorOrange(codeBasicColor2);
                

           case Colors.COD_BASIC_COLOR_YELLOW:

                return identifyNameMixColorYellow(codeBasicColor2);
                

           case Colors.COD_BASIC_COLOR_GREEN:

                return  identifyNameMixColorGreen(codeBasicColor2);
                

           case Colors.COD_BASIC_COLOR_BLUE:

                return  identifyNameMixColorBlue(codeBasicColor2);
                

           case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  identifyNameMixColorNavyBlue(codeBasicColor2);
                

           case Colors.COD_BASIC_COLOR_PURPLE:

                return  identifyNameMixColorPurple(codeBasicColor2);
                

           default :

               return identifyNameMixColorDefault(codeBasicColor2);
               

        }
    }

    /* Идентификация-идентифицировать название полу-цвета.
       Метод перебирает все комбинации 7-и цветов радуги с Красным цветом.
       Первый введенный базовый цвет - Красный. */
    private String identifyNameMixColorRed(int codeBasicColor) {

        

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                return Colors.NAME_MIX_COLOR_RED_RED;
                

            case Colors.COD_BASIC_COLOR_ORANGE:

                return Colors.NAME_MIX_COLOR_RED_ORANGE;
                

            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_MIX_COLOR_RED_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_MIX_COLOR_RED_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_MIX_COLOR_RED_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_MIX_COLOR_RED_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_MIX_COLOR_RED_PURPLE;
                

            default :

                return  Colors.NAME_MIX_COLOR_RED_NONE;
                
        }
    }

    private String identifyNameMixColorOrange(int codeBasicColor) {

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                return Colors.NAME_MIX_COLOR_ORANGE_RED;

            case Colors.COD_BASIC_COLOR_ORANGE:

                return Colors.NAME_MIX_COLOR_ORANGE_ORANGE;

            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_MIX_COLOR_ORANGE_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_MIX_COLOR_ORANGE_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_MIX_COLOR_ORANGE_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_MIX_COLOR_ORANGE_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_MIX_COLOR_ORANGE_PURPLE;
                

            default :

                return  Colors.NAME_MIX_COLOR_ORANGE_NONE;
                
        }

        
    }

    private String identifyNameMixColorYellow(int codeBasicColor) {

        

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                return Colors.NAME_MIX_COLOR_YELLOW_RED;
                

            case Colors.COD_BASIC_COLOR_ORANGE:

                return Colors.NAME_MIX_COLOR_YELLOW_ORANGE;
                

            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_MIX_COLOR_YELLOW_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_MIX_COLOR_YELLOW_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_MIX_COLOR_YELLOW_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_MIX_COLOR_YELLOW_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_MIX_COLOR_YELLOW_PURPLE;
                

            default :

                return  Colors.NAME_MIX_COLOR_YELLOW_NONE;
                
        }

        
    }

    private String identifyNameMixColorGreen(int codeBasicColor) {


        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                return Colors.NAME_MIX_COLOR_GREEN_RED;
                

            case Colors.COD_BASIC_COLOR_ORANGE:

                return Colors.NAME_MIX_COLOR_GREEN_ORANGE;
                

            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_MIX_COLOR_GREEN_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_MIX_COLOR_GREEN_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_MIX_COLOR_GREEN_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_MIX_COLOR_GREEN_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_MIX_COLOR_GREEN_PURPLE;
                

            default :

                return  Colors.NAME_MIX_COLOR_GREEN_NONE;
                
        }

        
    }

    private String identifyNameMixColorBlue(int codeBasicColor) {

        

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                return Colors.NAME_MIX_COLOR_BLUE_RED;
                

            case Colors.COD_BASIC_COLOR_ORANGE:

                return Colors.NAME_MIX_COLOR_BLUE_ORANGE;
                

            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_MIX_COLOR_BLUE_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_MIX_COLOR_BLUE_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_MIX_COLOR_BLUE_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_MIX_COLOR_BLUE_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_MIX_COLOR_BLUE_PURPLE;
                

            default :

                return  Colors.NAME_MIX_COLOR_BLUE_NONE;
                
        }

        
    }

    private String identifyNameMixColorNavyBlue(int codeBasicColor) {

        

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                return Colors.NAME_MIX_COLOR_NAVYBLUE_RED;
                

            case Colors.COD_BASIC_COLOR_ORANGE:

                return Colors.NAME_MIX_COLOR_NAVYBLUE_ORANGE;
                

            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_MIX_COLOR_NAVYBLUE_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_MIX_COLOR_NAVYBLUE_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_MIX_COLOR_NAVYBLUE_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_MIX_COLOR_NAVYBLUE_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_MIX_COLOR_NAVYBLUE_PURPLE;
                

            default :

                return  Colors.NAME_MIX_COLOR_NAVYBLUE_NONE;
                
        }

        
    }

    /* Идентификация-идентифицировать название полу-цвета.
       Метод перебирает все комбинации 7-и цветов радуги с Фиолетовым цветом.
       Первый введенный базовый цвет - Фиолетовый. */
    private String identifyNameMixColorPurple(int codeBasicColor) {

        

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                return Colors.NAME_MIX_COLOR_PURPLE_RED;
                

            case Colors.COD_BASIC_COLOR_ORANGE:

                return Colors.NAME_MIX_COLOR_PURPLE_ORANGE;
                

            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_MIX_COLOR_PURPLE_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_MIX_COLOR_PURPLE_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_MIX_COLOR_PURPLE_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_MIX_COLOR_PURPLE_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_MIX_COLOR_PURPLE_PURPLE;
                

            default :

                return  Colors.NAME_MIX_COLOR_PURPLE_NONE;
                
        }

        
    }

    /* Идентификация-идентифицировать название полу-цвета.
       Метод перебирает все комбинации 7-и цветов радуги с НЕИЗВЕСТНЫМ цветом.
       Первый введенный базовый цвет - НЕИЗВЕСТНЫЙ. */
    private String identifyNameMixColorDefault(int codeBasicColor) {

        

        switch (codeBasicColor) {

            case Colors.COD_BASIC_COLOR_RED:

                return Colors.NAME_MIX_COLOR_DEFAULT_RED;
                

            case Colors.COD_BASIC_COLOR_ORANGE:

                return Colors.NAME_MIX_COLOR_DEFAULT_ORANGE;
                

            case Colors.COD_BASIC_COLOR_YELLOW:

                return Colors.NAME_MIX_COLOR_DEFAULT_YELLOW;
                

            case Colors.COD_BASIC_COLOR_GREEN:

                return  Colors.NAME_MIX_COLOR_DEFAULT_GREEN;
                

            case Colors.COD_BASIC_COLOR_BLUE:

                return  Colors.NAME_MIX_COLOR_DEFAULT_BLUE;
                

            case Colors.COD_BASIC_COLOR_NAVYBLUE:

                return  Colors.NAME_MIX_COLOR_DEFAULT_NAVYBLUE;
                

            case Colors.COD_BASIC_COLOR_PURPLE:

                return  Colors.NAME_MIX_COLOR_DEFAULT_PURPLE;
                

            default :

                return Colors.NAME_MIX_COLOR_NONE_NONE;
                
        }

        
    }
}

