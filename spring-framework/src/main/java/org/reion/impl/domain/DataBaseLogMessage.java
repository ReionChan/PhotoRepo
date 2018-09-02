package org.reion.impl.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 记录到数据库的消息.
 *
 * @author Reion
 * @version 1.0
 * @date 2018-09-02 12:11
 **/
public class DataBaseLogMessage extends BaseMessage implements Serializable {

    private String signature;
    private Object[] args;
    private long datetime;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    @Override
    public String convert() {
        return JSON.toJSONString(this);
    }
}
