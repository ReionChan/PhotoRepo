package org.reion.api.service;

/**
 * ActiveMQ 发送端服务接口.
 *
 * @author Reion
 * @version 1.0
 * @date 2018-09-02 10:37
 **/
public interface IAmqService {

    void sendMsg(String msg);
}
