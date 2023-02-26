package com.workflow.temporal.workflow.core.application.command;

import com.workflow.temporal.workflow.api.order.OrderApiRequest;
import com.workflow.temporal.workflow.core.application.workflow.main.IOrderWorkflow;
import com.workflow.temporal.workflow.core.application.workflow.main.OrderWorkflow;
import com.workflow.temporal.workflow.core.domain.FoodProduct;
import com.workflow.temporal.workflow.core.domain.Order;
import io.temporal.api.enums.v1.WorkflowIdReusePolicy;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.stream.Collectors;

import static com.workflow.temporal.workflow.config.WorkerConfiguration.ORDER_TASK_LIST;


@Service
@AllArgsConstructor
@Async
public class CommandOrderHandler implements ICommandOrderHandler {

    private WorkflowClient workflowClient;

    @Override
    public void startOrder(OrderApiRequest request) {
        Order order = mapFrom(request);
        WorkflowStub workflowStub = workflowClient.newUntypedWorkflowStub("IOrderWorkflow", getWorkflowOptions(order.getId()));
        workflowStub.start(order);
    }

    private WorkflowOptions getWorkflowOptions(String id) {
        return  WorkflowOptions.newBuilder()
                .setWorkflowId(id)
                .setTaskQueue(ORDER_TASK_LIST)
                .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.WORKFLOW_ID_REUSE_POLICY_ALLOW_DUPLICATE)
                .setWorkflowExecutionTimeout(Duration.ofDays(10))
                .build();
    }

    private Order mapFrom(OrderApiRequest request) {
        return Order.builder()
                .id(request.getId())
                .products(request.getFoodItemsList().stream().map(foodItems ->
                        FoodProduct.builder()
                                .name(foodItems.getName())
                                .id(foodItems.getId())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
