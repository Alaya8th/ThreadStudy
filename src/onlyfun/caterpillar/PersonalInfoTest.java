package onlyfun.caterpillar;
 
public class PersonalInfoTest {
    public static void main(String[] args) {
        final PersonalInfo person = new PersonalInfo(); 

        // ���]�|����Ӱ�����i���sperson����
        Thread thread1 = new Thread(new Runnable() { 
           public void run() { 
              while(true) 
                  person.setNameAndID("Justin Lin", "J.L"); 
           } 
        }); 
         
        Thread thread2 = new Thread(new Runnable() { 
            public void run() { 
               while(true) 
                   person.setNameAndID("Shang Hwang", "S.H");    
            } 
        }); 
         
        System.out.println("�}�l����....."); 
        
        thread1.start(); 
        thread2.start();
    }
}