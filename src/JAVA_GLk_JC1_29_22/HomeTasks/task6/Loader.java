package JAVA_GLk_JC1_29_22.HomeTasks.task6;

public class Loader {
    
    public static void Start() {

        Port port = new Port(Const.SHIP_MAX_IN_PORT);

        ShipMultiDec[] arrQueueShips = port.formingArrQueueShipMultiDeck(Const.SHIP_MAX_IN_PORT,2, 2,2);
        port.addArrShipsMultiDec(arrQueueShips.clone());
        System.out.printf("Общая масса груза-воды которую привоязт все корабли = %d\n", port.calculateTotalWeightAllShips());
        port.printAllContainerToPort();

        System.out.println();
        port.delAllShipInPort();
        arrQueueShips = port.formingArrQueueShipMultiDeck(Const.SHIP_MAX_IN_PORT,1, 4,1);
        port.addArrShipsMultiDec(arrQueueShips.clone());
        System.out.printf("Общая масса груза-воды которую привоязт все корабли = %d\n", port.calculateTotalWeightAllShips());
        port.printAllContainerToPort();

        System.out.println();
        port.delShipMultiDec();
        System.out.printf("Общая масса груза-воды которую привоязт все корабли = %d\n", port.calculateTotalWeightAllShips());

        System.out.println();
        port.delContainersToDeckByNumberInShip(4, 1);
        System.out.printf("Общая масса груза-воды которую привоязт все корабли = %d\n", port.calculateTotalWeightAllShips());

        System.out.println();
        port.delAllShipInPort();
        arrQueueShips = port.formingArrQueueShipMultiDeck(6);
        port.addArrShipsMultiDec(arrQueueShips.clone());
        System.out.printf("Общая масса груза-воды которую привоязт все корабли = %d\n", port.calculateTotalWeightAllShips());
        port.printAllContainerToPort();
    }
    
}
