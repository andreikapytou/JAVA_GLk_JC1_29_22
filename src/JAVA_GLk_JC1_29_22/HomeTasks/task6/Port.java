package JAVA_GLk_JC1_29_22.HomeTasks.task6;

import JAVA_GLk_JC1_29_22.HomeTasks.task6.container.*;
import JAVA_GLk_JC1_29_22.HomeTasks.task6.util.MyRandom;

public class Port {

    private int numMaxShip;
    private ShipMultiDec[] arrShipMultiDec;


    public Port(int numMaxShip){

        if (numMaxShip > 0) {

            this.numMaxShip = numMaxShip;
            this.arrShipMultiDec = new ShipMultiDec[numMaxShip];

        } else {
            System.out.println("Введено неверное число кораблей в массиве " + numMaxShip);
            this.arrShipMultiDec = new ShipMultiDec[1];
        }
    }

    public int calculateTotalWeightAllShips() {
        int TotalWeightAllShips = 0;
        for (ShipMultiDec nextShip : arrShipMultiDec) {
            Deck[] arrDeck = nextShip.getArrDeck();
            for(Deck nextDec : arrDeck){
                AbstractContainer[] arrContainer = nextDec.getArrContainers();
                for (AbstractContainer nextContainer : arrContainer ) {
                    int weighNextOneContainer = nextContainer.calculateWeight();
                    TotalWeightAllShips = TotalWeightAllShips + weighNextOneContainer;
                }
            }
        }
        return TotalWeightAllShips;
    }

    public void loadShip(){

        String[] arrNamesShip = {"Корабль1", "Корабль2", "Корабль3", "Корабль4", "Корабль5"};
        ShipMultiDec[] arrQueueInPortShipMultiDec = new ShipMultiDec[5];

        for(int i=0; i<arrQueueInPortShipMultiDec.length; i++ ){
            arrQueueInPortShipMultiDec[i] = new ShipMultiDec(arrNamesShip[i] , getValueRandomQuantityDeckToShip());
            int quantityDeckToShip = arrQueueInPortShipMultiDec[i].getTypeSizeDeckShip();

            if(quantityDeckToShip == Const.DECK_ONE) {

                Deck[] arrDeckOne = new Deck[quantityDeckToShip];
                arrDeckOne[0] = new Deck(5);
                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckOne);

                int sizeContainer = getValueRandomTypeSizeContainer();
                int height  = getValueRandomHeight();
                int densityWater = getValueRandomDensityWater();
                AbstractContainer nextContainer = createRandomContainer(sizeContainer, height, densityWater);
                arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer );

            } else if (quantityDeckToShip == Const.DECK_TWO ) {

                Deck[] arrDeckTwo = new Deck[quantityDeckToShip];
                arrDeckTwo[0] = new Deck(5);
                arrDeckTwo[1] = new Deck(4);
                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckTwo);

                int sizeContainer1 = getValueRandomTypeSizeContainer();
                int height1  = getValueRandomHeight();
                int densityWater1 = getValueRandomDensityWater();
                AbstractContainer nextContainer1 = createRandomContainer(sizeContainer1, height1, densityWater1);
                arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip-1, nextContainer1);

                int sizeContainer2 = getValueRandomTypeSizeContainer();
                int height2  = getValueRandomHeight();
                int densityWater2 = getValueRandomDensityWater();
                AbstractContainer nextContainer2 = createRandomContainer(sizeContainer2, height2, densityWater2);
                arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer2 );

            } else {
                System.out.println("!!!!! Неизвестный номер Палубы");
            }

        }

        for(int i=0; i<arrShipMultiDec.length; i++ ){
            arrShipMultiDec[i] = arrQueueInPortShipMultiDec[i].myClone();
        }

        int countAllContainer=0;
        for (ShipMultiDec nextShip : arrShipMultiDec) {
            Deck[] arrDeck = nextShip.getArrDeck();
            for(Deck nextDec : arrDeck){
                nextDec.getCountAddContainers();
                AbstractContainer[] arrContainer = nextDec.getArrContainers();
                for (int i=0; i<nextDec.getCountAddContainers(); i++ ) {
                    System.out.println(arrContainer[i].getTypeGeometry() + " " + arrContainer[i].getTypeSize());
                    countAllContainer++;
                }
            }
        }
        System.out.println("Общее число контейнеров = " + countAllContainer );
    }

    public void printAllContainerToPort() {

        System.out.println();
        for (ShipMultiDec nextShip : arrShipMultiDec) {
              nextShip.printDataContainerOnAllDeck();
        }
    }

    public int getValueRandomTypeSizeContainer() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.TYPE_SIZE_LITTLE_CONTAINER;
        }
        return Const.TYPE_SIZE_BIG_CONTAINER;
    }

    public int getValueRandomQuantityDeckToShip() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.DECK_ONE;
        }
        return Const.DECK_TWO;
    }

    public int getValueRandomDensityWater() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.DENSITY_WATER1;
        }
        return Const.DENSITY_WATER2;
    }

    public int getValueRandomHeight() {
        return MyRandom.nextRandomIntValueRange(Const.HEIGHT_MIN, Const.HEIGHT_MAX);
    }

    public void changeDataContainer(AbstractContainer container){

        container.setTypeSize(getValueRandomTypeSizeContainer());
        container.setHeight(getValueRandomHeight());
        container.setDensityWater(getValueRandomDensityWater());
    }
    public AbstractContainer createRandomContainer(int typeSize, int height, int densityWater){

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return new CubeContainer(typeSize, densityWater);
        } else if (num == 1 || num == 3  ) {
            return new CylinderContainer(typeSize,height, densityWater);
        } else {
            return new ConeContainer(typeSize, height, densityWater);
        }
    }

    public int getNumMaxShip() {
        return numMaxShip;
    }

    public ShipMultiDec[] getArrShipMultiDec() {
        return arrShipMultiDec;
    }
}
