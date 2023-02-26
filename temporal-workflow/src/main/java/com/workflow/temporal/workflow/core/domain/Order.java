package com.workflow.temporal.workflow.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class Order {
    private String id;
    private List<FoodProduct> products;
}
