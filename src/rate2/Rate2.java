package rate2;

public class Rate2 {

	public static void main(String[] args) {
		Thread tortoise = new Thread(() -> {
			for (int i = 1; i <= 20; i++) {
				System.out.println("烏龜共跑 " + i + " 步");
			}
			System.out.println("烏龜到達終點!!!");
		});

		Thread rabbit = new Thread(() -> {
			for (int i = 4; i <= 20; i += 4) {
				if ((int) (Math.random() * 10 + 1) % 2 == 0) {
					System.out.println("兔子休息");
					i -= 4;
				} else {
					System.out.println("兔子共跑 " + i + " 步");
				}
			}
			System.out.println("兔子到達終點!!!");
		});

		rabbit.start();
		tortoise.start();

	}

}
