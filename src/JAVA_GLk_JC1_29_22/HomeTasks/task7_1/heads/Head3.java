package JAVA_GLk_JC1_29_22.HomeTasks.task7_1.heads;


public class Head3 implements Head {

    HeadType type;

    public void greetVoice() {
        System.out.println("Голова №3 Большая - готова к работе.");
    }

    public String getType() {

        return type.getTitle();
    }

    public Head3() {
        type = HeadType.HEAD3;
    }
}
