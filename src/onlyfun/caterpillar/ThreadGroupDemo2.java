package onlyfun.caterpillar;
 
import java.io.*;
 
public class ThreadGroupDemo2 {
    public static void main(String[] args) {
        // �إߨҥ~�B�z��
        ThreadExceptionHandler handler = 
                 new ThreadExceptionHandler();
        ThreadGroup threadGroup1 = new ThreadGroup("group1");
        
        // �o�O�ΦW���O�g�k
        Thread thread1 = 
            // �o�Ӱ�����OthreadGroup1���@��
            new Thread(threadGroup1,
              new Runnable() {
                public void run() {
                    // ��Xunchecked�ҥ~
                    throw new RuntimeException("���ըҥ~");
                }
            }); 

        // �]�w�ҥ~�B�z��
        thread1.setUncaughtExceptionHandler(handler);     
        thread1.start();
    }
}