package com.workflow.temporal.workflow.core.application.workflow.main;


import com.workflow.temporal.workflow.core.domain.Order;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface IOrderWorkflow {

    @WorkflowMethod()
    void start(Order order);

    @SignalMethod(name = "assignToDriver")
    void assignToDriver(String driverId);

}
