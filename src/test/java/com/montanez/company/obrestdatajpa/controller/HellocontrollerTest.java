package com.montanez.company.obrestdatajpa.controller;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HellocontrollerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHolaMundo() throws Exception {
        String response = restTemplate.getForObject("http://localhost:" + port + "/saludo", String.class);
        assert(response).equals("Hola mundo que tal");

    }

    @Test
    void Hello() {
        ResponseEntity<String> response=
                restTemplate.getForEntity("/saludo", String.class);
        assertEquals("Hola mundo que tal", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

    }

}