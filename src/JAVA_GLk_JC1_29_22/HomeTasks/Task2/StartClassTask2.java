package JAVA_GLk_JC1_29_22.HomeTasks.Task2;
/**
 * Класс StartClassTask2.
 * В данном класе реализован метод main().
 * Метод main() - "главный метод", котрый является точка входа приложения-программы,
 * с запуска-вызова этого метода начинается запуск-правление всего приложения-рограммы задачи №2.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class StartClassTask2 {

    // Область объявления глобальных "примитивных" констант класса StartClassTask2.
    public static final int CONSTANT_GLOBAL_PRIMITIVE_INT = 5;          // Константа типа - int
    public static final float CONSTANT_GLOBAL_PRIMITIVE_FLOAT = 4.4F;   // Константа типа - float

    // Область объявления глобальных "обёрточныхх" констант класса StartClassTask2.
    public static final String CONSTANT_GLOBAL_WRAPPER_STRING = "Константа_типа_String"; // Константа типа - String
    public static final Integer CONSTANT_GLOBAL_WRAPPER_INTEGER = 2147483647;

    // Область объявления глобальных "примитивных" переменных класса StartClassTask2.
    public static boolean variableGlobalPrimitiveBoolean = true;
    public static char variableGlobalPrimitiveChar = 'J';
    public static short variableGlobalPrimitiveShort = 10;
    public static byte variableGlobalPrimitiveByte = 127;
    public static int variableGlobalPrimitiveInt = 1147483000;
    public static long variableGlobalPrimitiveLong = 8_223_372_036_854_775_800L;
    public static float variableGlobalPrimitiveFloat = 3.123F;
    public static double variableGlobalPrimitiveDouble = 6.666666;

    // Область объявления глобальных "обёрточных" переменных класса StartClassTask2.
    public static Boolean variableGlobalWrapperBoolean = true;
    private Character variableGlobalWrapperCharacter = 'I';
    private Short variableGlobalWrapperShort1 = variableGlobalPrimitiveShort;
    private Short variableGlobalWrapperShort2 = (short)11;
    private Byte variableGlobalWrapperByte =  (byte)127;
    private Integer variableGlobalWrapperInteger = 2147483647;
    private Long variableGlobalWrapperLong = 9_223_372_036_854_775_807L;
    private Float variableGlobalWrapperFloat = 3.123F;
    private Double variableGlobalWrapperDouble = 5.12356789;

    /* Из статьи на ресурсе javarush.ru.
     *  String — это класс в Java, который прописан в пакете java.lang.
     *  Это не примитивный тип данных, как int и long.
     *  Класс String представляет строковый набор символов.
     */
    private String variableGlobalWrapperString = new String("Объявили_и_проинициализировали");

    public StartClassTask2() { /* Конструктор по умолчанию для класса StartClassTask2 */

    }

    /* Объявление метода printGlobalWrapperData()
     * Вывод на печать-экран-консоль Глобальных констант и переемнных "оберточного" типа.
     */
    public void printGlobalWrapperData() {

        System.out.println("\n\nВывод на консоль Глобальных \"оберточных\" констант и переменных класса StartClassTask2.\n");
        System.out.println("Global wrapper constant type Integer    : " + CONSTANT_GLOBAL_WRAPPER_INTEGER);
        System.out.println("Global wrapper constant type String     : " + CONSTANT_GLOBAL_WRAPPER_STRING);

        System.out.println("Global wrapper variable type Boolean    : " + variableGlobalWrapperBoolean);
        System.out.println("Global wrapper variable type Character  : " + variableGlobalWrapperCharacter);
        System.out.println("Global wrapper variable type Byte       : " + variableGlobalWrapperByte);
        System.out.println("Global wrapper variable type Short1     : " + variableGlobalWrapperShort1);
        System.out.println("Global wrapper variable type Short2     : " + variableGlobalWrapperShort2);
        System.out.println("Global wrapper variable type Integer    : " + variableGlobalWrapperInteger);
        System.out.println("Global wrapper variable type Long       : " + variableGlobalWrapperLong);
        System.out.println("Global wrapper variable type Float      : " + variableGlobalWrapperFloat);
        System.out.println("Global wrapper variable type Double     : " + variableGlobalWrapperDouble);
        System.out.println("Global wrapper variable type String     : " + variableGlobalWrapperString);
    }

    /* Объявление метода main() */
    public static void main(String[] args) { /* Заголовок метода */
        // Строки-инструкции кода ниже - это тело-содержимое-реализация метода main().

        // Область объявления локальных "примитивных" переменных метода main().
        boolean variableLocalPrimitiveBoolean = false;
        char variableLocalPrimitiveChar = 'P';
        short variableLocalPrimitiveShort = 13;
        byte variableLocalPrimitiveByte = -120;
        int variableLocalPrimitiveInt = 483000;
        long variableLocalPrimitiveLong = 3_000_000_036_854_775_800L;
        float variableLocalPrimitiveFloat = 4.987F;
        double variableLocalPrimitiveDouble = 8.8888;

        // Область объявления локальных "обёрточных" переменных метода main().
        Boolean variableLocalWrapperBoolean = true;
        Character variableLocalWrapperCharacter = 'D';
        Short variableLocalWrapperShort =  (short)15;
        Byte variableLocalWrapperByte = (byte)100;
        Integer variableLocalWrapperInteger = 20001;
        Long variableLocalWrapperLong = 5_555_555_036_854_775_555L;
        Float variableLocalWrapperFloat = 7.123F;
        Double variableLocalWrapperDouble = 10.111118;

        // Cоздаем объект startClass - экземпляр класса StartClassTask2.
        StartClassTask2 startClass = new StartClassTask2();

        // Вывод на консоль Глобальных примитивных констант и переменных класса StartClassTask2.
        System.out.println("\nВывод на консоль Глобальных примитивных констант и переменных класса StartClassTask2.\n");
        System.out.println("Global primitive constant type int      : " + CONSTANT_GLOBAL_PRIMITIVE_INT);
        System.out.println("Global primitive constant type float    : " + CONSTANT_GLOBAL_PRIMITIVE_FLOAT);

        System.out.println("Global primitive variable type boolean  : " + variableGlobalPrimitiveBoolean);
        System.out.println("Global primitive variable type char     : " + variableGlobalPrimitiveChar);
        System.out.println("Global primitive variable type short    : " + variableGlobalPrimitiveShort);
        System.out.println("Global primitive variable type byte     : " + variableGlobalPrimitiveByte);
        System.out.println("Global primitive variable type int      : " + variableGlobalPrimitiveInt);
        System.out.println("Global primitive variable type long     : " + variableGlobalPrimitiveLong);
        System.out.println("Global primitive variable type float    : " + variableGlobalPrimitiveFloat);
        System.out.println("Global primitive variable type double   : " + variableGlobalPrimitiveDouble);

        // Вызов метода printGlobalWrapperData() пренадлежашего экземпляру класса  StartClassTask2.
        startClass.printGlobalWrapperData();

        // Вывод на консоль Локальных примитивных переменных метода main().
        System.out.println("\n\nВывод на консоль Локальных примитивных переменных метода main().\n");
        System.out.println("Local primitive variable type boolean    : " + variableLocalPrimitiveBoolean);
        System.out.println("Local primitive variable type char       : " + variableLocalPrimitiveChar);
        System.out.println("Local primitive variable type byte       : " + variableLocalPrimitiveByte);
        System.out.println("Local primitive variable type short      : " + variableLocalPrimitiveShort);
        System.out.println("Local primitive variable type int        : " + variableLocalPrimitiveInt);
        System.out.println("Local primitive variable type long       : " + variableLocalPrimitiveLong);
        System.out.println("Local primitive variable type float      : " + variableLocalPrimitiveFloat);
        System.out.println("Local primitive variable type double     : " + variableLocalPrimitiveDouble);

        // Вывод на консоль Локальных "оберточных" переменных метода main().
        System.out.println("\n\nВывод на консоль Локальных \"оберточных\" переменных метода main().\n");
        System.out.println("Local wrapper variable type Boolean    : " + variableLocalWrapperBoolean);
        System.out.println("Local wrapper variable type Character  : " + variableLocalWrapperCharacter);
        System.out.println("Local primitive variable type Byte     : " + variableLocalWrapperByte);
        System.out.println("Local wrapper variable type Short      : " + variableLocalWrapperShort);
        System.out.println("Local wrapper variable type Integer    : " + variableLocalWrapperInteger);
        System.out.println("Local wrapper variable type Long       : " + variableLocalWrapperLong);
        System.out.println("Local wrapper variable type Float      : " + variableLocalWrapperFloat);
        System.out.println("Local wrapper variable type Double     : " + variableLocalWrapperDouble);

        // Cоздаем объект allTypesOfVariables - экземпляр класса AllTypesOfVariables.
        AllTypesOfVariables allTypesOfVariables = new AllTypesOfVariables();

        // Вызов метода printAllGlobalData() - вывод значений глобальных перемнных после первоначсальной инициализации.
        allTypesOfVariables.printAllGlobalData();

        // Задаем-устанавливам новые значения Глобальным перемнным через методы set()
        allTypesOfVariables.setPrimitiveBoolean(false);
        allTypesOfVariables.setPrimitiveChar('W');
        allTypesOfVariables.setPrimitiveShort( (short)45 );
        allTypesOfVariables.setPrimitiveByte( (byte)127 );
        allTypesOfVariables.setPrimitiveInt(234567);
        allTypesOfVariables.setPrimitiveLong(4567890L);
        allTypesOfVariables.setPrimitiveFloat(345.57F);
        allTypesOfVariables.setPrimitiveDouble(345.578890000000);

        allTypesOfVariables.setWrapperBoolean(false);
        allTypesOfVariables.setWrapperCharacter('Q');
        allTypesOfVariables.setWrapperShort( (short)100 );
        allTypesOfVariables.setWrapperByte( (byte)56 );
        allTypesOfVariables.setWrapperInteger(345678);
        allTypesOfVariables.setWrapperLong(967_3456L);
        allTypesOfVariables.setWrapperFloat(32.1234F);
        allTypesOfVariables.setWrapperDouble(456.09987655443323222);
        allTypesOfVariables.setWrapperString("Вызвали_Сеттер_Присовили_Новое_Значение");

        System.out.println("\n\nВывод на консоль Глобальных данных экземпляра класса AllTypesOfVariables - через вызов методов get()\n");
        System.out.println("Global primitive constant type boolean  : " + AllTypesOfVariables.CONSTANT_GLOBAL_PRIMITIVE_INT);
        System.out.println("Global primitive constant type float    : " + AllTypesOfVariables.CONSTANT_GLOBAL_PRIMITIVE_FLOAT);
        System.out.println("Global primitive variable type boolean  : " + allTypesOfVariables.getPrimitiveBoolean());
        System.out.println("Global primitive variable type char     : " + allTypesOfVariables.getPrimitiveChar());
        System.out.println("Global primitive variable type short    : " + allTypesOfVariables.getPrimitiveShort());
        System.out.println("Global primitive variable type byte     : " + allTypesOfVariables.getPrimitiveByte());
        System.out.println("Global primitive variable type int      : " + allTypesOfVariables.getPrimitiveInt());
        System.out.println("Global primitive variable type long     : " + allTypesOfVariables.getPrimitiveLong());
        System.out.println("Global primitive variable type float    : " + allTypesOfVariables.getPrimitiveFloat());
        System.out.println("Global primitive variable type double   : " + allTypesOfVariables.getPrimitiveDouble());
        System.out.println("Global wrapper constant type Integer    : " + AllTypesOfVariables.CONSTANT_GLOBAL_WRAPPER_INTEGER);
        System.out.println("Global wrapper constant type String     : " + AllTypesOfVariables.CONSTANT_GLOBAL_WRAPPER_STRING);
        System.out.println("Global wrapper variable type Boolean    : " + allTypesOfVariables.getWrapperBoolean());
        System.out.println("Global wrapper variable type Character  : " + allTypesOfVariables.getWrapperCharacter());
        System.out.println("Global wrapper variable type Short      : " + allTypesOfVariables.getWrapperShort());
        System.out.println("Global wrapper variable type Byte       : " + allTypesOfVariables.getWrapperByte());
        System.out.println("Global wrapper variable type Integer    : " + allTypesOfVariables.getWrapperInteger());
        System.out.println("Global wrapper variable type Long       : " + allTypesOfVariables.getWrapperLong());
        System.out.println("Global wrapper variable type Float      : " + allTypesOfVariables.getWrapperFloat());
        System.out.println("Global wrapper variable type Double     : " + allTypesOfVariables.getWrapperDouble());
        System.out.println("Global wrapper variable type String     : " + allTypesOfVariables.getWrapperString());

        // Вызов метода experimentVariable()
        allTypesOfVariables.experimentVariable();

    }
}
