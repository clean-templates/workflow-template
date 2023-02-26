package com.workflow.cadence.core.application.validator;

import com.workflow.cadence.core.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class ValidateManager implements IValidateManager{

    @Override
    public boolean validate(Order order) {
        return order.getProducts().size() > 0;
    }
}
