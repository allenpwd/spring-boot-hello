package springboot;

import org.junit.Test;

import java.util.Calendar;
import java.util.function.Consumer;

/**
 * @author pwd
 * @create 2019-01-30 15:34
 **/
public class OtherTest {

    @Test
    public void test() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);// 日期减一个月
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));// 获取到该月最后一天
        System.out.println(cal.getTime());
    }

    @Test
    public void test2() {
        Consumer consumer = new Consumer<String>() {
            private String name = "abc";
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        consumer.accept("潘伟丹");
    }
}
