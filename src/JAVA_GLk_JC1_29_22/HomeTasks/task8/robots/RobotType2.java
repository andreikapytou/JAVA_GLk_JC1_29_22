package JAVA_GLk_JC1_29_22.HomeTasks.task8.robots;

import JAVA_GLk_JC1_29_22.HomeTasks.task8.bodies.Body;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.heads.Head;

public class RobotType2 extends Robot{

    @Override
    public void on(){

        System.out.println("Робот Тип2 Включен.");
    }

    @Override
    public void off(){
        System.out.println("Робот Тип2 Отключен.");
    }

    public RobotType2(String name, Head head, Body body) {

        super(name, head, body);
        super.robotsType = RobotsType.TYPE2;
    }
}
