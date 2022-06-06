package com.adp.currencydenominator.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CurrencyDenominatorService {
    @Value("${app.noofcoins}")
    private Integer noOfCoins;

    public String convertToCoins(Integer bill){
        // Assume utilizing the least amount of coins
        Double [] coinsArray = {0.25,0.10,0.05,0.01};
        String result = "";
        Integer availableCoins = noOfCoins;
        Integer coinsCount=availableCoins;
        Double amount = new Double(bill);
        int n =coinsArray.length;
        for (int i=0 ; i<n; i++) {
            double noofcoins = amount/coinsArray[i];

            if (coinsCount >=availableCoins*n) {
                return "Not enough coins to make change";
            }

            if (noofcoins < availableCoins) {
                return result + noofcoins+ " x " + coinsArray[i].toString() + " ";
            } else {
                result = result + availableCoins + " x " + coinsArray[i].toString() + " ";
                amount=amount - availableCoins *coinsArray[i];
                coinsCount=coinsCount+availableCoins;
            }



        }

        return result;
    }
    public boolean isVaildInput(Integer bill) {
        Integer [] billsArray = {1, 2, 5, 10, 20, 50, 100};
        return Arrays.asList( billsArray).contains(bill);
    }
}

