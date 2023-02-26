package com.workflow.temporal.workflow.core.application.workflow.prepare;


import com.workflow.temporal.workflow.core.domain.FoodProduct;

public interface IPrepareWorkflow {

//    @WorkflowMethod()
    void prepare(FoodProduct foodProduct);
}
