package com.workflow.cadence.core.application.event;

import com.workflow.cadence.core.domain.Order;

public interface IEventManager {

    void publish(Order order);
}
