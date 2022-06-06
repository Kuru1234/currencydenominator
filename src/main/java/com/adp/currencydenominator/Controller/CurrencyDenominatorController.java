package com.adp.currencydenominator.Controller;

import com.adp.currencydenominator.Service.CurrencyDenominatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyDenominatorController {

    @Autowired
    CurrencyDenominatorService currencyDenominatorService;

    @RequestMapping(value = "/",
            consumes = {"application/json"},
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<String> convertToCoins(@RequestParam Integer bill) {
        try {
            if (currencyDenominatorService.isVaildInput(bill)) {
                String result = currencyDenominatorService.convertToCoins(bill);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Not a vaild input :" + bill, HttpStatus.BAD_REQUEST);
            }

        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Bad Request" + bill, HttpStatus.BAD_REQUEST);
        }
    }
}
