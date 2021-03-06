package chen.lotus.thread.balking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Data implements OData  {

    private final String fileName;

    private String content;

    private boolean changed;

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        changed = true;
    }


    @Override
    public synchronized void change(String newContent){
        content = newContent;
        changed = true;
    }

    @Override
    public synchronized void save(){
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() {
        log.info("{} 正在保存 {}",Thread.currentThread().getName() , content);
    }
}
