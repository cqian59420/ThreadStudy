package chen.lotus.thread.immutable;

public class Question {

    private final StringBuffer stringBuffer;


    public Question(String name,String address) {
        this.stringBuffer = new StringBuffer(name+address);
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public static void main(String[] args) {
    }
}
