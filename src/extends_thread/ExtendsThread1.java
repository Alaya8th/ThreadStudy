package extends_thread;

class MyThread extends Thread {	//MyThread繼承自Thread類別
	int i = 0, m; 					//m為暫停執行緒的時間
	String threadName;				//執行緒的名稱
	MyThread(String name, int a) { 	//MyThread類別的建構式
		m = a; 					//設定執行緒的暫停時間
		threadName = name; 			//設定執行緒名稱
	}
	public void run() { 			//覆寫Thread類別的run方法
		try {
			while (true) {
				i++;
				System.out.println(threadName + " 執行第 " + i + " 次");
				sleep(m);	//Thread類別的sleep方法用來暫停執行緒的時間
				if (i >= 5)
					break;
			}
		} catch (InterruptedException e) {
			System.out.println("產生例外.....!");
		}
	}
 }

public class ExtendsThread1 {
	public static void main(String[] args) {
		//建立obT1執行緒名稱為 執行緒1、每次暫停0.5秒
		MyThread obT1 = new MyThread("執行緒 1", 500);
		//建立obT2執行緒名稱為 執行緒2、每次暫停2秒
		MyThread obT2 = new MyThread("執行緒 2", 2000);
		obT1.start(); //啟動obT1執行緒
		obT2.start(); //啟動obT2執行緒
	}

}
