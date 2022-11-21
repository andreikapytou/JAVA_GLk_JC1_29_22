package JAVA_GLk_JC1_29_22.HomeTasks.task7_1.heads;


public class Head1 implements Head {

    HeadType type;

    public void greetVoice() {
        System.out.println("Голова №1 Маленькая - готова к работе.");
    }

    public String getType() {

        return type.getTitle();
    }

    public Head1() {
        type = HeadType.HEAD1;
    }
}
