package com.workflow.temporal.workflow.core.application.command;

import com.workflow.temporal.workflow.api.order.OrderApiRequest;
import com.workflow.temporal.workflow.core.domain.FoodProduct;
import com.workflow.temporal.workflow.core.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Async
public class CommandOrderHandler implements ICommandOrderHandler {

//    private WorkflowClient workflowClient;

    @Override
    public void startOrder(OrderApiRequest request) {
//        Order order = mapFrom(request);
//        WorkflowStub workflowStub = workflowClient.newUntypedWorkflowStub("IOrderWorkflow::start", getWorkflowOptions(order.getId()));
//        workflowStub.start(order);
    }

//    private WorkflowOptions getWorkflowOptions(String id) {
//        return new WorkflowOptions.Builder().setWorkflowId(id)
//                .setTaskList(ORDER_TASK_LIST)
//                .setExecutionStartToCloseTimeout(Duration.ofDays(10))
//                .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.AllowDuplicate)
//                .build();
//    }

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
