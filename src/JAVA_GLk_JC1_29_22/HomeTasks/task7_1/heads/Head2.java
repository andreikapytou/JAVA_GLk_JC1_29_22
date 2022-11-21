package JAVA_GLk_JC1_29_22.HomeTasks.task7_1.heads;


public class Head2 implements Head {

    HeadType type;

    public void greetVoice() {
        System.out.println("Голова №2 Средняя - готова к работе.");
    }

    public String getType() {

        return type.getTitle();
    }

    public Head2() {
        type = HeadType.HEAD2;
    }
}
