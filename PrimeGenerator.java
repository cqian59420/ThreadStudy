package Thread.ThreadStudy;

/**
 * Created by IntelliJ IDEA.
 * User: Terrance
 * Date: 13-1-30
 * Time: 下午9:16
 * To change this template use File | Settings | File Templates.
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long num = 1L;
        while (true) {
            if (isPrime(num)) {
                System.out.printf("Num %d is 质数\n", num);
            }
            if (isInterrupted()) {
                System.out.printf("Num 中断\n");
                return;
            }
            num++;
        }
    }

    private boolean isPrime(long num) {
        if (num <= 2) {
            return true;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] adsad) {
        PrimeGenerator thread = new PrimeGenerator();
        thread.start();
        try {
            System.out.printf("aaaa"+ Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.printf("sleep 5 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
