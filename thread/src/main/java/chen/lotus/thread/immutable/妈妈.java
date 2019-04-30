package chen.lotus.thread.immutable;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class 妈妈 extends Thread{

    private List<String> 一盒饼干;

    public 妈妈(List<String> 一盒饼干) {
        this.一盒饼干 = 一盒饼干;
    }

    @Override
    public void run() {
        while (true) {
            一盒饼干.forEach(s -> log.info("Mama is watching u :{}",s));
        }
    }
}
