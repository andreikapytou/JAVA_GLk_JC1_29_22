package JAVA_GLk_JC1_29_22.HomeTasks.task8.robots;

import JAVA_GLk_JC1_29_22.HomeTasks.task8.bodies.Body;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.heads.Head;
import JAVA_GLk_JC1_29_22.HomeTasks.task8.factory.FactoryType;

public abstract class Robot {

    private FactoryType factoryType;
    protected RobotsType robotsType;
    private String name;
    private Body body;
    private Head head;

    public abstract void on();
    public abstract void off();

    @Override
    public String toString() {

        return "Тип робота = "+robotsType.toString()+ " Произведен на заводе = "+ factoryType.toString()+
                "  Имя робота = "+name+ " Тип головы = "+head.getStrTypeHead()+" Тип туловища = "+body.getStrTypeBody();

    }

    public Robot(String name, Head head, Body body ) {

        this.name = name;
        this.head = head;
        this.body = body;
    }

    public void setFactoryType(FactoryType factoryType) {

        this.factoryType = factoryType;
    }
}
