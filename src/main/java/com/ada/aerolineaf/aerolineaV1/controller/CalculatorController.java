package com.ada.aerolineaf.aerolineaV1.controller;

import com.ada.aerolineaf.aerolineaV1.model.CalculatorResponse;
import com.ada.aerolineaf.aerolineaV1.service.ICalculator;
import com.ada.aerolineaf.aerolineaV1.service.impl.CalculatorImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/aerolineaf/ada/v1/calculator")
public class CalculatorController {


    private ICalculator calculator = new CalculatorImpl();

    @GetMapping(path = "/suma/{a}/{b}")
    public @ResponseBody
    Integer sumar(@PathVariable("a") int a, @PathVariable("b") int b) {
        try {
            return calculator.suma(a, b);

        } catch (Exception e) {
            return 0;
        }
    }
    @GetMapping(path = "/div/{a}/{b}")
    public @ResponseBody
    ResponseEntity<CalculatorResponse> div(@PathVariable("a") int a, @PathVariable("b") int b) {
        CalculatorResponse response = new CalculatorResponse();

        try {
            response.setResp(calculator.division(a, b));
            response.setMsg("OK");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.setResp(0);
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}