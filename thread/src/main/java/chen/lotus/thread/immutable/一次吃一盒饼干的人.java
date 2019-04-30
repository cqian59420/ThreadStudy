package chen.lotus.thread.immutable;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class 一次吃一盒饼干的人 extends Thread {

    private List<String> 一盒饼干;

    public 一次吃一盒饼干的人(List<String> 一盒饼干) {
        this.一盒饼干 = 一盒饼干;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            一盒饼干.add(i+"");
            一盒饼干.remove(0);
            log.info("thread:{} 放了一个，吃了一个,盒子好剩下:{}",currentThread().getName(),一盒饼干.size());

        }
    }
}
