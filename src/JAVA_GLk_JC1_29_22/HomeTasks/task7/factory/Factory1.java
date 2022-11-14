package JAVA_GLk_JC1_29_22.HomeTasks.task7.factory;

import JAVA_GLk_JC1_29_22.HomeTasks.task7.bodies.*;
import JAVA_GLk_JC1_29_22.HomeTasks.task7.heads.Head;
import JAVA_GLk_JC1_29_22.HomeTasks.task7.robots.*;

public class Factory1 extends Factory implements BodyProd {

    public  Body[] createBodies() {

        Body[] arrBodies = new Body[BodyType.values().length];
        BodyType[] arrBodiesTypes = BodyType.values();

        if(arrBodies.length == arrBodiesTypes.length  ) {

            for (int i = 0; i < arrBodiesTypes.length; i++) {
                if (arrBodiesTypes[i] == BodyType.BODY1) {
                    arrBodies[i] = new Body1();
                } else if (arrBodiesTypes[i] == BodyType.BODY2) {
                    arrBodies[i] = new Body2();
                } else if (arrBodiesTypes[i] == BodyType.BODY3) {
                    arrBodies[i] = new Body3();
                }
            }
        } else {
            System.out.println("Ошибка - разные размерности массивов. Тела и Типа тела.");
        }
        return arrBodies;
    }

    public void startConveyorProduction(Head[] arrHeads){

        Robot[][] arrMatrixRobots = createMatrixRobots(factoryType, arrHeads, createBodies());
        printMatrixRobots(arrMatrixRobots);
    }

    public Factory1() {
        this.factoryType = FactoryType.FACTORY1;
    }
}
