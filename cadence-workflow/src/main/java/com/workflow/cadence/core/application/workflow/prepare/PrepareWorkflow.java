package com.workflow.cadence.core.application.workflow.prepare;

import com.uber.cadence.workflow.Workflow;
import com.workflow.cadence.core.domain.FoodProduct;

import java.time.Duration;

public class PrepareWorkflow implements IPrepareWorkflow{

    @Override
    public void prepare(FoodProduct foodProduct) {
        Workflow.sleep(Duration.ofSeconds(10));
    }
}
