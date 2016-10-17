package onlyfun.caterpillar;
 
public class Clerk {
    // -1 ��ܥثe�S�����~
    private int product = -1; 
 
    // �o�Ӥ�k�ѥͲ��̩I�s
    public synchronized void setProduct(int product) { 
        if(this.product != -1) { 
            try { 
                // �ثe�����S���Ŷ������~�A�еy�ԡI
                wait(); 
            } 
            catch(InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
 
        this.product = product; 
        System.out.printf("�Ͳ��̳]�w (%d)%n", this.product); 

        // �q�����ݰϤ����@�Ӯ��O�̥i�H�~��u�@�F
        notify(); 
    } 
    
    // �o�Ӥ�k�Ѯ��O�̩I�s
    public synchronized int getProduct() { 
        if(this.product == -1) { 
            try { 
                // �ʳf�F�A�еy�ԡI
                wait(); 
            } 
            catch(InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
 
        int p = this.product; 
        System.out.printf(
                  "���O�̨��� (%d)%n", this.product); 
        this.product = -1; 
 
        // �q�����ݰϤ����@�ӥͲ��̥i�H�~��u�@�F
        notify(); 
       
        return p; 
    } 
}