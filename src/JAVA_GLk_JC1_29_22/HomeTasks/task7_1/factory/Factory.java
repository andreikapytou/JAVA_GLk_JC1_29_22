package JAVA_GLk_JC1_29_22.HomeTasks.task7_1.factory;

import JAVA_GLk_JC1_29_22.HomeTasks.task7_1.*;
import JAVA_GLk_JC1_29_22.HomeTasks.task7_1.heads.*;

public class Factory {

    protected FactoryType factoryType;

    public Robot[] createArrRobots(FactoryType factoryType, Head[] arrHeads, BodyType[] arrBodies) {

        Robot[] arrRobots = new Robot[arrHeads.length * arrBodies.length];
        int j = 0;
        for (int h = 0; h < arrHeads.length; h++) {
            for (int b = 0; b < arrBodies.length; b++) {
                if (factoryType == FactoryType.F_BODIES) {
                    arrRobots[j] = new Robot(Cons.NAMES_ROBOTS1[j], arrHeads[h], arrBodies[b]);
                } else {
                    arrRobots[j] = new Robot(Cons.NAMES_ROBOTS2[j], arrHeads[h], arrBodies[b]);
                }
                arrRobots[j].setFactoryType(factoryType);
                j++;
            }
        }
        return arrRobots;
    }

    public BodyType[] createBodies(FactoryType factoryType) {

        BodyType[] bodyForFactoryHead = new BodyType[BodyType.values().length];
        if (factoryType == FactoryType.F_HEADS) {
            bodyForFactoryHead[0] = BodyType.BODY3;
            bodyForFactoryHead[1] = BodyType.BODY2;
            bodyForFactoryHead[2] = BodyType.BODY1;
        } else {
            System.out.println("Неверный тип Завода.");
        }
        return bodyForFactoryHead;
    }

    public BodyType[] createBodies() {
        return BodyType.values();
    }

    public Head[] createHeads() {

        Head[] arrHeads = new Head[HeadType.values().length];
        HeadType[] arrHeadsTypes = HeadType.values();

        if (arrHeads.length == arrHeadsTypes.length) {

            for (int i = 0; i < arrHeadsTypes.length; i++) {
                if (arrHeadsTypes[i] == HeadType.HEAD1) {
                    arrHeads[i] = new Head1();
                } else if (arrHeadsTypes[i] == HeadType.HEAD2) {
                    arrHeads[i] = new Head2();
                } else if (arrHeadsTypes[i] == HeadType.HEAD3) {
                    arrHeads[i] = new Head3();
                }
            }
        } else {
            System.out.println("Ошибка - разные размерности массивов. Головы и Типа головы.");
        }
        return arrHeads;
    }

    public Robot[] startConveyorProduction(BodyType[] arrBodies) {

        return createArrRobots(factoryType, createHeads(), arrBodies);
    }

    public Robot[] startConveyorProduction(Head[] arrHeads) {

        return createArrRobots(factoryType, arrHeads, createBodies());
    }

    public Factory(FactoryType factoryType) {
        this.factoryType = factoryType;
    }
}
