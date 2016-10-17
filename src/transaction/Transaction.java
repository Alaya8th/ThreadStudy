package transaction;

class ATM extends Thread {
	Account account; // 宣告Account物件
	long money; // 宣告長整數money記錄存提款數額

	public ATM(Account ac, long n) { // 建構子
		this.account = ac; // 設定account屬性值
		this.money = n; // 設定money屬性值
	}

	public void run() {
		account.deposit(money); // 呼叫Account類別的deposit方法
	}
}

class Account {
	long balance; // balance屬性記錄帳戶餘額

	public Account(long balance) { // 建構子
		this.balance = balance; // 設定balance屬性值
	}

	public synchronized void deposit(long amount) {
		long d_balance;
		d_balance = this.balance;
		System.out.println("帳戶內餘額 = " + d_balance); // 顯示餘額
		if (amount >= 0) {
			System.out.println("存款增加數 = " + amount); // 存款
		} else {
			System.out.println("存款減少數 = " + amount); // 提款
		}
		System.out.println("交易中 .....");
		try {// 模擬取得帳號餘額所需的時間
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		d_balance += amount; // 計算出餘額
		if (d_balance >= 0) { // 若帳戶餘額>=0
			System.out.println("目前帳戶餘額 = " + d_balance + "\n");
			this.balance = d_balance; // 設定balance屬性值(帳戶餘額)
		} else {
			System.out.println("帳戶餘額不足！ \n");
		}
	}
}

public class Transaction {
	public static void main(String[] args) {
		Account account = new Account(5000); // 建立account物件並設帳戶餘額為5000
		ATM A1 = new ATM(account, -1000); // A1執行緒提款1000元
		ATM A2 = new ATM(account, 2000); // A2執行緒存款2000元
		ATM A3 = new ATM(account, -9000); // A3執行緒提款9000元
		A1.start(); // A1執行緒啟動
		A2.start(); // A2執行緒啟動
		A3.start(); // A3執行緒啟動
		try {
			A1.join(); // 等待A1執行緒執行完成
			A2.join(); // 等待A2執行緒執行完成
			A3.join(); // 等待A3執行緒執行完成
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("最後帳戶餘額: " + account.balance);
	}

}
