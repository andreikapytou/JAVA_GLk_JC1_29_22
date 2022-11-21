package JAVA_GLk_JC1_29_22.HomeTasks.task7_1.factory;

public enum FactoryType {
    F_BODIES("Завод по производству Тел   для Роботов."),
    F_HEADS("Завод по производству Голов для Роботов.");

    private final String title;

    FactoryType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
