package thread_method;
class MyThread3 extends Thread {  //繼承Thread類別
	MyThread3() {
		start();  //啟動執行緒
	}

	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println(getName()+"執行緒：" + " 執行第 " + i + "次");
				sleep(500);  //執行緒暫停0.5秒
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadMethod {
	public static void main(String[] args) {
		MyThread3 obT1 = new MyThread3();
		obT1.setName("T1");  //設定執行緒名稱為T1
		System.out.println("目前的執行緒為：" + Thread.currentThread().getName());
		System.out.println("執行緒 T1 是否活著：" + obT1.isAlive());
		try {
			obT1.join();  //等待所呼叫的obT1執行緒執行完畢
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("執行緒T1 是否活著：" + obT1.isAlive());
	}

}
