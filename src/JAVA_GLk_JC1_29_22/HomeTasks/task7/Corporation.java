package JAVA_GLk_JC1_29_22.HomeTasks.task7;

import JAVA_GLk_JC1_29_22.HomeTasks.task7.factory.*;

public class Corporation {

    private Corporation() {

    }

    public static void startProduction() {

        Factory1 factory1 = new Factory1();
        Factory2 factory2 = new Factory2();

        System.out.println();
        factory1.startConveyorProduction(factory2.createHeads());
        factory2.startConveyorProduction(factory1.createBodies());
    }
}
