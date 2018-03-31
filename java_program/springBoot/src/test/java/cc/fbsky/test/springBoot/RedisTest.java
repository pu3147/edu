package cc.fbsky.test.springBoot;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
		jedis.set("Hello", "Hello Jedis!");
		
		String str = jedis.get("Hello");
		jedis.close();
		
		System.out.println(str);
	}
}
