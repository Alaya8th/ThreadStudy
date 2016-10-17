package extends_thread2;

class MyThread extends Thread { // MyThread�~�Ӧ�Thread���O
	int i = 0, m; // m���Ȱ���������ɶ�
	String threadName; // ��������W��

	MyThread(String name, int a) { // MyThread���O���غc��
		m = a; // �]�w��������Ȱ��ɶ�
		threadName = name; // �]�w������W��
		start(); // �I�s�غc���ɡA�����Ұʰ����
	}

	public void run() { // �мgThread���O��run��k
		try {
			while (true) {
				i++;
				System.out.println(threadName + " ����� " + i + " ��");
				sleep(m); // Thread���O��sleep��k�ΨӼȰ���������ɶ�
				if (i >= 5)
					break;
			}
		} catch (InterruptedException e) {
			System.out.println("���ͨҥ~.....!");
		}
	}
}

public class ExtendsThread2 {
	// �إ�obT1������W�٬� �����1�B�C���Ȱ�0.5��
	MyThread obT1 = new MyThread("����� 1", 500);
	// �إ�obT2������W�٬� �����2�B�C���Ȱ�2��
	MyThread obT2 = new MyThread("����� 2", 2000);
}
