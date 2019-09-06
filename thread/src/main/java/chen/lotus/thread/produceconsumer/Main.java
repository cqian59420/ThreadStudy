package chen.lotus.thread.produceconsumer;

public class Main {


    public static void main(String[] args) {
        Table table = new Table(3);

        new MakerThread("阿菲", table, 41222).start();
        new MakerThread("阿菲-徒弟", table, 41222).start();
        new MakerThread("阿菲-徒孙", table, 41222).start();
        new EaterThread("美食家", table, 41222).start();
        new EaterThread("美食家-徒弟", table, 41222).start();
        new EaterThread("美食家-徒孙", table, 41222).start();
    }
}
