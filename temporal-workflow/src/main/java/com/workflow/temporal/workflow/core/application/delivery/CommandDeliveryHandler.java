package com.workflow.temporal.workflow.core.application.delivery;

import com.workflow.temporal.workflow.api.AssignDriverApiRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CommandDeliveryHandler implements ICommandDeliveryHandler {

//    private WorkflowClient workflowClient;

    @Override
    public void assignDriver(AssignDriverApiRequest req) {
//        WorkflowStub workflowStub = workflowClient.newUntypedWorkflowStub(req.getOrderId(), Optional.empty(), Optional.empty());
//        workflowStub.signal("assignToDriver", req.getDriverId());

    }

//
//    private WorkflowOptions getWorkflowOptions(String id) {
//        return new WorkflowOptions.Builder().setWorkflowId(id)
//                .setTaskList(ORDER_TASK_LIST)
//                .setExecutionStartToCloseTimeout(Duration.ofDays(10))
//                .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.AllowDuplicate)
//                .build();
//    }
}
