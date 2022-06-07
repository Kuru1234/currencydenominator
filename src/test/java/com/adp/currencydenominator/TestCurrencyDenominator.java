package com.adp.currencydenominator;


import com.adp.currencydenominator.Controller.CurrencyDenominatorController;
import com.adp.currencydenominator.Service.CurrencyDenominatorService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)

public class TestCurrencyDenominator extends CurrencydenominatorApplicationTests{

    private MockMvc mockMvc;

    @Mock
    private CurrencyDenominatorService currencyDenominatorService;

    @InjectMocks
    private CurrencyDenominatorController currencyDenominatorController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testconvertToCoins() throws Exception {

        currencyDenominatorController.convertToCoins("10");

        HttpStatus status = currencyDenominatorController.convertToCoins("10").getStatusCode();
        assertEquals(true, status.isError());
        String content = currencyDenominatorController.convertToCoins("10").getBody();
        assertEquals(content, "40.0 x 0.25");
    }
}
