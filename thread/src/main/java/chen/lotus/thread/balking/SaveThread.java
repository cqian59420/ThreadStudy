package chen.lotus.thread.balking;

public class SaveThread extends Thread {

    private final OData data;

    public SaveThread(String name, OData data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            data.save();
            try {
//                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
