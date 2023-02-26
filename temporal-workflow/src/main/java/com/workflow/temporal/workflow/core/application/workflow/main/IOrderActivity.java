package com.workflow.temporal.workflow.core.application.workflow.main;


import com.workflow.temporal.workflow.core.domain.Order;

public interface IOrderActivity {

//    @ActivityMethod(scheduleToCloseTimeoutSeconds = 300)
    boolean validate(Order order);


}
