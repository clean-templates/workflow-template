package com.workflow.cadence.core.application.command;

import com.uber.cadence.WorkflowIdReusePolicy;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowOptions;
import com.uber.cadence.client.WorkflowStub;
import com.workflow.cadence.api.order.OrderApiRequest;
import com.workflow.cadence.core.application.workflow.main.IOrderWorkflow;
import com.workflow.cadence.core.domain.FoodProduct;
import com.workflow.cadence.core.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.stream.Collectors;

import static com.workflow.cadence.config.WorkerConfiguration.ORDER_TASK_LIST;

@Service
@AllArgsConstructor
@Async
public class CommandOrderHandler implements ICommandOrderHandler {

    private WorkflowClient workflowClient;

    @Override
    public void startOrder(OrderApiRequest request) {
        Order order = mapFrom(request);
        WorkflowStub workflowStub = workflowClient.newUntypedWorkflowStub("IOrderWorkflow::start", getWorkflowOptions(order.getId()));
        workflowStub.start(order);
    }

    private WorkflowOptions getWorkflowOptions(String id) {
        return new WorkflowOptions.Builder().setWorkflowId(id)
                .setTaskList(ORDER_TASK_LIST)
                .setExecutionStartToCloseTimeout(Duration.ofDays(10))
                .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.AllowDuplicate)
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
