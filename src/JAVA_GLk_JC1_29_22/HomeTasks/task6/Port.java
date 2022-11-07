package JAVA_GLk_JC1_29_22.HomeTasks.task6;

import JAVA_GLk_JC1_29_22.HomeTasks.task6.container.*;
import JAVA_GLk_JC1_29_22.HomeTasks.task6.util.MyRandom;

public class Port {

    private int numMaxShip;
    private int countAddShip;
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

    private void addShipMultiDec(ShipMultiDec nextShip) {

        if( countAddShip <  arrShipMultiDec.length  ) {
            this.arrShipMultiDec[countAddShip] = nextShip;
            this.countAddShip++;
        } else {
            System.out.print("Новый корабль не может быть добавлен. ");
            System.out.println("Порт заполнен. Максимальное колличество кораблей = " + numMaxShip +"."+
                                " Текущее колличесво кораблей  = " + countAddShip +".");
        }
    }

    public void addArrShipsMultiDec(ShipMultiDec[] arrShip) {

        for(int i=0; i<arrShip.length; i++ ){
            addShipMultiDec(arrShip[i].myClone());
        }
    }

    public void delShipMultiDec() {

        if (countAddShip > 0) {
            System.out.printf("Корабль -> %s - удален из порта.\n", this.arrShipMultiDec[countAddShip-1].getName());
            countAddShip--;
        } else {
            System.out.print("Порт - пуст.");
        }
    }

    public void delContainerToDeckByNumberInShip(int numShip, int numDeck) {

        if( numShip >0 && numShip <= countAddShip ) {
            arrShipMultiDec[numShip-1].delContainerToDeckByNumber(numDeck);
        }
    }

    public void delContainersToDeckByNumberInShip(int numShip, int numDeck) {

        if( numShip >0 && numShip <= countAddShip ) {
            arrShipMultiDec[numShip-1].delAllContainersInDeckByNumber(numDeck);
        }
    }

    public void delAllShipInPort( ){

        while(countAddShip != 0 ) {
            delShipMultiDec();
        }
    }

    public int calculateTotalWeightAllShips(){

        int TotalWeightAllShips = 0;
        int countAllContainer = 0;

        for (int j=0; j<countAddShip; j++) {
            Deck[] arrDeck = arrShipMultiDec[j].getArrDeck();
            for(Deck nextDec : arrDeck){
                AbstractContainer[] arrContainer = nextDec.getArrContainers();
                for (int i=0; i<nextDec.getCountAddContainers(); i++ ) {
                    //System.out.println(arrContainer[i].getTypeGeometry() + " " + arrContainer[i].getTypeSize()+ " " + arrContainer[i].calculateWeight());
                    countAllContainer++;
                    TotalWeightAllShips = TotalWeightAllShips + arrContainer[i].calculateWeight();
                }
            }
        }
        System.out.printf("Кораблей в порту %d. Общее число контейнеров на всех кораблях = %d. Общая масса груза-воды = %d\n",
                            countAddShip, countAllContainer,  TotalWeightAllShips);
        return TotalWeightAllShips;
    }

    public  ShipMultiDec[] formingArrQueueShipMultiDeck(int quantityShip, int quantityDeck, int quantityContainer, int typeSizeContainer ){

        System.out.println("\n++++++++++++++++++ СТАРТ formingArrQueueShipMultiDeck() +++++++ \n ");

        String[] arrNamesShip = {"Корабль1", "Корабль2", "Корабль3", "Корабль4", "Корабль5"};
        ShipMultiDec[] arrQueueInPortShipMultiDec = new ShipMultiDec[quantityShip];

        for(int i=0; i<arrQueueInPortShipMultiDec.length; i++ ){
            //arrQueueInPortShipMultiDec[i] = new ShipMultiDec(arrNamesShip[i] , getValueRandomQuantityDeckToShip());
            arrQueueInPortShipMultiDec[i] = new ShipMultiDec(arrNamesShip[i] , quantityDeck);

            int quantityDeckToShip = arrQueueInPortShipMultiDec[i].getTypeSizeDeckShip();
            if(quantityDeckToShip == Const.DECK_ONE) {

                Deck[] arrDeckOne = new Deck[quantityDeckToShip];
                //arrDeckOne[0] = new Deck(5);
                arrDeckOne[0] = new Deck(quantityContainer);
                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckOne.clone());

                for (int j=0; j<quantityContainer; j++) {

                    int sizeContainer = getValueRandomTypeSizeContainer();
                    int height = getValueRandomHeight();
                    int densityWater = getValueRandomDensityWater();
                    //AbstractContainer nextContainer = createRandomContainer(sizeContainer, height, densityWater);
                    AbstractContainer nextContainer = createRandomContainer(typeSizeContainer, height, densityWater);
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer);
                }

            } else if (quantityDeckToShip == Const.DECK_TWO ) {

                Deck[] arrDeckTwo = new Deck[quantityDeckToShip];
                //arrDeckTwo[0] = new Deck(5);
                //arrDeckTwo[1] = new Deck(4);
                arrDeckTwo[0] = new Deck(quantityContainer);
                arrDeckTwo[1] = new Deck(quantityContainer);

                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckTwo.clone());

