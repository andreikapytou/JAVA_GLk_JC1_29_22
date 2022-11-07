package JAVA_GLk_JC1_29_22.HomeTasks.task6;

import JAVA_GLk_JC1_29_22.HomeTasks.task6.container.AbstractContainer;

public class ShipMultiDec {

    private String name;

    private int numMaxDeck;

    private Deck[] arrDeck;

    public ShipMultiDec(String name, int numMaxDeck) { // Конструктор

        if (numMaxDeck > 0) {

            this.name = name;
            this.numMaxDeck = numMaxDeck;
            this.arrDeck = new Deck[numMaxDeck];

        } else {
            System.out.println("Введено неверное число-колличесво палуб в масиве. " + numMaxDeck);
            this.arrDeck = new Deck[Const.DECK_ONE];
        }
    }

    public ShipMultiDec myClone()
    {
        ShipMultiDec cloneDeck = new ShipMultiDec(this.name, this.numMaxDeck);
        cloneDeck.name = this.name;
        cloneDeck.numMaxDeck = this.numMaxDeck;
        cloneDeck.arrDeck = this.arrDeck.clone();

        return cloneDeck;
    }
    
    public int getTypeSizeDeckShip() {
        return numMaxDeck;
    }

    public void addArrContainersToDeckByNumber(int numDeck, AbstractContainer[] arrContainers) {
        if ( numDeck > 0 && numDeck <= getTypeSizeDeckShip()) {
            arrDeck[numDeck-1].addArrContainers(arrContainers);
        } else {
            printUnknownNumDeck(numDeck);
        }
    }

    public void addContainerToDeckByNumber(int numDeck, AbstractContainer container) {

        if ( numDeck > 0 && numDeck <= getTypeSizeDeckShip()) {
            arrDeck[numDeck-1].addContainer(container);
        } else {
            printUnknownNumDeck(numDeck);
        }
    }

    public void delAllContainersInDeckByNumber(int numDeck) {

        if ( numDeck >0 && numDeck <= getTypeSizeDeckShip()) {
            arrDeck[numDeck-1].delAllContainersInDeck();
        } else {
            printUnknownNumDeck(numDeck);
        }
    }

    public void delContainerToDeckByNumber(int numDeck) {

        System.out.println(" !!!! Палуб на корабле " + getTypeSizeDeckShip() );
        if ( numDeck >0 && numDeck <= getTypeSizeDeckShip()) {
            arrDeck[numDeck-1].delContainer();
        } else {
            printUnknownNumDeck(numDeck);
        }
    }

    public void printDataContainerToDeckByNumber(int numDeck) {

        if ( numDeck >0 && numDeck <= getTypeSizeDeckShip()) {
            System.out.printf("Палуба № %d. ", numDeck);
            arrDeck[numDeck-1].printCurrentArrContainers();
        } else {
            printUnknownNumDeck(numDeck);
        }
    }

    public void printDataContainerOnAllDeck() {

        System.out.printf("\nИмя Корабля = %s. Число палуб на корабле = %d.\n", name, getTypeSizeDeckShip());
        for (int i=0; i<arrDeck.length; i++) {
            System.out.printf("Палуба № %d. ", i+1);
            arrDeck[i].printCurrentArrContainers();
        }
    }

    private void printUnknownNumDeck(int numDeck) {
        System.out.printf("Ошибка - Неизвестная палуба № %d. У корабля c именем = %s колличество палуб = %d \n",
                numDeck, getName(), getTypeSizeDeckShip());
    }

    public Deck getDeckByNumber(int numDeck) {

        if ( numDeck >0 && numDeck <= getTypeSizeDeckShip()) {
            return arrDeck[numDeck-1];
        }else {
            printUnknownNumDeck(numDeck);
            return new Deck(1);
        }
    }
  
    public void setDeckByNumber(int numDeck, Deck deck) {
        if ( numDeck >0 && numDeck <= getTypeSizeDeckShip()) {
             this.arrDeck[numDeck-1] = deck;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck[] getArrDeck() {
        return arrDeck;
    }

    public void setArrDeck(Deck[] arrDeck) {
        this.arrDeck = arrDeck;
    }
}
