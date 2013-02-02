package Thread.ThreadStudy;

public class WaitAThreadToDie {

    public static void main(String[] args) {
        Thread first = new WaitThreaDie("a", "a", 2000);
        Thread second = new WaitThreaDie("b", "b", 3000);
        Thread third = new WaitThreaDie("c", "c", 5000);
        first.start();
        second.start();
        third.start();
        try {
            first.join(20000);//当主线程运行到这里的时候让其等20000毫秒让first线程结束，但是second 和third还按它们创建的时间运行和结束
        } catch (InterruptedException e) {
        }
        System.out.println("主线程");//   当主线程运行到这的时候输出这个字符串
    }

}

class WaitThreaDie extends Thread {
    private String firstName, secondName;
    private long total, aWhile;

    public WaitThreaDie(String firstName, String secondName, long waitTime) {
        this.aWhile = waitTime;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void run() {
        try {
            //System.out.printf("total == "+total+"\n");
            while (total < 10000) {//　　　当sleep超过1000毫秒时些线程结束
                System.out.println(firstName);
                sleep(aWhile);
                total += aWhile;
                System.out.println(secondName + " sleep");//表示当前这个线程sleep了一次

            }
        } catch (InterruptedException e) {
            System.out.println("cus Thread interrupted!..");
        }
        System.out.println(secondName + " stopped!");
    }
}