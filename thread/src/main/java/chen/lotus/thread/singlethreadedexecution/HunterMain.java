package chen.lotus.thread.singlethreadedexecution;

public class HunterMain {

    public static void main(String[] args) {
        BoundeResource boundeResource = new BoundeResource(2);
        new ResourceHunter(boundeResource).start();
        new ResourceHunter(boundeResource).start();
        new ResourceHunter(boundeResource).start();
        new ResourceHunter(boundeResource).start();
    }
}
