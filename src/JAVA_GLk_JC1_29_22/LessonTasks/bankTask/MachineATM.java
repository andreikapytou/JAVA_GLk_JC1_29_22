package JAVA_GLk_JC1_29_22.LessonTasks.bankTask;

import java.util.HashMap;
import java.util.Map;

public class MachineATM {

    private static final int MAX_ATTEMPTS = 3;
    private static int countAttempts;

    public static boolean isFind(Integer pin, String num) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1111, "1111-1111-1111-1111-1111");
        map.put(2222, "1111-1111-1111-1111-2222");
        map.put(3333, "1111-1111-1111-1111-3333");
        map.put(4444, "1111-1111-1111-1111-4444");

        if (countAttempts >= MAX_ATTEMPTS ) {
            System.out.printf("Ранее %d раза был неверно Введен ПИН-КОД. Счет заблокирован.\n", countAttempts);
        } else {
            String findNum = map.getOrDefault(pin, null);
            if (findNum != null) {
                if (findNum.equals(num)) {
                    return true;
                } else {
                    System.out.println("Введен неверный номер карты-счета.");
                }
            } else {
                countAttempts++;
                System.out.printf("Введен неверный ПИН-КОД. Осталось %d попыток.\n", MAX_ATTEMPTS - countAttempts);
            }
        }
        return false;
    }

}
