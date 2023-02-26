package com.workflow.temporal.workflow.core.application.workflow.main;

import com.workflow.temporal.workflow.core.application.workflow.prepare.IPrepareWorkflow;
import com.workflow.temporal.workflow.core.domain.Order;
import io.temporal.activity.ActivityOptions;
import io.temporal.api.enums.v1.WorkflowIdReusePolicy;
import io.temporal.workflow.ChildWorkflowOptions;
import io.temporal.workflow.Workflow;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static com.workflow.temporal.workflow.config.WorkerConfiguration.PREPARE_TASK_LIST;


@Slf4j
public class OrderWorkflow implements IOrderWorkflow {

    private boolean isPickByDriver = false;
    private IOrderActivity orderActivity = Workflow.newActivityStub(IOrderActivity.class,
            ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(200)).build()
            );

    @Override
    public void start(Order order) {
        orderActivity.validate(order);

        order.getProducts().forEach(foodProduct ->
        {
            IPrepareWorkflow prepareWorkflow = Workflow.newChildWorkflowStub(IPrepareWorkflow.class, getChildWorkflowOptions(foodProduct.getId()));
            prepareWorkflow.prepare(foodProduct);
        });

        Workflow.await(() -> isPickByDriver);
        Workflow.sleep(Duration.ofSeconds(10));
    }

    private ChildWorkflowOptions getChildWorkflowOptions(String id) {
        return ChildWorkflowOptions.newBuilder()
                .setWorkflowId(id)
                .setTaskQueue(PREPARE_TASK_LIST)
                .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.WORKFLOW_ID_REUSE_POLICY_ALLOW_DUPLICATE)
                .build();

    }

    @Override
    public void assignToDriver(String driverId) {
        isPickByDriver = true;
    }
}


