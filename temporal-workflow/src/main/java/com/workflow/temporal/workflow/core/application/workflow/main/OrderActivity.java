package com.workflow.temporal.workflow.core.application.workflow.main;

import com.workflow.temporal.workflow.core.application.event.IEventManager;
import com.workflow.temporal.workflow.core.application.validator.IValidateManager;
import com.workflow.temporal.workflow.core.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderActivity implements IOrderActivity {


    private IEventManager eventManager;
    private IValidateManager validateManager;

    @Override
    public boolean validate(Order order) {
        boolean isValid = validateManager.validate(order);
        if(isValid)
            eventManager.publish(order);
        return isValid;

    }


}
