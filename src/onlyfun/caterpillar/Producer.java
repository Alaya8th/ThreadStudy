package onlyfun.caterpillar;
 
public class Producer implements Runnable {
    private Clerk clerk; 
    
    public Producer(Clerk clerk) { 
        this.clerk = clerk; 
    } 
    
    public void run() { 
        System.out.println(
                "�Ͳ��̶}�l�Ͳ����......"); 

        // �Ͳ�1��10�����
        for(int product = 1; product <= 10; product++) { 
            try { 
                // �Ȱ��H���ɶ�
                Thread.sleep((int) Math.random() * 3000); 
            } 
            catch(InterruptedException e) { 
                e.printStackTrace(); 
            } 
            // �N���~�浹����
            clerk.setProduct(product); 
        }       
    } 
}