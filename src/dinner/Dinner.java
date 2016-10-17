package dinner;

class Eating implements Runnable {
	public void run() {
		System.out.println("小明放學回家");
		System.out.println("媽媽還沒煮晚餐");
		Thread mom = new Thread(new Cooking()); // 宣告mom執行緒
		mom.start(); // 啟動mom執行緒，請媽媽開始煮飯
		try {
			mom.join(); // 讓mom執行緒先執行
		} catch (InterruptedException e) {
			System.out.println("小明不想吃飯了！");
		}
		System.out.println("小明開始吃晚餐");
	}
}

class Cooking implements Runnable {
	public void run() {
		System.out.println("媽媽開始煮晚餐");
		try {
			for (int i = 1; i <= 15; i++) {
				Thread.sleep(100);
				System.out.print(i + "分鐘，");
			}
			System.out.println();
		} catch (InterruptedException e) {
			System.out.println("媽媽罷工不想煮飯！");
		}
		System.out.println("媽媽香噴噴的晚餐完成！");
	}
}

public class Dinner {
	public static void main(String[] args) {
		Thread jerry = new Thread(new Eating()); // 宣告jerry執行緒
		jerry.start(); // 啟動jerry執行緒
	}

}
