package com.workflow.temporal.workflow.core.application.validator;

import com.workflow.temporal.workflow.core.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class ValidateManager implements IValidateManager {

    @Override
    public boolean validate(Order order) {
        return order.getProducts().size() > 0;
    }
}
