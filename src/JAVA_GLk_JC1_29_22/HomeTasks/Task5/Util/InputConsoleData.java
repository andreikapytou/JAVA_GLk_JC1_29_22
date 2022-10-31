package JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util;

import java.util.Scanner;

public class InputConsoleData {

    public InputConsoleData() {
    }

    public static int input(String strWelcomeInput) {

        System.out.print(strWelcomeInput);
        Scanner inputData = new Scanner(System.in);
        return inputData.nextInt();
    }
}
