package JAVA_GLk_JC1_29_22.HomeTasks.task7_1.heads;

public enum HeadType {

    HEAD1("Голова №1 : Маленькая."),
    HEAD2("Голова №2 : Средняя  ."),
    HEAD3("Голова №3 : Большая  .");

    private final String title;

    HeadType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
