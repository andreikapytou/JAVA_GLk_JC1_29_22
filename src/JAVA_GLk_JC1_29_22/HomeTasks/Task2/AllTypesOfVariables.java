package JAVA_GLk_JC1_29_22.HomeTasks.Task2;


/**
 * Класс AllTypesOfVariables.
 * В данном класе создны глобальные переменные всех типов(примитивы и обертки).
 * И для каждой глобальной переменной реализованы методы - геттеры и сеттеры.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class AllTypesOfVariables {

    // Область объявления глобальных "примитивных" констант класса AllTypesOfVariables.
    public static final int CONSTANT_GLOBAL_PRIMITIVE_INT = 15;          // Константа типа - int
    public static final float CONSTANT_GLOBAL_PRIMITIVE_FLOAT = 7.7F;   // Константа типа - float

    // Область объявления глобальных "обёрточныхх" констант класса StartClassTask2.
    public static final String CONSTANT_GLOBAL_WRAPPER_STRING = "Константа_типа_String2"; // Константа типа - String
    public static final Integer CONSTANT_GLOBAL_WRAPPER_INTEGER = 20001;

    // Область объявления глобальных "примитивных" переменных класса AllTypesOfVariables.
    private boolean variableGlobalPrimitiveBoolean;
    private char variableGlobalPrimitiveChar;
    private short variableGlobalPrimitiveShort;
    private byte variableGlobalPrimitiveByte;
    private int variableGlobalPrimitiveInt;
    private long variableGlobalPrimitiveLong;
    private float variableGlobalPrimitiveFloat;
    private double variableGlobalPrimitiveDouble;

    // Область объявления глобальных "обёрточных" переменных класса AllTypesOfVariables.
    private Boolean variableGlobalWrapperBoolean;
    private Character variableGlobalWrapperCharacter;
    private Short variableGlobalWrapperShort;
    private Byte variableGlobalWrapperByte;
    private Integer variableGlobalWrapperInteger;
    private Long variableGlobalWrapperLong;
    private Float variableGlobalWrapperFloat;
    private Double variableGlobalWrapperDouble;

    private String variableGlobalWrapperString = "Объявили_и_проинициализировали_2";

    { /* Блок инициализации всех Глобальных переемнных. */

        variableGlobalPrimitiveBoolean = true;
        variableGlobalPrimitiveChar = 'Q';
        variableGlobalPrimitiveShort = 20;
        variableGlobalPrimitiveByte = 110;
        variableGlobalPrimitiveInt = 45483000;
        variableGlobalPrimitiveLong = 6_666_777_036_854_775_800L;
        variableGlobalPrimitiveFloat = 78.456F;
        variableGlobalPrimitiveDouble = 1.111;

        variableGlobalWrapperBoolean = true;
        variableGlobalWrapperCharacter = 'R';
        variableGlobalWrapperShort = (short)33;
        variableGlobalWrapperByte = (byte)99;
        variableGlobalWrapperInteger = 2147483000;
        variableGlobalWrapperLong = 4_444_444_444_854_775_807L;
        variableGlobalWrapperFloat = 3.33356F;
        variableGlobalWrapperDouble = 5.67890;
    }

    public AllTypesOfVariables() { /* Конструктор по умолчанию для класса AllTypesOfVariables */

    }

    /* Объявление метода printAllGlobalData()
     * Вывод на печать-экран-консоль всех объявленных Глобальных констант и переемнных класса.
     */
    public void printAllGlobalData() {

        System.out.println("\n\nВывод на консоль Глобальных примитивных констант и переменных экземпляра класса AllTypesOfVariables.\n");
        System.out.println("Global primitive constant type boolean    : " + CONSTANT_GLOBAL_PRIMITIVE_INT);
        System.out.println("Global primitive constant type float      : " + CONSTANT_GLOBAL_PRIMITIVE_FLOAT);

        System.out.println("Global primitive variable type boolean    : " + variableGlobalPrimitiveBoolean);
        System.out.println("Global primitive variable type char       : " + variableGlobalPrimitiveChar);
        System.out.println("Global primitive variable type short      : " + variableGlobalPrimitiveShort);
        System.out.println("Global primitive variable type byte       : " + variableGlobalPrimitiveByte);
        System.out.println("Global primitive variable type int        : " + variableGlobalPrimitiveInt);
        System.out.println("Global primitive variable type long       : " + variableGlobalPrimitiveLong);
        System.out.println("Global primitive variable type float      : " + variableGlobalPrimitiveFloat);
        System.out.println("Global primitive variable type double     : " + variableGlobalPrimitiveDouble);

        System.out.println("\n\nВывод на консоль Глобальных \"оберточных\" констант и переменных экземпляра класса AllTypesOfVariables.\n");
        System.out.println("Global wrapper constant type Integer    : " + CONSTANT_GLOBAL_WRAPPER_INTEGER);
        System.out.println("Global wrapper constant type String     : " + CONSTANT_GLOBAL_WRAPPER_STRING);

        System.out.println("Global wrapper variable type Boolean    : " + variableGlobalWrapperBoolean);
        System.out.println("Global wrapper variable type Character  : " + variableGlobalWrapperCharacter);
        System.out.println("Global wrapper variable type Short      : " + variableGlobalWrapperShort);
        System.out.println("Global wrapper variable type Byte       : " + variableGlobalWrapperByte);
        System.out.println("Global wrapper variable type Integer    : " + variableGlobalWrapperInteger);
        System.out.println("Global wrapper variable type Long       : " + variableGlobalWrapperLong);
        System.out.println("Global wrapper variable type Float      : " + variableGlobalWrapperFloat);
        System.out.println("Global wrapper variable type Double     : " + variableGlobalWrapperDouble);
        System.out.println("Global wrapper variable type String     : " + variableGlobalWrapperString);
    }

    /* Объявление метода experimentVariable()
     * Експеримент с присвоением переменных друг в друга и приведением типов.
     */
    public void experimentVariable() {

        System.out.printf("\n\nЗначение переменной(short) A : %d до присвоения ей значения перемнной(Short) B\n",
                variableGlobalPrimitiveShort);
        System.out.printf("Значение перемнной(Short) B : %d \n", variableGlobalWrapperShort);
        // Переменной "примитивного" типа short присваивается значение перемнной типа "обвертки" типа Short.
        variableGlobalPrimitiveShort = variableGlobalWrapperShort; // Без ошибки и без приведения типов.
        System.out.printf("Значение переменной(short) A : %d после присвоенгия ей значения  перемнной(Short) B \n",
                variableGlobalPrimitiveShort);

        // Переменной "примитивного" типа float присваивается значение перемнной типа "обвертки" типа Float.
        variableGlobalPrimitiveFloat = variableGlobalWrapperFloat; // Без ошибки.

        // Переменной "обверточного" типа Short присваивается значение перемнной "примиитвного" типа short.
        variableGlobalWrapperShort = variableGlobalPrimitiveShort; // Без ошибки.

        // Переменной "обверточного" типа Float присваивается значение перемнной "примиитвного" типа float.
        variableGlobalWrapperFloat = variableGlobalPrimitiveFloat; // Без ошибки и без приведения типов.

        System.out.printf("Значение перименной(byte) A : %d до присвоения ей значения перемнной(int) B\n",
                variableGlobalPrimitiveByte);
        System.out.printf("Значение переменной(int) B : %d \n", variableGlobalPrimitiveInt);
        // Переменной "примитивного" типа byte присваивается значение перемнной "примитивного" типа int.
        // После приведения типа - данные будут утеряны так как 4-х байтный тип int сократися до размера 1-го байта.
        // В итоге после приведния типов в переменной variableGlobalPrimitiveByte - будет находится значение
        // нулевого(первого) байта - нумерация с Права на Лево переменной variableGlobalPrimitiveInt.
        variableGlobalPrimitiveByte = (byte)variableGlobalPrimitiveInt; // Без явного прпведения типов - Ошибка.
        System.out.printf("Значение переменной(byte) A : %d после присвоения ей значения переменной(int) B \n",
                variableGlobalPrimitiveByte);
    }


    /* Объявление метода getPrimitiveBoolean()
     * Возвращаем-получаем текущее значение глобальной переменной variableGlobalPrimitiveBoolean.
     */
    public boolean getPrimitiveBoolean() {

        return variableGlobalPrimitiveBoolean;
    }

    /* Объявление метода setPrimitiveBoolean()
     * Задаем-устанавливаем-присваиваем новое значение глобальной переменной variableGlobalPrimitiveBoolean.
     */
    public void setPrimitiveBoolean(boolean variableGlobalPrimitiveBoolean) {

        this.variableGlobalPrimitiveBoolean = variableGlobalPrimitiveBoolean;
    }


    public char getPrimitiveChar() {

        return variableGlobalPrimitiveChar;
    }

    public void setPrimitiveChar(char variableGlobalPrimitiveChar) {

        this.variableGlobalPrimitiveChar = variableGlobalPrimitiveChar;
    }

    public short getPrimitiveShort() {

        return variableGlobalPrimitiveShort;
    }

    public void setPrimitiveShort(short variableGlobalPrimitiveShort) {

        this.variableGlobalPrimitiveShort = variableGlobalPrimitiveShort;
    }

    public byte getPrimitiveByte() {

        return variableGlobalPrimitiveByte;
    }

    public void setPrimitiveByte(byte variableGlobalPrimitiveByte) {

        this.variableGlobalPrimitiveByte = variableGlobalPrimitiveByte;
    }

    public int getPrimitiveInt() {

        return variableGlobalPrimitiveInt;
    }

    public void setPrimitiveInt(int variableGlobalPrimitiveInt) {

        this.variableGlobalPrimitiveInt = variableGlobalPrimitiveInt;
    }

    public long getPrimitiveLong() {

        return variableGlobalPrimitiveLong;
    }

    public void setPrimitiveLong(long variableGlobalPrimitiveLong) {

        this.variableGlobalPrimitiveLong = variableGlobalPrimitiveLong;
    }

    public float getPrimitiveFloat() {

        return variableGlobalPrimitiveFloat;
    }

    public void setPrimitiveFloat(float variableGlobalPrimitiveFloat) {

        this.variableGlobalPrimitiveFloat = variableGlobalPrimitiveFloat;
    }

    public double getPrimitiveDouble() {

        return variableGlobalPrimitiveDouble;
    }

    public void setPrimitiveDouble(double variableGlobalPrimitiveDouble) {

        this.variableGlobalPrimitiveDouble = variableGlobalPrimitiveDouble;
    }

    public Boolean getWrapperBoolean() {

        return variableGlobalWrapperBoolean;
    }

    public void setWrapperBoolean(Boolean variableGlobalWrapperBoolean) {

        this.variableGlobalWrapperBoolean = variableGlobalWrapperBoolean;
    }

    public Character getWrapperCharacter() {

        return variableGlobalWrapperCharacter;
    }

    public void setWrapperCharacter(Character variableGlobalWrapperCharacter) {

        this.variableGlobalWrapperCharacter = variableGlobalWrapperCharacter;
    }

    public Short getWrapperShort() {

        return variableGlobalWrapperShort;
    }

    public void setWrapperShort(Short variableGlobalWrapperShort) {

        this.variableGlobalWrapperShort = variableGlobalWrapperShort;
    }

    public Byte getWrapperByte() {

        return variableGlobalWrapperByte;
    }

    public void setWrapperByte(Byte variableGlobalWrapperByt) {

        this.variableGlobalWrapperByte = variableGlobalWrapperByt;
    }

    public Integer getWrapperInteger() {

        return variableGlobalWrapperInteger;
    }

    public void setWrapperInteger(Integer variableGlobalWrapperInteger) {

        this.variableGlobalWrapperInteger = variableGlobalWrapperInteger;
    }

    public Long getWrapperLong() {

        return variableGlobalWrapperLong;
    }

    public void setWrapperLong(Long variableGlobalWrapperLong) {

        this.variableGlobalWrapperLong = variableGlobalWrapperLong;
    }

    public Float getWrapperFloat() {

        return variableGlobalWrapperFloat;
    }

    public void setWrapperFloat(Float variableGlobalWrapperFloat) {

        this.variableGlobalWrapperFloat = variableGlobalWrapperFloat;
    }

    public Double getWrapperDouble() {

        return variableGlobalWrapperDouble;
    }

    public void setWrapperDouble(Double variableGlobalWrapperDouble) {

        this.variableGlobalWrapperDouble = variableGlobalWrapperDouble;
    }

    public String getWrapperString() {

        return variableGlobalWrapperString;
    }

    public void setWrapperString(String variableGlobalWrapperString) {

        this.variableGlobalWrapperString = variableGlobalWrapperString;
    }
}