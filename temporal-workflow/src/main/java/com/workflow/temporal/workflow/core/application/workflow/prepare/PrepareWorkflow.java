package com.workflow.temporal.workflow.core.application.workflow.prepare;


import com.workflow.temporal.workflow.core.domain.FoodProduct;

import java.time.Duration;

public class PrepareWorkflow implements IPrepareWorkflow {

    @Override
    public void prepare(FoodProduct foodProduct) {
//        Workflow.sleep(Duration.ofSeconds(10));
    }
}
