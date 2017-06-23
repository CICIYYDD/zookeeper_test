package com.atguigu.zookeeper.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class BaseZookeeper {
	protected static final String CONNECTSTRING = "192.168.163.128:2181";
	protected static final int SESSIONTIMEOUT = 30 * 1000;
	protected static final String PATH = "/atguigu";
	ZooKeeper zooKeeper = null;
	protected static final Watcher WATCHER = new Watcher() {
		@Override
		public void process(WatchedEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	public static String getConnectstring() {
		return CONNECTSTRING;
	}
	public static int getSessiontimeout() {
		return SESSIONTIMEOUT;
	}
	public static String getPath() {
		return PATH;
	}
	public static Watcher getWatcher() {
		return WATCHER;
	}
}
