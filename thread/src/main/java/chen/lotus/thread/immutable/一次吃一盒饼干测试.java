package chen.lotus.thread.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 一次吃一盒饼干测试 {

    public static void main(String[] args) {
        ArrayList<String> 一盒饼干 = new ArrayList<>();
        List<String> 高级饼干 = Collections.synchronizedList(一盒饼干);

        new 一次吃一盒饼干的人(一盒饼干).start();
        new 一次吃一盒饼干的人(一盒饼干).start();
        new 一次吃一盒饼干的人(一盒饼干).start();

        new 妈妈(一盒饼干).start();

    }
}
