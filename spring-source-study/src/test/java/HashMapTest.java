import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @version $Id: null.java, v 1.0 2020/5/26 11:10 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class HashMapTest {

    public static void main(String[] args) {
//        testSynchronized();
    }

    public void testSynchronized() {
        Integer a = 20;
        synchronized (a){
            int c = 30;
            System.out.println("heihei");
        }
    }
}
