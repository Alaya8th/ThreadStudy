package runnable_thread1;

class MyThread2 implements Runnable {
	int m; // m為執行的次數

	MyThread2(int a) { // MyThread類別的建構式
		m = a;
	}

	public void run() { // 覆寫run方法
		for (int i = 1; i <= m; i++) {
			System.out.println(Thread.currentThread().getName() + " = " + i);
		}
	}
}

public class RunnableThread1 {
	public static void main(String[] args) {
		// 建立Runnable物件obR1，並傳入引數100
		MyThread2 obR1 = new MyThread2(100);
		// 建立Runnable物件obR2，並傳入引數50
		MyThread2 obR2 = new MyThread2(50);
		// 建立Thread物件obT1，並傳入obR1和執行緒名稱
		Thread obT1 = new Thread(obR1, "執行緒1");
		// 建立Thread物件obT2，並傳入obR2和執行緒名稱
		Thread obT2 = new Thread(obR2, "執行緒2");
		obT1.start(); // 啟動obT1執行緒
		obT2.start(); // 啟動obT2執行緒
	}

}
