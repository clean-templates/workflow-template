package com.workflow.cadence.api.order;

import com.workflow.cadence.core.application.command.ICommandOrderHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private ICommandOrderHandler commandOrderHandler;

    @PostMapping("/start")
    public ResponseEntity<Void> startOrder(@RequestBody OrderApiRequest request){
        commandOrderHandler.startOrder(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
