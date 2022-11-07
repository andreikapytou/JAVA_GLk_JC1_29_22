package JAVA_GLk_JC1_29_22.HomeTasks.task6.container;

import JAVA_GLk_JC1_29_22.HomeTasks.task6.Const;

public abstract class AbstractContainer {

    private int height;         // Высота контейнера.
    private int typeSize;       // Тип размера контейнера Маленький или Большой.
    private int densityWater;   // Плотность воды-вещества-груза в контейнере.

    public abstract int calculateVolume(); // Абстрактный метод - не имеет ни какой реализации.

    public  abstract String getTypeGeometry();

    public int calculateWeight() {

        //return calculateVolume()*densityWater;
        return 1;
    }

    public AbstractContainer(int typeSize, int densityWater) {
        this.typeSize = typeSize;
        this.height = 0;
        this.densityWater = densityWater;
    }

    public AbstractContainer(int typeSize, int height, int densityWater) {
        this.typeSize = typeSize;
        this.height = height;
        this.densityWater = densityWater;
    }

    public int getHeight() {
        return height;
    }

    public int calculationSizeDiagonal() {

        if(typeSize == Const.TYPE_SIZE_LITTLE_CONTAINER) {
            return Const.DIAGONAL_LITTLE;
        } else if (typeSize == Const.TYPE_SIZE_BIG_CONTAINER) {
            return Const.DIAGONAL_BIG;
        } else {
            System.out.println("Задан Неизвестный размер контейнера.");
            return -1;
        }
    }

    public int getDensityWater() {
        return densityWater;
    }

    public void setDensityWater(int densityWater) {
        this.densityWater = densityWater;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTypeSize() {
        return typeSize;
    }

    public void setTypeSize(int typeSize) {
        this.typeSize = typeSize;
    }
}

