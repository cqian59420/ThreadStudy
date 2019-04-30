package chen.lotus.thread.singlethreadedexecution;

public class DeadLockMain {

    public static void main(String[] args) {
        Tool 左手叉 = new Tool("叉");
        Tool 右手刀 = new Tool("刀");

        new EaterThread("阿强",左手叉,右手刀).start();
//        new EaterThread("阿菲",左手叉,右手刀).start();
        new EaterThread("阿菲",右手刀,左手叉).start();
    }
}
