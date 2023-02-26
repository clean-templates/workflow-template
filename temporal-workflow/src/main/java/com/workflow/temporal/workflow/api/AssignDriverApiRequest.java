package com.workflow.temporal.workflow.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AssignDriverApiRequest {
    private String driverId;
    private String orderId;
}
