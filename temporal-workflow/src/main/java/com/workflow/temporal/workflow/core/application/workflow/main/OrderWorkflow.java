package com.workflow.temporal.workflow.core.application.workflow.main;

import com.workflow.temporal.workflow.core.domain.Order;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;


@Slf4j
public class OrderWorkflow implements IOrderWorkflow {

    private boolean isPickByDriver = false;
//    private IOrderActivity orderActivity = Workflow.newActivityStub(IOrderActivity.class);

    @Override
    public void start(Order order) {
//        orderActivity.validate(order);
//
//        order.getProducts().stream().forEach(foodProduct ->
//        {
//            IPrepareWorkflow prepareWorkflow = Workflow.newChildWorkflowStub(IPrepareWorkflow.class, getChildWorkflowOptions(foodProduct.getId()));
//            prepareWorkflow.prepare(foodProduct);
//        });
//
//        Workflow.await(() -> isPickByDriver);
//        Workflow.sleep(Duration.ofSeconds(10));
    }

//    private ChildWorkflowOptions getChildWorkflowOptions(String id) {
//        return new ChildWorkflowOptions.Builder()
//                .setWorkflowId(id)
//                .setTaskList(PREPARE_TASK_LIST)
//                .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.AllowDuplicate)
//                .setExecutionStartToCloseTimeout(Duration.ofDays(1))
//                .build();



    @Override
    public void assignToDriver(String driverId) {
        isPickByDriver = true;
    }
}
