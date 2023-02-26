package com.workflow.temporal.workflow.core.application.workflow.main;


import com.workflow.temporal.workflow.core.domain.Order;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface IOrderActivity {

    @ActivityMethod(name = "validate")
    boolean validate(Order order);


}
