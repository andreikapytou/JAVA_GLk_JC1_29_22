package JAVA_GLk_JC1_29_22.HomeTasks.task7_1;

import JAVA_GLk_JC1_29_22.HomeTasks.task7_1.factory.FactoryType;
import JAVA_GLk_JC1_29_22.HomeTasks.task7_1.heads.*;

public class Robot {

    private FactoryType factoryType;
    private String name;
    private BodyType body;
    private Head head;
    private boolean onOff;

    public void on() {
        onOff = true;
        System.out.println("\nРобот " + name + " Включен и готов к работе.");
    }

    public void off() {
        onOff = false;
        System.out.println("Робот " + name + " Отключен.");
    }

    public void testingAfterActivation() {

        if (onOff) {
            body.greetVoice();
            head.greetVoice();
        }
    }

    @Override
    public String toString() {

        return factoryType.getTitle() +
                "  Имя робота = " + name + " " + head.getType() + " " + body.getTitle();

    }

    public Robot(String name, Head head, BodyType body) {

        this.name = name;
        this.head = head;
        this.body = body;
    }

    public void setFactoryType(FactoryType factoryType) {

        this.factoryType = factoryType;
    }
}
