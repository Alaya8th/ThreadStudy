package onlyfun.caterpillar;

import java.util.Scanner;

public class EraserThreadDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("��J�W�١G");
            String name = scanner.next();

            System.out.print("��J�K�X�G ");
            // �Ұ� Eraser �����
            EraserThread eraserThread = new EraserThread('#');
            eraserThread.start();
            String password = scanner.next();
            eraserThread.setActive(false);

            if("caterpillar".equals(name) &&
               "123456".equals(password)) {
                System.out.println("�w�� caterpillar ");
                break;
            }
            else {
                System.out.printf("%s�A�W�٩αK�X���~�A�Э��s��J�I%n", name);
            }
        }

    }
}