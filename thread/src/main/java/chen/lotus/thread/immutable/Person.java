package chen.lotus.thread.immutable;

import lombok.ToString;

/**
 * @author cqian
 */
@ToString
public final class Person {

    private String name;

    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
