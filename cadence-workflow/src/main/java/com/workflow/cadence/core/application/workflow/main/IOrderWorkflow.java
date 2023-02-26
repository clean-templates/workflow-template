package com.workflow.cadence.core.application.workflow.main;

import com.uber.cadence.workflow.SignalMethod;
import com.uber.cadence.workflow.WorkflowMethod;
import com.workflow.cadence.core.domain.Order;

public interface IOrderWorkflow {

    @WorkflowMethod()
    void start(Order order);

    @SignalMethod
    void assignToDriver(String driverId);

}
