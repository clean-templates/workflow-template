package com.workflow.cadence.core.application.delivery;

import com.workflow.cadence.api.AssignDriverApiRequest;

public interface ICommandDeliveryHandler {

    void assignDriver(AssignDriverApiRequest req);
}
