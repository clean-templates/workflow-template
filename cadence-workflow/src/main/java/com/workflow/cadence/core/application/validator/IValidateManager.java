package com.workflow.cadence.core.application.validator;

import com.workflow.cadence.core.domain.Order;

public interface IValidateManager {

    boolean validate(Order order);
}
