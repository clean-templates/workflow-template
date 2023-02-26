package com.workflow.cadence.core.application.delivery;

import com.uber.cadence.WorkflowIdReusePolicy;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowOptions;
import com.uber.cadence.client.WorkflowStub;
import com.workflow.cadence.api.AssignDriverApiRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

import static com.workflow.cadence.config.WorkerConfiguration.ORDER_TASK_LIST;

@Service
@AllArgsConstructor
public class CommandDeliveryHandler implements ICommandDeliveryHandler{

    private WorkflowClient workflowClient;

    @Override
    public void assignDriver(AssignDriverApiRequest req) {
        WorkflowStub workflowStub = workflowClient.newUntypedWorkflowStub(req.getOrderId(),
                Optional.empty(),
                Optional.empty());
        workflowStub.signal("assignToDriver", req.getDriverId());

    }
}
