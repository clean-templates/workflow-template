package com.workflow.temporal.workflow.core.application.validator;


import com.workflow.temporal.workflow.core.domain.Order;

public interface IValidateManager {

    boolean validate(Order order);
}
