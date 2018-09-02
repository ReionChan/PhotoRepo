package org.reion.impl.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * ActiveMQ 消息接受监听器
 *
 * @author Reion
 * @version 1.0
 * @date 2018-09-02 22:50
 **/
public class AmqListener implements MessageListener{

    private static final Log log = LogFactory.getLog(AmqListener.class);

    @Override
    public void onMessage(Message msg) {
        if (msg instanceof TextMessage) {
            try {
                TextMessage txtMsg = (TextMessage) msg;
                String message = txtMsg.getText();
                log.info("接收到消息：" + message);
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}
