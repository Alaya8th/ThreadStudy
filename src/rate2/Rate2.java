package rate2;

public class Rate2 {

	public static void main(String[] args) {
		Thread tortoise = new Thread(() -> {
			for (int i = 1; i <= 20; i++) {
				System.out.println("�Q�t�@�] " + i + " �B");
			}
			System.out.println("�Q�t��F���I!!!");
		});

		Thread rabbit = new Thread(() -> {
			for (int i = 4; i <= 20; i += 4) {
				if ((int) (Math.random() * 10 + 1) % 2 == 0) {
					System.out.println("�ߤl��");
					i -= 4;
				} else {
					System.out.println("�ߤl�@�] " + i + " �B");
				}
			}
			System.out.println("�ߤl��F���I!!!");
		});

		rabbit.start();
		tortoise.start();

	}

}
