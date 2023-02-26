package com.workflow.cadence.core.application.workflow.main;

import com.uber.cadence.activity.ActivityMethod;
import com.workflow.cadence.core.domain.Order;

public interface IOrderActivity {

    @ActivityMethod(scheduleToCloseTimeoutSeconds = 300)
    boolean validate(Order order);


}
