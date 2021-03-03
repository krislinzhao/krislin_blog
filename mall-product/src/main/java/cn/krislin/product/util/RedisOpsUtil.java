package cn.krislin.product.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author ：杨过
 * @date ：Created in 2020/2/26
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description:
 **/
public class RedisOpsUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    public void set(String key, Object value, long timeout, TimeUnit unit){
        redisTemplate.opsForValue().set(key,value,timeout,unit);
    }

    public boolean setIfAbsent(String key, Object value, long timeout, TimeUnit unit){
        return redisTemplate.opsForValue().setIfAbsent(key,value,timeout,unit);
    }

    public <T> T get(String key,Class<?> T){
        return (T)redisTemplate
                .opsForValue().get(key);
    }

    public String get(String key){
        return (String) redisTemplate
                .opsForValue().get(key);
    }

    public Long decr(String key){
        return redisTemplate
                .opsForValue().decrement(key);
    }

    public Long decr(String key,long delta){
        return redisTemplate
                .opsForValue().decrement(key,delta);
    }

    public Long incr(String key){
        return redisTemplate
                .opsForValue().increment(key);
    }

    public Long incr(String key,long delta){
        return redisTemplate
                .opsForValue().increment(key,delta);
    }

}