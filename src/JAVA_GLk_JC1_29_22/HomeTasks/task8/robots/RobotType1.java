package JAVA_GLk_JC1_29_22.HomeTasks.task8.robots;

import JAVA_GLk_JC1_29_22.HomeTasks.task8.bodies.Body;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.heads.Head;

public class RobotType1 extends Robot {

    @Override
    public void on() {

        System.out.println("Робот Тип1 Включен.");
    }

    @Override
    public void off() {

        System.out.println("Робот Тип1 Отключен.");
    }

    public RobotType1(String name, Head head, Body body) {

        super(name, head, body);
        super.robotsType = RobotsType.TYPE1;
    }
}
