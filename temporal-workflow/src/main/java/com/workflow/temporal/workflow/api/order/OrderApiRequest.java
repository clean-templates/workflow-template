package com.workflow.temporal.workflow.api.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderApiRequest {
    private String id;
    private List<FoodItems> foodItemsList;
}