                for (int j=0; j<quantityContainer; j++) {

                    int sizeContainer1 = getValueRandomTypeSizeContainer();
                    int height1 = getValueRandomHeight();
                    int densityWater1 = getValueRandomDensityWater();
                    //AbstractContainer nextContainer1 = createRandomContainer(sizeContainer1, height1, densityWater1);
                    AbstractContainer nextContainer1 = createRandomContainer(typeSizeContainer, height1, densityWater1);
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip - 1, nextContainer1);

                    int sizeContainer2 = getValueRandomTypeSizeContainer();
                    int height2 = getValueRandomHeight();
                    int densityWater2 = getValueRandomDensityWater();
                    //AbstractContainer nextContainer2 = createRandomContainer(sizeContainer2, height2, densityWater2);
                    AbstractContainer nextContainer2 = createRandomContainer(typeSizeContainer, height2, densityWater2);
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer2);
                }

            } else {
                System.out.println("!!!!! Неизвестный номер Палубы");
            }
        }
        System.out.println("\n++++++++++++++++++ ФИНИШ formingArrQueueShipMultiDeck() +++++++ \n ");
        return arrQueueInPortShipMultiDec;
    }

    public  ShipMultiDec[] formingArrQueueShipMultiDeck( int quantityShip ){

        System.out.println("\n++++++++++++++++++ СТАРТ Без параметров formingArrQueueShipMultiDeck() +++++++ \n ");

        String[] arrNamesShip = {"Корабль1", "Корабль2", "Корабль3", "Корабль4", "Корабль5",
                                 "Корабль6", "Корабль7", "Корабль8", "Корабль9", "Корабль10"};
        ShipMultiDec[] arrQueueInPortShipMultiDec = new ShipMultiDec[quantityShip];

        for(int i=0; i<arrQueueInPortShipMultiDec.length; i++ ){
            arrQueueInPortShipMultiDec[i] = new ShipMultiDec(arrNamesShip[i] , getValueRandomQuantityDeckToShip());

            int quantityDeckToShip = arrQueueInPortShipMultiDec[i].getTypeSizeDeckShip();
            if(quantityDeckToShip == Const.DECK_ONE) {

                int quantityContainer = getValueRandomQuantityContainerInDeck();
                Deck[] arrDeckOne = new Deck[quantityDeckToShip];
                arrDeckOne[0] = new Deck(quantityContainer);
                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckOne.clone());

                for (int j=0; j<quantityContainer; j++) {

                    int sizeContainer = getValueRandomTypeSizeContainer();
                    int height = getValueRandomHeight();
                    int densityWater = getValueRandomDensityWater();
                    AbstractContainer nextContainer = createRandomContainer(sizeContainer, height, densityWater);
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer);
                }

            } else if (quantityDeckToShip == Const.DECK_TWO ) {

                int quantityContainer = getValueRandomQuantityContainerInDeck();
                Deck[] arrDeckTwo = new Deck[quantityDeckToShip];
                arrDeckTwo[0] = new Deck(quantityContainer);
                arrDeckTwo[1] = new Deck(quantityContainer);

                arrQueueInPortShipMultiDec[i].setArrDeck(arrDeckTwo.clone());

                for (int j=0; j<quantityContainer; j++) {

                    int sizeContainer1 = getValueRandomTypeSizeContainer();
                    int height1 = getValueRandomHeight();
                    int densityWater1 = getValueRandomDensityWater();
                    AbstractContainer nextContainer1 = createRandomContainer(sizeContainer1, height1, densityWater1);
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip - 1, nextContainer1);

                    int sizeContainer2 = getValueRandomTypeSizeContainer();
                    int height2 = getValueRandomHeight();
                    int densityWater2 = getValueRandomDensityWater();
                    AbstractContainer nextContainer2 = createRandomContainer(sizeContainer2, height2, densityWater2);
                    arrQueueInPortShipMultiDec[i].addContainerToDeckByNumber(quantityDeckToShip, nextContainer2);
                }

            } else {
                System.out.println("!!!!! Неизвестный номер Палубы");
            }
        }
        System.out.println("\n++++++++++++++++++ ФИНИШ Без параметров formingArrQueueShipMultiDeck() +++++++ \n ");
        return arrQueueInPortShipMultiDec;
    }

    public void printAllContainerToPort() {

        System.out.println();
        for (int i=0; i<countAddShip; i++) {
            arrShipMultiDec[i].printDataContainerOnAllDeck();
        }
    }

    private int getValueRandomTypeSizeContainer() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.TYPE_SIZE_LITTLE_CONTAINER;
        }
        return Const.TYPE_SIZE_BIG_CONTAINER;
    }

    private int getValueRandomQuantityDeckToShip() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.DECK_ONE;
        }
        return Const.DECK_TWO;
    }

    private int getValueRandomQuantityContainerInDeck() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.LITTLE_MAX_NO_BIG;
        }
        return Const.BIG_MAX_NO_LITTLE;
    }

    private int getValueRandomDensityWater() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.DENSITY_WATER1;
        }
        return Const.DENSITY_WATER2;
    }


    private int getValueRandomHeight() {
        return MyRandom.nextRandomIntValueRange(Const.HEIGHT_MIN, Const.HEIGHT_MAX);
    }

    private void changeDataContainer(AbstractContainer container){

        container.setTypeSize(getValueRandomTypeSizeContainer());
        container.setHeight(getValueRandomHeight());
        container.setDensityWater(getValueRandomDensityWater());
    }
    private AbstractContainer createRandomContainer(int typeSize, int height, int densityWater){

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
