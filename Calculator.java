package Thread.ThreadStudy;

/**
 * Created by IntelliJ IDEA.
 * User: Terrance
 * Date: 13-1-27
 * Time: 下午8:43
 * To change this template use File | Settings | File Templates.
 */
public class Calculator implements Runnable {
    private int num;
    public Calculator(int num){
        num=num;
    }
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.printf("%s:%d * %d=%d\n", Thread.currentThread().getName(), num, i, i * num);
        }
    }
    public static  void main(String[] args){
        for (int i=1;i<=10;i++){
            Calculator calculator=new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
