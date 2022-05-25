package com.uatqs.hw1.httpconnect;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.text.ParseException;

import com.uatqs.hw1.exception.ApiNotRespondingException;

public class HttpClientAPITest {
    
    private HttpClientAPI httpClientAPI = new HttpClientAPI();

    @DisplayName("HttpClientAPITest Test 1: Request Successful")
    @Test
    public void requestSuccess() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException, ApiNotRespondingException{
        assertThat(httpClientAPI.doRequest("Canada", "can")).isNotEmpty();
    }

    @DisplayName("HttpClientAPITest Test 2: Request Invalid")
    @Test
    public void requestInvalid() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException, ApiNotRespondingException{
        assertEquals("[]", httpClientAPI.doRequest("Aveiro", "ua"));
    }
}
