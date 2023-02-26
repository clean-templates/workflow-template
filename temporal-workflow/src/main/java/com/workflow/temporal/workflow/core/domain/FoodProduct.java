package com.workflow.temporal.workflow.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodProduct {
    private String id;
    private String name;
}
