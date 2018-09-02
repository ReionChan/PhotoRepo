package org.reion.impl.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reion.api.service.IAmqService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * ActiveMQ 发送端服务.
 *
 * @author Reion
 * @version 1.0
 * @date 2018-09-02 10:25
 **/
@Service("AmqService")
public class AmqServiceImpl implements IAmqService {

    private static final Log log = LogFactory.getLog(AmqServiceImpl.class);

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 目的地队列的明证，我们要向这个队列发送消息.
     */
    @Resource(name = "destinationQueue")
    private Destination destination;

    @Override
    public void sendMsg(String msg) {
        try {
            log.info("将向队列 " + destination + " 发送消息，消息为：" + msg);
            jmsTemplate.send(destination, session -> session.createTextMessage(msg));

        } catch (Exception ex) {
            log.error("向队列 " + destination + " 发送消息失败，消息为：" + msg, ex);
        }
    }
}
