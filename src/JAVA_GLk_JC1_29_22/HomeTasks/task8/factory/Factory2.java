package JAVA_GLk_JC1_29_22.HomeTasks.task8.factory;

import JAVA_GLk_JC1_29_22.HomeTasks.task8.bodies.Body;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.heads.*;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.robots.*;

public class Factory2 extends Factory implements HeadProd {

    public  Head[] createHeads() {

        Head[] arrHeads = new Head[HeadType.values().length];
        HeadType[] arrHeadsTypes = HeadType.values();

        if(arrHeads.length == arrHeadsTypes.length  ) {

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

    public void startConveyorProduction(Body[] arrBodies){

        Robot[][] arrMatrixRobots = createMatrixRobots(factoryType, createHeads(), arrBodies);
        printMatrixRobots(arrMatrixRobots);
    }

    public Factory2() {
        this.factoryType = FactoryType.FACTORY2;
    }
}
