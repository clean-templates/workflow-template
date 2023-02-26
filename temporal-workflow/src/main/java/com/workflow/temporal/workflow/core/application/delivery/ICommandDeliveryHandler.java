package com.workflow.temporal.workflow.core.application.delivery;


import com.workflow.temporal.workflow.api.AssignDriverApiRequest;

public interface ICommandDeliveryHandler {

    void assignDriver(AssignDriverApiRequest req);
}
