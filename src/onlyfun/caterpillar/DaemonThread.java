package onlyfun.caterpillar;
 
public class DaemonThread { 
    public static void main(String[] args) {

        Thread thread = new Thread(
        // �o�O�ΦW���O���g�k
            new Runnable() {
                public void run() { 
                    while(true) { 
                        System.out.print("T"); 
                    } 
                }        
            }); 
        // �]�w��Daemon�����
        thread.setDaemon(true); 
        thread.start(); 
    }
}