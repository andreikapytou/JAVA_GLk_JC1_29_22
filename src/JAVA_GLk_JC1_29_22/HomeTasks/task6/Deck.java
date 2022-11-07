package JAVA_GLk_JC1_29_22.HomeTasks.task6;

import JAVA_GLk_JC1_29_22.HomeTasks.task6.container.*;

public class Deck {

    private int countAddContainers = 0;
    private int countAddLittleContainers = 0;
    private int countAddBigContainers = 0;
    private int numMaxContainers;
    //private AbstractContainer[] arrContainers = new AbstractContainer[Const.LITTLE_MAX_NO_BIG];
    private AbstractContainer[] arrContainers;

    public Deck(int numMaxContainers){

        if (numMaxContainers > 0) {
            this.numMaxContainers = numMaxContainers;
            this.arrContainers = new AbstractContainer[numMaxContainers];
        } else {
            System.out.println("Введено неверное число контейнеров в массиве " + numMaxContainers);
            this.arrContainers = new AbstractContainer[1];
        }
    }

    public Deck myClone()
    {
        Deck cloneDeck = new Deck(this.numMaxContainers);
        cloneDeck.arrContainers = this.arrContainers.clone();
        cloneDeck.countAddContainers = this.countAddContainers;
        cloneDeck.countAddLittleContainers = this.countAddLittleContainers;
        cloneDeck.countAddBigContainers = this.countAddBigContainers;

        return cloneDeck;
    }

    public void addArrContainers( AbstractContainer[] arrContainers ){

        for( AbstractContainer nextContainer :  arrContainers) {
                addContainer(nextContainer);
        }
    }
    public void delAllContainersInDeck( ){

        while(countAddContainers != 0 ) {
                delContainer();
        }
    }

    public void delContainer() {

        if (countAddContainers > 0) {
            System.out.printf("Контейнер №%d -> %s Тип геометрии -> %s. - удален с палубы.\n",
                    countAddContainers, typeSizeContainer(arrContainers[countAddContainers - 1]),
                    arrContainers[countAddContainers - 1].getTypeGeometry());

            reduceCountLittleOrBigContainer(arrContainers[countAddContainers - 1]);
            countAddContainers--;
        } else {
            System.out.print("Палуба - пуста. ");
            printCountContainers();
        }
    }

    public void addContainer(AbstractContainer nextContainer) {

        if (isAddContainer(nextContainer)) {
            arrContainers[countAddContainers] = nextContainer;
            countAddContainers++;

            if (isLittleContainer(nextContainer)) {
                countAddLittleContainers++;
            }
            if (isBigContainer(nextContainer)) {
                countAddBigContainers++;
            }
        } else {
            printNoAddContainer(nextContainer);
        }
    }

    private boolean isAddContainer(AbstractContainer container) {

        return (isAddBigContainer(container) || isAddLittleContainer(container));
    }

    private boolean isAddLittleContainer(AbstractContainer container) {

        return (isLittleContainer(container) && isTrueAddLittleContainer());
    }

    private boolean isTrueAddLittleContainer() {

        if ((countAddBigContainers == 0 && countAddLittleContainers < Const.LITTLE_MAX_NO_BIG) ||
                (countAddBigContainers <= Const.BIG_MAX_IS_LITTLE && countAddLittleContainers < Const.LITTLE_MAX_IS_BIG)) {
            return true;
        }
        return false;
    }

    private boolean isAddBigContainer(AbstractContainer container) {

        return (isBigContainer(container) && isTrueAddBigContainer());
    }

    private boolean isTrueAddBigContainer() {

        if ((countAddLittleContainers == 0 && countAddBigContainers < Const.BIG_MAX_NO_LITTLE) ||
                (countAddLittleContainers <= Const.LITTLE_MAX_IS_BIG && countAddBigContainers < Const.BIG_MAX_IS_LITTLE)) {
            return true;
        }
        return false;
    }

    private boolean isLittleContainer(AbstractContainer container) {

        return (container.getTypeSize() == Const.TYPE_SIZE_LITTLE_CONTAINER);
    }

    private boolean isBigContainer(AbstractContainer container) {

        return (container.getTypeSize() == Const.TYPE_SIZE_BIG_CONTAINER);
    }

    private void printNoAddContainer(AbstractContainer container) {

        if (isLittleContainer(container) || isBigContainer(container) ) {
                System.out.print("\nПалуба - заполнена. ");
                printCountContainers();
                printArrContainers();
                System.out.printf("   :Конетйнер    -> %s Тип геометрии -> %s. - не может быть добавлен на палубу.\n",
                                    typeSizeContainer(container), container.getTypeGeometry());
        } else {
            printCountContainers();
            System.out.printf("   :Конетйнер    -> %s Тип геометрии -> %s. - не может быть добавлен на палубу.\n",
                    typeSizeContainer(container), container.getTypeGeometry());
        }
    }

    private String typeSizeContainer(AbstractContainer container) {

        if (isLittleContainer(container)) {
            return "Маленький.  ";
        } else if (isBigContainer(container)) {
            return "Большой.    ";
        }
        return     "Нет_Размера.";
    }

    public void printCurrentArrContainers(){

        printCountContainers();
        printArrContainers();
    }

    private void printArrContainers() {
        for (int i=0; i< countAddContainers; i++) {
            System.out.printf("[%d]:Контейнер №%d -> %s Тип геометрии -> %s. Диагональ=%d. Высота=%d. Плотнось=%d. Объем=%d. Масс=%d\n",
                    i, i+1,typeSizeContainer(arrContainers[i]), arrContainers[i].getTypeGeometry(),
                    arrContainers[i].calculationSizeDiagonal(), arrContainers[i].getHeight(),
                    arrContainers[i].getDensityWater(),
                    arrContainers[i].calculateVolume(), arrContainers[i].calculateWeight() );
        }
    }

    private void printCountContainers() {
        System.out.printf("Число контейнеров на палубе = %d. Маленьких = %d. Больших = %d.\n",
                countAddContainers, countAddLittleContainers, countAddBigContainers);
    }

    private void reduceCountLittleOrBigContainer(AbstractContainer container) {

        if (isLittleContainer(container)) {
            countAddLittleContainers--;
        }
        if (isBigContainer(container)) {
            countAddBigContainers--;
        }
    }

    public int getCountAddContainers() {
        return countAddContainers;
    }

    public AbstractContainer[] getArrContainers() {
        return arrContainers;
    }


}
