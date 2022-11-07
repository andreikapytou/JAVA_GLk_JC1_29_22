package JAVA_GLk_JC1_29_22.HomeTasks.task6;


/**
 * Класс Runner.
 * В данном класе реализован метод main().
 * Метод main() - "главный метод", котрый является точка входа приложения-программы.
 * C запуска-вызова этого метода начинается запуск-управление всего приложения-программы задачи №5.
 *
 * @author Andrei Kapytou (Андрей Копытов)
 * @version 1.0
 */
public class Runner {

    /*
    public static int valueTypeSizeContainer() {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.TYPE_SIZE_LITTLE_CONTAINER;
        }
        return Const.TYPE_SIZE_BIG_CONTAINER;
    }

    public static int valueDensityWater () {

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return Const.DENSITY_WATER1;
        }
        return Const.DENSITY_WATER2;
    }

    public static int valueHeight () {
        return MyRandom.nextRandomIntValueRange(Const.HEIGHT_MIN, Const.HEIGHT_MAX);
    }

    public static void changeDataContainer(AbstractContainer container){

        container.setTypeSize(valueTypeSizeContainer());
        container.setHeight(valueHeight());
        container.setDensityWater(valueDensityWater());
    }
    public static AbstractContainer createRandomContainer(int typeSize, int height, int densityWater){

        int num = MyRandom.nextRandomIntValueRange(5);
        if(num == 0 || num == 2 ){
            return new CubeContainer(typeSize, densityWater);
        } else if (num == 1 || num == 3  ) {
            return new CylinderContainer(typeSize,height, densityWater);
        } else {
            return new ConeContainer(typeSize, height, densityWater);
        }
    }


     */
    public static void main(String[] args) { /* Заголовок метода */

        Port port = new Port(5);

        ShipMultiDec[] arrQueueShips = port.formingArrQueueShipMultiDeck(5,2, 2,2);;
        port.addArrShipsMultiDec(arrQueueShips.clone());
        int TotalWeight = port.calculateTotalWeightAllShips();
        port.printAllContainerToPort();

        System.out.println();
        port.delAllShipInPort();
        arrQueueShips = port.formingArrQueueShipMultiDeck(5,1, 4,1);
        port.addArrShipsMultiDec(arrQueueShips.clone());
        TotalWeight = port.calculateTotalWeightAllShips();
        port.printAllContainerToPort();

        System.out.println();
        port.delAllShipInPort();
        arrQueueShips = port.formingArrQueueShipMultiDeck(5,2, 4,1);
        port.addArrShipsMultiDec(arrQueueShips.clone());
        TotalWeight = port.calculateTotalWeightAllShips();
        port.printAllContainerToPort();
        System.out.println();

        port.delShipMultiDec();
        TotalWeight = port.calculateTotalWeightAllShips();
        port.printAllContainerToPort();
        System.out.println();

        port.delContainerToDeckByNumberInShip(4, 2);
        port.delContainerToDeckByNumberInShip(4, 2);
        TotalWeight = port.calculateTotalWeightAllShips();
        port.printAllContainerToPort();
        System.out.println();

        port.delContainersToDeckByNumberInShip(4, 1);
        TotalWeight = port.calculateTotalWeightAllShips();
        port.printAllContainerToPort();


        /*
        ShipMultiDec[]  arrShipsMultiDec = new ShipMultiDec[2];


        ShipMultiDec oneDeckShip = new ShipMultiDec("Варяг", Const.DECK_ONE);
        ShipMultiDec twoDeckShip = new ShipMultiDec("Петр_Первый", Const.DECK_TWO);
        Deck deck1 = new Deck(4);
        Deck deck2 = new Deck(5);

        AbstractContainer[] arrLittleContainers = new AbstractContainer[Const.LITTLE_MAX_NO_BIG + 1];
        AbstractContainer[] arrBigContainers = new AbstractContainer[Const.BIG_MAX_NO_LITTLE + 1];

        System.out.println("\nДо_удаления");
        for (int i = 0; i < arrLittleContainers.length; i++) {
            arrLittleContainers[i] = createRandomContainer(Const.TYPE_SIZE_LITTLE_CONTAINER, Const.HEIGHT_MIN, Const.DENSITY_WATER1);
            deck1.addContainer(arrLittleContainers[i]);
        }

        for (int i = 0; i < arrBigContainers.length; i++) {
            arrBigContainers[i] = createRandomContainer(Const.TYPE_SIZE_BIG_CONTAINER, Const.HEIGHT_MAX, Const.DENSITY_WATER1);
            deck2.addContainer(arrBigContainers[i]);
        }

        oneDeckShip.setDeckByNumber(Const.DECK_ONE, deck1);

        twoDeckShip.setDeckByNumber(Const.DECK_ONE, deck2);
        twoDeckShip.setDeckByNumber(Const.DECK_TWO, deck1.myClone());

        for (int i = 0; i < arrBigContainers.length; i++) {
            arrBigContainers[i] = createRandomContainer(Const.TYPE_SIZE_BIG_CONTAINER, 10, Const.DENSITY_WATER2);
        }

        oneDeckShip.addContainerToDeckByNumber(Const.DECK_ONE,arrBigContainers[1]);
        oneDeckShip.addContainerToDeckByNumber(Const.DECK_ONE,arrBigContainers[1]);
        oneDeckShip.delContainerToDeckByNumber(Const.DECK_ONE);
        oneDeckShip.delContainerToDeckByNumber(Const.DECK_ONE);
        oneDeckShip.addContainerToDeckByNumber(Const.DECK_ONE +2,arrBigContainers[1]);
        oneDeckShip.printDataContainerToDeckByNumber(Const.DECK_ONE);

        System.out.println("\n*****Перед удалением всех контейнеров");
        oneDeckShip.delAllContainersInDeckByNumber(Const.DECK_ONE);
        oneDeckShip.addArrContainersToDeckByNumber(Const.DECK_ONE, arrBigContainers);

        arrShipsMultiDec[0] = oneDeckShip;
        arrShipsMultiDec[1] = twoDeckShip;


        arrShipsMultiDec[0].printDataContainerToDeckByNumber(1);

        arrShipsMultiDec[1].printDataContainerOnAllDeck();

        /*
        System.out.println();
        System.out.println("DELLL");
        deck.deleteContainer();

        System.out.println("\nchangeDataContainer()");
        for (AbstractContainer nextContainer : arrLittleContainers) {
                changeDataContainer(nextContainer);
                deck.addContainer(nextContainer);
        }

         */
    }
}

