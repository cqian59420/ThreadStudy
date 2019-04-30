package chen.lotus.thread.balking;

public class Main {

    public static void main(String[] args) {
//        Data diary = new Data("阿飞日记", "");
        VolatileData diary = new VolatileData("阿飞日记", "");

        new ChangerThread("我来改日记",diary).start();
        new SaveThread("我来存日记",diary).start();
    }
}
