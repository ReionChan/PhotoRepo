package org.reion.impl.domain;

/**
 * 消息对象基类.
 *
 * @author Reion
 * @version 1.0
 * @date 2018-09-02 12:07
 **/
public abstract class BaseMessage {

    /**
     * 所有子类消息都要实现将自身变成字符串的格式.
     *
     * @return java.lang.String 字符串消息
     */
    protected abstract String convert();
}
