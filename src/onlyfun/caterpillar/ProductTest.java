package onlyfun.caterpillar;
 
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk(); 
 
        // �Ͳ��̰����
        Thread producerThread = 
            new Thread(
                new Producer(clerk)); 
        // ���O�̰����
        Thread consumerThread = 
            new Thread(
                new Consumer(clerk)); 
 
        producerThread.start(); 
        consumerThread.start(); 
    }
}