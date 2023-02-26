package com.workflow.temporal.workflow.core.application.delivery;

import com.workflow.temporal.workflow.api.AssignDriverApiRequest;
import io.temporal.api.enums.v1.WorkflowIdReusePolicy;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.workflow.temporal.workflow.config.WorkerConfiguration.ORDER_TASK_LIST;


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
