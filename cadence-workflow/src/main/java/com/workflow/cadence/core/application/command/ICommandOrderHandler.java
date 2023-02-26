package com.workflow.cadence.core.application.command;

import com.workflow.cadence.api.order.OrderApiRequest;

public interface ICommandOrderHandler {

    void startOrder(OrderApiRequest request);
}
