package JAVA_GLk_JC1_29_22.HomeTasks.task6;

import JAVA_GLk_JC1_29_22.HomeTasks.task6.container.*;
import JAVA_GLk_JC1_29_22.HomeTasks.task6.util.MyRandom;

public class Port {

    private int numMaxShip;
    private int countAddShip;
    private ShipMultiDec[] arrShipMultiDec;

    public Port(int numMaxShip) {

        if (numMaxShip > 0) {

            this.numMaxShip = numMaxShip;
            this.arrShipMultiDec = new ShipMultiDec[numMaxShip];
        } else {
            System.out.println("Введено неверное число кораблей в массиве " + numMaxShip);
            this.arrShipMultiDec = new ShipMultiDec[1];
        }
    }

    private void addShipMultiDec(ShipMultiDec nextShip) {

        if (countAddShip < arrShipMultiDec.length) {
            this.arrShipMultiDec[countAddShip] = nextShip;
            this.countAddShip++;
        } else {
            System.out.print("Новый корабль не может быть добавлен. ");
            System.out.println("Порт заполнен. Максимальное колличество кораблей = " + numMaxShip + "." +
                    " Текущее колличесво кораблей  = " + countAddShip + ".");
        }
    }

    public void addArrShipsMultiDec(ShipMultiDec[] arrShip) {

        for (int i = 0; i < arrShip.length; i++) {
            addShipMultiDec(arrShip[i].myClone());
        }
    }

    public void delShipMultiDec() {

        if (countAddShip > 0) {
            System.out.printf("Корабль -> %s - удален из порта.\n", this.arrShipMultiDec[countAddShip - 1].getName());
            countAddShip--;
        } else {
            System.out.print("Порт - пуст.");
        }
    }

    public void delShipMultiDecByName(String nameSelShip) {

        if (countAddShip > 0) {
            int j = 0;
            ShipMultiDec[] arrBufShipMultiDec = new ShipMultiDec[countAddShip];
            for (int i = 0; i < countAddShip; i++) {
                if (nameSelShip.equals(arrShipMultiDec[i].getName())) {
                    System.out.printf("Корабль №%d -> %s - удален из порта.\n", i + 1, this.arrShipMultiDec[i].getName());
                } else {
                    arrBufShipMultiDec[j] = arrShipMultiDec[i].myClone();
                    j++;
                }
            }

            countAddShip = j;
            for (int p = 0; p < countAddShip; p++) {
                arrShipMultiDec[p] = arrBufShipMultiDec[p];
            }

        } else {
            System.out.print("Порт - пуст.");
        }
    }

    public void delContainerToDeckByNumberInShip(int numShip, int numDeck) {

        if (numShip > 0 && numShip <= countAddShip) {
            arrShipMultiDec[numShip - 1].delContainerToDeckByNumber(numDeck);
        }
    }

    public void delContainersToDeckByNumberInShip(int numShip, int numDeck) {

        if (numShip > 0 && numShip <= countAddShip) {
            arrShipMultiDec[numShip - 1].delAllContainersInDeckByNumber(numDeck);
        }
    }

    public void delAllShipInPort() {

        while (countAddShip != 0) {
            delShipMultiDec();
        }
    }

    public int calculateTotalWeightAllShips() {

        int TotalWeightAllShips = 0;
        int countAllContainer = 0;

        for (int j = 0; j < countAddShip; j++) {
            Deck[] arrDeck = arrShipMultiDec[j].getArrDeck();
            for (Deck nextDec : arrDeck) {
                AbstractContainer[] arrContainer = nextDec.getArrContainers();
                for (int i = 0; i < nextDec.getCountAddContainers(); i++) {
                    //System.out.println(arrContainer[i].getTypeGeometry() + " " + arrContainer[i].getTypeSize()+ " " + arrContainer[i].calculateWeight());
                    countAllContainer++;
                    TotalWeightAllShips = TotalWeightAllShips + arrContainer[i].calculateWeight();
                }
            }
        }
        System.out.printf("\nКораблей в порту %d. Общее число контейнеров на всех кораблях = %d.\n",
                countAddShip, countAllContainer);
        return TotalWeightAllShips;
    }

    public ShipMultiDec[] formingArrQueueShipMultiDeck(int quantityShip, int quantityDeck, int quantityContainer, int typeSizeContainer) {

        ShipMultiDec[] arrQueueInPortShipMultiDec = new ShipMultiDec[quantityShip];

        for (int i = 0; i < arrQueueInPortShipMultiDec.length; i++) {

            arrQueueInPortShipMultiDec[i] = new ShipMultiDec(Const.ARR_NAME_SHIP[i], quantityDeck);
            int quantityDeckToShip = arrQueueInPortShipMultiDec[i].getTypeSizeDeckShip();
            if (quantityDeckToShip == Const.DECK_ONE) {

                Deck[] arrDeckOne = new Deck[quantityDeckToShip];
                arrDeckOne[0] = new Deck(quantityContainer);
                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckOne.clone());

                for (int j = 0; j < quantityContainer; j++) {
                    AbstractContainer nextContainer = createRandomContainer(typeSizeContainer, returnValueRandomHeight(),
                            returnValueRandomDensityWater());
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer);
                }

            } else if (quantityDeckToShip == Const.DECK_TWO) {

                Deck[] arrDeckTwo = new Deck[quantityDeckToShip];
                arrDeckTwo[0] = new Deck(quantityContainer);
                arrDeckTwo[1] = new Deck(quantityContainer);
                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckTwo.clone());

