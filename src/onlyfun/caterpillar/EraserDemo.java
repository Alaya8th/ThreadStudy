package onlyfun.caterpillar;

import java.util.Scanner;

public class EraserDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("��J�W�١G");
            String name = scanner.next();

            System.out.print("��J�K�X�G ");

            // Eraser��@Runnable����
            Eraser eraser = new Eraser('#');

            // �Ұ� Eraser �����
            Thread eraserThread = new Thread(eraser);
            eraserThread.start();
            String password = scanner.next();
            eraser.setActive(false);

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