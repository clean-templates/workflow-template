package com.workflow.temporal.workflow.core.application.command;


import com.workflow.temporal.workflow.api.order.OrderApiRequest;

public interface ICommandOrderHandler {

    void startOrder(OrderApiRequest request);
}
