package com.workflow.cadence.core.application.workflow.prepare;


import com.uber.cadence.workflow.WorkflowMethod;
import com.workflow.cadence.core.domain.FoodProduct;

public interface IPrepareWorkflow {

    @WorkflowMethod()
    void prepare(FoodProduct foodProduct);
}
