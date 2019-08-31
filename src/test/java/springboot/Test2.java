package springboot;

import org.junit.Test;
import springboot.entity.Department;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test2 {

    public String strArg;
    Integer intArg;
    private Date dateArg;

    /**
     * ACM题目，打印图案
     */
    @Test
    public void test() {
        int num = 10;
        int[][] arr = new int[num][num];
        int x = 0, y = -1, index = 1;

        while(true) {
            //左到右
            y++;
            if (arr[x][y] != 0) break;
            for (; y < num && arr[x][y] == 0; y++) {
                arr[x][y] = index++;
            }
            y--;

            //上到下
            x++;
            if (arr[x][y] != 0) break;
            for (; x < num && arr[x][y] == 0; x++) {
                arr[x][y] = index++;
            }
            x--;

            //右到左
            y--;
            if (arr[x][y] != 0) break;
            for (; y >= 0 && arr[x][y] == 0; y--) {
                arr[x][y] = index++;
            }
            y++;

            //下到上
            x--;
            if (arr[x][y] != 0) break;
            for (; x >= 0 && arr[x][y] == 0; x--) {
                arr[x][y] = index++;
            }
            x++;
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                int rel = arr[j][i];
                System.out.print((rel < 10 ? "00" : rel < 100 ? "0" : "") + rel + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {
        URL resource = Test2.class.getClassLoader().getResource("application.yml");
        System.out.println(resource);
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<String>() {
            {
                add("潘伟丹");
                add("fuck");
                add(null);
            }
        };
        list.forEach((s) -> System.out.println(s));
        Predicate<String> predicate = t -> t != null && t.startsWith("f");
        List<String> collect = list.stream().filter(predicate).collect(Collectors.toList());
        Test2 test = new Test2();
        System.out.println(test.getObj(collect));
        KeyEventDispatcher nonNull = Objects::nonNull;
        System.out.println(nonNull);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age", 26);
    }

    public <T> T getObj(T t) {
        return t;
    }

    @Test
    public void test4() {
        IConvert<String, Pwd> convert = Pwd::new;
        Pwd pwd = convert.get("潘伟丹");
        System.out.println(pwd);
    }

    @Test
    public void test5() {
        String s = "asdfasdf;sdfsd";
        if (s != null) {
            StringTokenizer st =
                    new StringTokenizer(s, File.pathSeparator);
            int count = st.countTokens();
            for (int i = 0; i < count; i++) {
                System.out.println(st.nextToken());
            }
        }
    }
}

@FunctionalInterface
interface IConvert<T, V> {
    V get(T t);
}

class Pwd {
    private String name;

    public Pwd(String name) {
        this.name = name;
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }
}