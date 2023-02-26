package com.workflow.temporal.workflow.core.application.event;


import com.workflow.temporal.workflow.core.domain.Order;

public interface IEventManager {

    void publish(Order order);
}
