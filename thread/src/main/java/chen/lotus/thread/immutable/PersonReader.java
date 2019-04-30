package chen.lotus.thread.immutable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonReader extends Thread {

    private Person person;

    public PersonReader(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            log.info("Thread {} is reading Person:{}", Thread.currentThread().getName(), person);
        }
    }
}
