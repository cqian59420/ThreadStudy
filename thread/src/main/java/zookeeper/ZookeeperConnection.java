package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;

public class ZookeeperConnection {

    CuratorFramework curatorFramework;

    public ZookeeperConnection() {

        curatorFramework = CuratorFrameworkFactory.newClient("127.0.0.1", (i, l, retrySleeper) -> false);
        curatorFramework.start();

    }

    public void createNode() throws Exception {
        curatorFramework.create().forPath("/myCurator", "person1".getBytes());
    }

    public void changeNode() throws Exception {
        curatorFramework.setData().forPath("/myCurator", "person2".getBytes());
    }


    public void getNode() throws Exception {
        curatorFramework.getData().forPath("/myCurator");
    }


    public void deleteNode() throws Exception {
        curatorFramework.delete().forPath("/myCurator");
    }


}

