package onlyfun.caterpillar;

import java.util.*;

public class ThreadLocal<T> {
    // ���o�@�ӦP�B�ƪ�Map����
    private Map<Thread, T> storage = 
             Collections.synchronizedMap(new HashMap<Thread, T>());

    public T get() {
        // ���o�ثe����get()��k�������
        Thread current = Thread.currentThread();
        // �ھڰ�������o������ۦ����귽
        T t = storage.get(current);

        // �p�G�٨S��������M�Ϊ��귽�Ŷ�
        // �h�إߤ@�ӷs���Ŷ�
        if(t == null && 
           !storage.containsKey(current)) {
            t = initialValue();
            storage.put(current, t);
        }

        return t;
    }

    public void set(T t) {
        storage.put(Thread.currentThread(), t);
    }

    public T initialValue() {
        return null;
    }
}