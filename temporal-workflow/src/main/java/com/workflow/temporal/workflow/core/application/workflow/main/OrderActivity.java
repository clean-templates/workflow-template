package com.workflow.temporal.workflow.core.application.workflow.main;

import com.workflow.temporal.workflow.core.application.event.IEventManager;
import com.workflow.temporal.workflow.core.application.validator.IValidateManager;
import com.workflow.temporal.workflow.core.domain.Order;
import io.temporal.activity.Activity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderActivity implements IOrderActivity {


    private IEventManager eventManager;
    private IValidateManager validateManager;

    @Override
    public boolean validate(Order order) {
        log.info("Workflow logs:" + Activity.getExecutionContext().getInfo().getWorkflowId());
        boolean isValid = validateManager.validate(order);
        if(isValid)
            eventManager.publish(order);
        return isValid;

    }


}
