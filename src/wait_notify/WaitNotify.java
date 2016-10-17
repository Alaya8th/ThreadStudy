package wait_notify;

class Frisbee { // �bFrisbee���O���]�w���L�����ݩʩM��k
	private boolean isThrow = false; // �O�����L�O�_��X�Afalse=����X

	public synchronized void throwF(int tNo) { // �᭸�L����k
		while (isThrow) { // ��isThrow��true�N���_����
			try {
				wait(); // �D�H�i�J���ݪ��A
			} catch (InterruptedException e) {
			}
		}
		System.out.println("��X�� " + tNo + " �ӭ��L");
		isThrow = true; // �]���L����X
		notify(); // �I�s�p���ӱ����L
	}

	public synchronized void accessF(int aNo) { // �����L����k
		while (!isThrow) { // ��isThrow��false�N���_����
			try {
				wait(); // �p���i�J���ݪ��A
			} catch (InterruptedException e) {
			}
		}
		System.out.println("����� " + aNo + " �ӭ��L");
		isThrow = false; // �]���L������X
		notify(); // �I�s�D�H�᭸�L
	}
}

class ThrowFrisbee implements Runnable { // ThrowFrisbee���O��@Runnable����
	Frisbee frisbee; // �إ�Frisbee���O����frisbee

	ThrowFrisbee(Frisbee frisbee) { // �غc�l
		this.frisbee = frisbee;
	}

	public void run() { // �brun()��k������᭸�L5��
		for (int i = 1; i <= 5; i++) {
			frisbee.throwF(i);
		}
	}
}

class AccessFrisbee implements Runnable { // AccessFrisbee���O��@Runnable����
	Frisbee frisbee; // �إ�Frisbee���O����frisbee

	AccessFrisbee(Frisbee frisbee) { // �غc�l
		this.frisbee = frisbee;
	}

	public void run() { // �brun()��k�����汵���L5��
		for (int i = 1; i <= 5; i++) {
			frisbee.accessF(i);
		}
	}
}

public class WaitNotify {
	public static void main(String[] atgs) {
		Frisbee frisbee = new Frisbee(); // �إ�Frisbee���O����frisbee
		Thread master = new Thread(new ThrowFrisbee(frisbee));
		Thread dog = new Thread(new AccessFrisbee(frisbee));
		master.start(); // �Ұ�master���������᭸�L
		dog.start(); // �Ұ�dog��������汵���L
	}

}
