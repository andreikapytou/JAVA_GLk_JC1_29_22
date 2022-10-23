package JAVA_GLk_JC1_29_22.HomeTasks.Task3.OtherProjectClasses;


/**
 * Класс Color.
 * В данном класе создны константы цветов радуги.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class Colors {

    // Чичловой Номер-Код базового цвета.
    public static final int COD_BASIC_COLOR_RED      = 1; // Красный.
    public static final int COD_BASIC_COLOR_ORANGE   = 2; // Оранжевый.
    public static final int COD_BASIC_COLOR_YELLOW   = 3; // Желтый.
    public static final int COD_BASIC_COLOR_GREEN    = 4; // Зеленый.
    public static final int COD_BASIC_COLOR_BLUE     = 5; // Голубой.
    public static final int COD_BASIC_COLOR_NAVYBLUE = 6; // Синий.
    public static final int COD_BASIC_COLOR_PURPLE   = 7; // Фиолетовый.

    // Название базового цвета.
    public static final String NAME_BASIC_COLOR_RED      = "КРАСНЫЙ";   // Красный.
    public static final String NAME_BASIC_COLOR_ORANGE   = "ОРАНЖЕВЫЙ"; // Оранжевый.
    public static final String NAME_BASIC_COLOR_YELLOW   = "ЖЕЛТЫЙ";    // Желтый.
    public static final String NAME_BASIC_COLOR_GREEN    = "ЗЕЛЕНЫЙ";   // Зеленый.
    public static final String NAME_BASIC_COLOR_BLUE     = "ГОЛУБОЙ";   // Голубой.
    public static final String NAME_BASIC_COLOR_NAVYBLUE = "СИНИЙ";     // Синий.
    public static final String NAME_BASIC_COLOR_PURPLE   = "ФИОЛЕТОВЫЙ"; // Фиолетовый.
    public static final String NAME_BASIC_COLOR_NONE     = "НЕИЗВЕСТНЫЙ_ЦВЕТ"; // Неизвестный цвет.
    public static final String NAME_MIX_COLOR_NONE_NONE  = NAME_BASIC_COLOR_NONE + "-" + NAME_BASIC_COLOR_NONE; // Неизвестный полу-цвет.

    // Название полу-цветов.
    // Смешение различных цветов радуги с КРАСНЫМ цветом.
    public static final String NAME_MIX_COLOR_RED_RED      = "КРАСНO-"+NAME_BASIC_COLOR_RED;
    public static final String NAME_MIX_COLOR_RED_ORANGE   = "КРАСНO-"+NAME_BASIC_COLOR_ORANGE;
    public static final String NAME_MIX_COLOR_RED_YELLOW   = "КРАСНO-"+NAME_BASIC_COLOR_YELLOW;
    public static final String NAME_MIX_COLOR_RED_GREEN    = "КРАСНO-"+NAME_BASIC_COLOR_GREEN;
    public static final String NAME_MIX_COLOR_RED_BLUE     = "КРАСНO-"+NAME_BASIC_COLOR_BLUE;
    public static final String NAME_MIX_COLOR_RED_NAVYBLUE = "КРАСНO-"+NAME_BASIC_COLOR_NAVYBLUE;
    public static final String NAME_MIX_COLOR_RED_PURPLE   = "КРАСНO-"+NAME_BASIC_COLOR_PURPLE;
    public static final String NAME_MIX_COLOR_RED_NONE     = "КРАСНO-"+ NAME_BASIC_COLOR_NONE;

    // Смешение цветов радуги с ОРАНЖЕВЫМ цветом.
    public static final String NAME_MIX_COLOR_ORANGE_RED      = "ОРАНЖЕВО-"+NAME_BASIC_COLOR_RED;
    public static final String NAME_MIX_COLOR_ORANGE_ORANGE   = "ОРАНЖЕВО-"+NAME_BASIC_COLOR_ORANGE;
    public static final String NAME_MIX_COLOR_ORANGE_YELLOW   = "ОРАНЖЕВО-"+NAME_BASIC_COLOR_YELLOW;
    public static final String NAME_MIX_COLOR_ORANGE_GREEN    = "ОРАНЖЕВО-"+NAME_BASIC_COLOR_GREEN;
    public static final String NAME_MIX_COLOR_ORANGE_BLUE     = "ОРАНЖЕВО-"+NAME_BASIC_COLOR_BLUE;
    public static final String NAME_MIX_COLOR_ORANGE_NAVYBLUE = "ОРАНЖЕВО-"+NAME_BASIC_COLOR_NAVYBLUE;
    public static final String NAME_MIX_COLOR_ORANGE_PURPLE   = "ОРАНЖЕВО-"+NAME_BASIC_COLOR_PURPLE;
    public static final String NAME_MIX_COLOR_ORANGE_NONE     = "ОРАНЖЕВО-"+ NAME_BASIC_COLOR_NONE;

    // Смешение различных цветов радуги с ЖЕЛТЫМ цветом.
    public static final String NAME_MIX_COLOR_YELLOW_RED      = "ЖЕЛТО-"+NAME_BASIC_COLOR_RED;
    public static final String NAME_MIX_COLOR_YELLOW_ORANGE   = "ЖЕЛТО-"+NAME_BASIC_COLOR_ORANGE;
    public static final String NAME_MIX_COLOR_YELLOW_YELLOW   = "ЖЕЛТО-"+NAME_BASIC_COLOR_YELLOW;
    public static final String NAME_MIX_COLOR_YELLOW_GREEN    = "ЖЕЛТО-"+NAME_BASIC_COLOR_GREEN;
    public static final String NAME_MIX_COLOR_YELLOW_BLUE     = "ЖЕЛТО-"+NAME_BASIC_COLOR_BLUE;
    public static final String NAME_MIX_COLOR_YELLOW_NAVYBLUE = "ЖЕЛТО-"+NAME_BASIC_COLOR_NAVYBLUE;
    public static final String NAME_MIX_COLOR_YELLOW_PURPLE   = "ЖЕЛТО-"+NAME_BASIC_COLOR_PURPLE;
    public static final String NAME_MIX_COLOR_YELLOW_NONE     = "ЖЕЛТО-"+ NAME_BASIC_COLOR_NONE;

    // Смешение различных цветов радуги с ЗЕЛЕНЫМ цветом.
    public static final String NAME_MIX_COLOR_GREEN_RED      = "ЗЕЛЕНО"+NAME_BASIC_COLOR_RED;
    public static final String NAME_MIX_COLOR_GREEN_ORANGE   = "ЗЕЛЕНО-"+NAME_BASIC_COLOR_ORANGE;
    public static final String NAME_MIX_COLOR_GREEN_YELLOW   = "ЗЕЛЕНО-"+NAME_BASIC_COLOR_YELLOW;
    public static final String NAME_MIX_COLOR_GREEN_GREEN    = "ЗЕЛЕНО-"+NAME_BASIC_COLOR_GREEN;
    public static final String NAME_MIX_COLOR_GREEN_BLUE     = "ЗЕЛЕНО-"+NAME_BASIC_COLOR_BLUE;
    public static final String NAME_MIX_COLOR_GREEN_NAVYBLUE = "ЗЕЛЕНО-"+NAME_BASIC_COLOR_NAVYBLUE;
    public static final String NAME_MIX_COLOR_GREEN_PURPLE   = "ЗЕЛЕНО-"+NAME_BASIC_COLOR_PURPLE;
    public static final String NAME_MIX_COLOR_GREEN_NONE     = "ЗЕЛЕНО-"+NAME_BASIC_COLOR_NONE;

    // Смешение различных цветов радуги с ГОЛУБЫМ цветом.
    public static final String NAME_MIX_COLOR_BLUE_RED      = "ГОЛУБО"+NAME_BASIC_COLOR_RED;
    public static final String NAME_MIX_COLOR_BLUE_ORANGE   = "ГОЛУБО-"+NAME_BASIC_COLOR_ORANGE;
    public static final String NAME_MIX_COLOR_BLUE_YELLOW   = "ГОЛУБО-"+NAME_BASIC_COLOR_YELLOW;
    public static final String NAME_MIX_COLOR_BLUE_GREEN    = "ГОЛУБО-"+NAME_BASIC_COLOR_GREEN;
    public static final String NAME_MIX_COLOR_BLUE_BLUE     = "ГОЛУБО-"+NAME_BASIC_COLOR_BLUE;
    public static final String NAME_MIX_COLOR_BLUE_NAVYBLUE = "ГОЛУБО-"+NAME_BASIC_COLOR_NAVYBLUE;
    public static final String NAME_MIX_COLOR_BLUE_PURPLE   = "ГОЛУБО-"+NAME_BASIC_COLOR_PURPLE;
    public static final String NAME_MIX_COLOR_BLUE_NONE     = "ГОЛУБО-"+NAME_BASIC_COLOR_NONE;

    // Смешение различных цветов радуги с СИНИМ цветом.
    public static final String NAME_MIX_COLOR_NAVYBLUE_RED      = "СИНЕ"+NAME_BASIC_COLOR_RED;
    public static final String NAME_MIX_COLOR_NAVYBLUE_ORANGE   = "СИНЕ-"+NAME_BASIC_COLOR_ORANGE;
    public static final String NAME_MIX_COLOR_NAVYBLUE_YELLOW   = "СИНЕ-"+NAME_BASIC_COLOR_YELLOW;
    public static final String NAME_MIX_COLOR_NAVYBLUE_GREEN    = "СИНЕ-"+NAME_BASIC_COLOR_GREEN;
    public static final String NAME_MIX_COLOR_NAVYBLUE_BLUE     = "СИНЕ-"+NAME_BASIC_COLOR_BLUE;
    public static final String NAME_MIX_COLOR_NAVYBLUE_NAVYBLUE = "СИНЕ-"+NAME_BASIC_COLOR_NAVYBLUE;
    public static final String NAME_MIX_COLOR_NAVYBLUE_PURPLE   = "СИНЕ-"+NAME_BASIC_COLOR_PURPLE;
    public static final String NAME_MIX_COLOR_NAVYBLUE_NONE     = "СИНЕ-"+NAME_BASIC_COLOR_NONE;

    // Смешение различных цветов радуги с ФИОЛЕТОВЫМ цветом.
    public static final String NAME_MIX_COLOR_PURPLE_RED      = "ФИОЛЕТОВО"+NAME_BASIC_COLOR_RED;
    public static final String NAME_MIX_COLOR_PURPLE_ORANGE   = "ФИОЛЕТОВО-"+NAME_BASIC_COLOR_ORANGE;
    public static final String NAME_MIX_COLOR_PURPLE_YELLOW   = "ФИОЛЕТОВО-"+NAME_BASIC_COLOR_YELLOW;
    public static final String NAME_MIX_COLOR_PURPLE_GREEN    = "ФИОЛЕТОВО-"+NAME_BASIC_COLOR_GREEN;
    public static final String NAME_MIX_COLOR_PURPLE_BLUE     = "ФИОЛЕТОВО-"+NAME_BASIC_COLOR_BLUE;
    public static final String NAME_MIX_COLOR_PURPLE_NAVYBLUE = "ФИОЛЕТОВО-"+NAME_BASIC_COLOR_NAVYBLUE;
    public static final String NAME_MIX_COLOR_PURPLE_PURPLE   = "ФИОЛЕТОВО-"+NAME_BASIC_COLOR_PURPLE;
    public static final String NAME_MIX_COLOR_PURPLE_NONE     = "ФИОЛЕТОВО-"+NAME_BASIC_COLOR_NONE;

    // Смешение различных цветов радуги с НЕИЗВЕСТНЫМ_ЦВЕТОМ цветом.
    public static final String NAME_MIX_COLOR_DEFAULT_RED      = NAME_BASIC_COLOR_NONE+"-"+NAME_BASIC_COLOR_RED;
    public static final String NAME_MIX_COLOR_DEFAULT_ORANGE   = NAME_BASIC_COLOR_NONE+"-"+NAME_BASIC_COLOR_ORANGE;
    public static final String NAME_MIX_COLOR_DEFAULT_YELLOW   = NAME_BASIC_COLOR_NONE+"-"+NAME_BASIC_COLOR_YELLOW;
    public static final String NAME_MIX_COLOR_DEFAULT_GREEN    = NAME_BASIC_COLOR_NONE+"-"+NAME_BASIC_COLOR_GREEN;
    public static final String NAME_MIX_COLOR_DEFAULT_BLUE     = NAME_BASIC_COLOR_NONE+"-"+NAME_BASIC_COLOR_BLUE;
    public static final String NAME_MIX_COLOR_DEFAULT_NAVYBLUE = NAME_BASIC_COLOR_NONE+"-"+NAME_BASIC_COLOR_NAVYBLUE;
    public static final String NAME_MIX_COLOR_DEFAULT_PURPLE   = NAME_BASIC_COLOR_NONE+"-"+NAME_BASIC_COLOR_PURPLE;

    public Colors() {

    }
}

