package com.workflow.temporal.workflow.core.application.workflow.main;


import com.workflow.temporal.workflow.core.domain.Order;

public interface IOrderWorkflow {

//    @WorkflowMethod()
    void start(Order order);

//    @SignalMethod(name = "assignToDriver")
    void assignToDriver(String driverId);

}
