package com.workflow.temporal.workflow.core.application.workflow.prepare;


import com.workflow.temporal.workflow.core.domain.FoodProduct;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface IPrepareWorkflow {

    @WorkflowMethod()
    void prepare(FoodProduct foodProduct);
}