                for (int j = 0; j < quantityContainer; j++) {

                    AbstractContainer nextContainer1 = createRandomContainer(typeSizeContainer, returnValueRandomHeight(),
                            returnValueRandomDensityWater());
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip - 1, nextContainer1);
                    AbstractContainer nextContainer2 = createRandomContainer(typeSizeContainer, returnValueRandomHeight(),
                            returnValueRandomDensityWater());
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer2);
                }

            } else {
                System.out.println("Неизвестный номер Палубы. formingArrQueueShipMultiDeck(4-е пареметра)");
            }
        }
        return arrQueueInPortShipMultiDec;
    }

    public ShipMultiDec[] formingArrQueueShipMultiDeck(int quantityShip) {

        ShipMultiDec[] arrQueueInPortShipMultiDec = new ShipMultiDec[quantityShip];

        for (int i = 0; i < arrQueueInPortShipMultiDec.length; i++) {
            arrQueueInPortShipMultiDec[i] = new ShipMultiDec(Const.ARR_NAME_SHIP[i], returnValueRandomQuantityDeckToShip());

            int quantityDeckToShip = arrQueueInPortShipMultiDec[i].getTypeSizeDeckShip();
            if (quantityDeckToShip == Const.DECK_ONE) {

                int quantityContainer = returnValueRandomQuantityContainerInDeck();
                Deck[] arrDeckOne = new Deck[quantityDeckToShip];
                arrDeckOne[0] = new Deck(quantityContainer);
                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckOne.clone());

                for (int j = 0; j < quantityContainer; j++) {

                    AbstractContainer nextContainer = createRandomContainer(returnValueRandomTypeSizeContainer(),
                            returnValueRandomHeight(), returnValueRandomDensityWater());
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer);
                }

            } else if (quantityDeckToShip == Const.DECK_TWO) {

                int quantityContainer = returnValueRandomQuantityContainerInDeck();
                Deck[] arrDeckTwo = new Deck[quantityDeckToShip];
                arrDeckTwo[0] = new Deck(quantityContainer);
                arrDeckTwo[1] = new Deck(quantityContainer);
                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckTwo.clone());

                for (int j = 0; j < quantityContainer; j++) {

                    AbstractContainer nextContainer1 = createRandomContainer(returnValueRandomTypeSizeContainer(),
                            returnValueRandomHeight(), returnValueRandomDensityWater());
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip - 1, nextContainer1);
                    AbstractContainer nextContainer2 = createRandomContainer(returnValueRandomTypeSizeContainer(),
                            returnValueRandomHeight(), returnValueRandomDensityWater());
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer2);
                }
            } else {
                System.out.println("Неизвестный номер Палубы. formingArrQueueShipMultiDeck(int quantityShip)");
            }
        }
        return arrQueueInPortShipMultiDec;
    }

    public void printAllContainerToPort() {

        for (int i = 0; i < countAddShip; i++) {
            arrShipMultiDec[i].printDataContainerOnAllDeck();
        }
    }

    private int returnValueRandomTypeSizeContainer() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if (num == 0 || num == 2) {
            return Const.TYPE_SIZE_LITTLE_CONTAINER;
        }
        return Const.TYPE_SIZE_BIG_CONTAINER;
    }

    private int returnValueRandomQuantityDeckToShip() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if (num == 0 || num == 2) {
            return Const.DECK_ONE;
        }
        return Const.DECK_TWO;
    }

    private int returnValueRandomQuantityContainerInDeck() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if (num == 0 || num == 2) {
            return Const.LITTLE_MAX_NO_BIG;
        }
        return Const.BIG_MAX_NO_LITTLE;
    }

    private int returnValueRandomDensityWater() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if (num == 0 || num == 2) {
            return Const.DENSITY_WATER1;
        }
        return Const.DENSITY_WATER2;
    }

    private int returnValueRandomHeight() {
        return MyRandom.nextRandomIntValueRange(Const.HEIGHT_MIN, Const.HEIGHT_MAX);
    }

    private void changeDataContainer(AbstractContainer container) {

        container.setTypeSize(returnValueRandomTypeSizeContainer());
        container.setHeight(returnValueRandomHeight());
        container.setDensityWater(returnValueRandomDensityWater());
    }

    private AbstractContainer createRandomContainer(int typeSize, int height, int densityWater) {

        int num = MyRandom.nextRandomIntValueRange(5);
        if (num == 0 || num == 2) {
            return new CubeContainer(typeSize, densityWater);
        } else if (num == 1 || num == 3) {
            return new CylinderContainer(typeSize, height, densityWater);
        } else {
            return new ConeContainer(typeSize, height, densityWater);
        }
    }
}
