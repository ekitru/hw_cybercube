package com.cybercube.homework.data.processor.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RedisRepository {

    private final HashOperations hashOperations;

    public RedisRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(UUID uid, double score) {
        hashOperations.put("PERSON_" + uid.toString(), uid.hashCode(), score);
    }

    public List<Object> findBy(UUID uid) {
        return hashOperations.values("PERSON_" + uid.toString());
    }
}