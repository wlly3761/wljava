package com.wl;

public interface ICache {
    /**
     * 检查缓存中是否存在某个key
     *
     * @param key redis-key
     * @return
     */
    public boolean exists(final String key);

    /**
     * 获取缓存中对应key的value值
     *
     * @param key redis-key
     * @return
     */
    public String get(final String key);

    /**
     * 存入值到缓存，并设置有效期
     *
     * @param key redis-key
     * @param value redis-value
     * @param expireTime key的超时时间。有效期，单位s
     * @return
     */
    public boolean set(final String key, String value, int expireTime);

    /**
     * 存入值到缓存
     *
     * @param key redis-key
     * @param value redis-value
     * @return
     */
    public boolean set(final String key, String value);

    /**
     * 删除缓存对应的key值
     *
     * @param key redis-key
     * @return
     */
    public boolean del(final String key);
}
