package com.workflow.cadence.api;

import com.workflow.cadence.core.application.delivery.ICommandDeliveryHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
@AllArgsConstructor
public class DeliveryController{

    private ICommandDeliveryHandler commandDeliveryHandler;

    @PostMapping("/assign")
    public ResponseEntity<Void> assignDriver(@RequestBody AssignDriverApiRequest assignDriverApiRequest){
        commandDeliveryHandler.assignDriver(assignDriverApiRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
