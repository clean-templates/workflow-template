package com.workflow.temporal.workflow.core.application.event;

import com.workflow.temporal.workflow.core.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventManager implements IEventManager{

    @Override
    public void publish(Order order) {
      log.info("Order with id: " + order.getId() + " has been published");
    }
}
