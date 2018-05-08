package cc.fbsky.test.springBoot;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorTest {
	
	public static void main(String[] args) {

		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
		client.start();
		
		try {
			String path = client.create().creatingParentsIfNeeded()//若创建节点的父节点不存在会先创建父节点再创建子节点
                    .withMode(CreateMode.EPHEMERAL)//withMode节点类型，
                    .forPath("/curator/3","131".getBytes());
        System.out.println(path);
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
