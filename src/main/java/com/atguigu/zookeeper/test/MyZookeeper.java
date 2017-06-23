package com.atguigu.zookeeper.test;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class MyZookeeper extends BaseZookeeper{

	

	public ZooKeeper startZookeeper() throws IOException {
		return new ZooKeeper(CONNECTSTRING, SESSIONTIMEOUT, WATCHER);
	}

	public void stopZooKeeper(ZooKeeper zooKeeper) throws InterruptedException {
		if (zooKeeper != null) {
			zooKeeper.close();
		}
	}

	public void createZookeeperNode(ZooKeeper zooKeeper, String nodeValue)
			throws KeeperException, InterruptedException {
		if (zooKeeper != null && nodeValue != null && nodeValue != "") {
			zooKeeper.create(PATH, nodeValue.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
	}
	
	public String getZooKeeperNode(ZooKeeper zooKeeper,String path) throws KeeperException, InterruptedException {
		byte[] data = zooKeeper.getData(path,  false, new Stat());
		return new String(data);
	}
	
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		MyZookeeper myZookeeper = new MyZookeeper();
		ZooKeeper zk = myZookeeper.startZookeeper();
		Stat stat = zk.exists(PATH, false);
		if (stat == null) {
			myZookeeper.createZookeeperNode(zk, "AAAAAAAA");
			String zooKeeperNode = myZookeeper.getZooKeeperNode(zk, PATH);
			System.out.println("**********result: "+zooKeeperNode);
		}else {
			 System.out.println("***********znode has already ok***********");
		}
		myZookeeper.stopZooKeeper(zk);
	}

}
