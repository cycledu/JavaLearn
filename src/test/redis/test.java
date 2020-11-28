package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author : jingtao
 * @Data : 2020/10/28/23:23
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.6", 6379);
        String a = jedis.get("a");
        System.out.println(a);
        String set = jedis.set("b", "b");

    }
}
