package chen.lotus.thread.balking;

public class FirstTime {
    private boolean initialized = false;

    public synchronized void init(){
        if (initialized) {
            return;
        }
        doInit();
        initialized = true;
    }

    private void doInit() {

    }


}
