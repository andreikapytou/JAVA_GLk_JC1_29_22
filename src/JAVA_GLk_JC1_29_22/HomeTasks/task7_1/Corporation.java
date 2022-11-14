package JAVA_GLk_JC1_29_22.HomeTasks.task7_1;

import JAVA_GLk_JC1_29_22.HomeTasks.task7_1.factory.*;

public class Corporation {

    private Corporation() {

    }

    public static void startProduction() {

        Factory factoryBodies = new Factory(FactoryType.F_BODIES);
        Factory factoryHeads = new Factory(FactoryType.F_HEADS);

        System.out.println();
        Robot[] robotsFromFactoryBodies = factoryBodies.startConveyorProduction(factoryHeads.createHeads());
        printArrRobots(robotsFromFactoryBodies);
        Robot[] robotsFromFactoryHeads = factoryHeads.startConveyorProduction(factoryBodies.createBodies(FactoryType.F_HEADS));
        printArrRobots(robotsFromFactoryHeads);

        robotsFromFactoryBodies[0].on();
        robotsFromFactoryBodies[0].testingAfterActivation();
        robotsFromFactoryBodies[0].off();
        robotsFromFactoryBodies[0].testingAfterActivation();
        robotsFromFactoryBodies[1].on();
        robotsFromFactoryBodies[1].testingAfterActivation();
    }

    public static void printArrRobots(Robot[] arrRobots) {

        for (Robot nextRobot : arrRobots) {
            System.out.println(nextRobot);
        }
        System.out.println();
    }
}
