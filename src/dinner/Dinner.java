package dinner;

class Eating implements Runnable {
	public void run() {
		System.out.println("�p����Ǧ^�a");
		System.out.println("�����٨S�N���\");
		Thread mom = new Thread(new Cooking()); // �ŧimom�����
		mom.start(); // �Ұ�mom������A�ж����}�l�N��
		try {
			mom.join(); // ��mom�����������
		} catch (InterruptedException e) {
			System.out.println("�p�����Q�Y���F�I");
		}
		System.out.println("�p���}�l�Y���\");
	}
}

class Cooking implements Runnable {
	public void run() {
		System.out.println("�����}�l�N���\");
		try {
			for (int i = 1; i <= 15; i++) {
				Thread.sleep(100);
				System.out.print(i + "�����A");
			}
			System.out.println();
		} catch (InterruptedException e) {
			System.out.println("�����}�u���Q�N���I");
		}
		System.out.println("�������Q�Q�����\�����I");
	}
}

public class Dinner {
	public static void main(String[] args) {
		Thread jerry = new Thread(new Eating()); // �ŧijerry�����
		jerry.start(); // �Ұ�jerry�����
	}

}
