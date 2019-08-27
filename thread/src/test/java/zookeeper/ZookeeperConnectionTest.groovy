package zookeeper

import spock.lang.Shared
import spock.lang.Specification

class ZookeeperConnectionTest extends Specification {

    @Shared
    def zooKeepConnection

    def "setupSpec"() {
        zooKeepConnection = new ZookeeperConnection()
        //assert client != null
    }

    def "createNode"() {
        when:
        zooKeepConnection.createNode()
        then:
        noExceptionThrown()
    }

    def "changeNode"() {
        when:
        zooKeepConnection.changeNode()
        then:
        noExceptionThrown()
    }

    def "DeleteNode"() {
        when:
        zooKeepConnection.deleteNode()
        then:
        noExceptionThrown()
    }

    def "cleanup"() {
        zooKeepConnection.getNode()

    }

}
