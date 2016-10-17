package onlyfun.caterpillar;

public class Eraser implements Runnable {
    private boolean active;
    private String mask;
    
    public Eraser() {
        this('*');
    }

    public Eraser(char maskChar) {
        active = true;
        mask = "\010" + maskChar;
    }

    // ���������ɳ]�w��false
    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    // ���s�w�qrun()��k
    public void run () {
        while(isActive()) {
            System.out.print(mask);
	     try {
                // �Ȱ��ثe�������50�@��
	        Thread.currentThread().sleep(50);
             } 
             catch(InterruptedException e) {
                 e.printStackTrace();
             }
        }
    }
}