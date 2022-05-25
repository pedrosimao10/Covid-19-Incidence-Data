package com.uatqs.hw1.controller;

import com.uatqs.hw1.service.AppService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AppController.class)
public class AppControllerITTest {

    @MockBean
    private AppService appService;

    @Autowired
    private MockMvc mvc;

    @DisplayName("AppControllerITTest Test - Get Cache")
    @Test
    public void getCache() throws Exception{
        mvc.perform(get("/cache")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

}
