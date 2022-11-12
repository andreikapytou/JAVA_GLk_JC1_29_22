package JAVA_GLk_JC1_29_22.HomeTasks.task8.factory;

import JAVA_GLk_JC1_29_22.HomeTasks.task8.Cons;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.bodies.Body;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.heads.Head;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.robots.*;

public abstract class Factory {

    protected FactoryType factoryType;

    public Robot[][] createMatrixRobots(FactoryType factoryType, Head[] arrHeads, Body[] arrBodies) {

        RobotsType[] arrRobotsTypes = RobotsType.values();
        Robot[][] arrMatrixRobots = new  Robot[arrRobotsTypes.length][arrHeads.length * arrBodies.length];

        for(int i=0; i<arrMatrixRobots.length; i++ ){
            if(arrRobotsTypes[i] == RobotsType.TYPE1) {
                Robot[] arrRobotsTape1 = createArrRobotsType1(factoryType, arrHeads, arrBodies);
                for(int j=0; j<arrMatrixRobots[i].length; j++) {
                    arrMatrixRobots[i][j] = arrRobotsTape1[j];
                }
            } else if (arrRobotsTypes[i] == RobotsType.TYPE2) {
                Robot[] arrRobotsTape2 = createArrRobotsType2(factoryType, arrHeads, arrBodies);
                for(int j=0; j<arrMatrixRobots[i].length; j++) {
                    arrMatrixRobots[i][j] = arrRobotsTape2[j];
                }
            }
            else if (arrRobotsTypes[i] == RobotsType.TYPE3) {
                Robot[] arrRobotsTape3 = createArrRobotsType3(factoryType, arrHeads, arrBodies);
                for(int j=0; j<arrMatrixRobots[i].length; j++) {
                    arrMatrixRobots[i][j] = arrRobotsTape3[j];
                }
            }
        }
        return arrMatrixRobots;
    }

    public Robot[] createArrRobotsType1(FactoryType factoryType, Head[] arrHeads, Body[] arrBodies) {

        Robot[] arrRobots = new Robot[arrHeads.length * arrBodies.length];
        int j=0;
        for(int h=0; h<arrHeads.length; h++) {
            for(int b=0; b<arrBodies.length; b++) {
                arrRobots[j] = new RobotType1(Cons.NAMES_ROBOTS1[j], arrHeads[h], arrBodies[b]);
                arrRobots[j].setFactoryType(factoryType);
                j++;
            }
        }
        return arrRobots;
    }

    public Robot[] createArrRobotsType2(FactoryType factoryType, Head[] arrHeads, Body[] arrBodies) {

        Robot[] arrRobots = new Robot[arrHeads.length * arrBodies.length];
        int j=0;
        for(int h=0; h<arrHeads.length; h++) {
            for(int b=0; b<arrBodies.length; b++) {
                arrRobots[j] = new RobotType2(Cons.NAMES_ROBOTS2[j], arrHeads[h], arrBodies[b]);
                arrRobots[j].setFactoryType(factoryType);
                j++;
            }
        }
        return arrRobots;
    }

    public Robot[] createArrRobotsType3(FactoryType factoryType, Head[] arrHeads, Body[] arrBodies) {

        Robot[] arrRobots = new Robot[arrHeads.length * arrBodies.length];
        int j=0;
        for(int h=0; h<arrHeads.length; h++) {
            for(int b=0; b<arrBodies.length; b++) {
                arrRobots[j] = new RobotType3(Cons.NAMES_ROBOTS3[j], arrHeads[h], arrBodies[b]);
                arrRobots[j].setFactoryType(factoryType);
                j++;
            }
        }
        return arrRobots;
    }

    public void printArrRobots(Robot[] arrRobots) {

        for(Robot nextRobot : arrRobots ) {
            System.out.println(nextRobot);
        }
        System.out.println();
    }

    public void printMatrixRobots(Robot[][] matrixRobots) {

        for(int i=0; i< matrixRobots.length; i++) {
            printArrRobots(matrixRobots[i].clone());
        }
        System.out.println();
    }

    public Factory(){

    }
}
