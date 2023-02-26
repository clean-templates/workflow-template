package com.workflow.temporal.workflow.core.application.delivery;

import com.workflow.temporal.workflow.api.AssignDriverApiRequest;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowStub;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class CommandDeliveryHandler implements ICommandDeliveryHandler {

    private WorkflowClient workflowClient;

    @Override
    public void assignDriver(AssignDriverApiRequest req) {
        WorkflowStub workflowStub = workflowClient.newUntypedWorkflowStub(req.getOrderId(), Optional.empty(), Optional.empty());
        workflowStub.signal("assignToDriver", req.getDriverId());

    }

}
