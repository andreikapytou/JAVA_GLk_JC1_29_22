package JAVA_GLk_JC1_29_22.HomeTasks.task7_1;

public enum BodyType {
    BODY1("Тело №1 : Маленькое.") {
        public void greetVoice() {
            System.out.println("Тело   №1 Маленькое - готово к работе.");
        }
    },
    BODY2("Тело №2 : Среднее.") {
        public void greetVoice() {
            System.out.println("Тело   №2 Среднее - готово к работе.");
        }
    },
    BODY3("Тело №3 : Большое.") {
        public void greetVoice() {
            System.out.println("Тело   №3 Большое - готово к работе.");
        }
    };

    private final String title;

    BodyType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void greetVoice();
}
