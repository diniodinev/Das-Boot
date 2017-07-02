package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Matchers.notNull;

import java.io.IOException;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.model.Shipwreck;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShipwrecksWebIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    
    

    @Test
    public void testSave() throws JsonProcessingException, IOException {
        // relative paths to http://localhost:${local.server.port}
        String shipName = "Titanic";
        Shipwreck titanicShipwrack = new Shipwreck();
        titanicShipwrack.setName(shipName);
        titanicShipwrack.setCondition("Bad.");
        titanicShipwrack.setDepth(3000);
        titanicShipwrack.setYearDiscovered(1965);

        ResponseEntity<String> response = this.restTemplate.postForEntity("/api/v1/shipwrecks", titanicShipwrack,
                String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());

        assertThat(responseJson.isMissingNode(), is(false));
        assertThat(responseJson.get("id"), notNullValue());
        assertThat(responseJson.get("name").asText(), equalTo(shipName));
    }

    @Test
    public void test() throws JsonProcessingException, IOException {
        // relative paths to http://localhost:${local.server.port}
        ResponseEntity<String> response = this.restTemplate.getForEntity("/api/v1/shipwrecks", String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());

        assertThat(responseJson.isMissingNode(), is(false));
        assertThat(responseJson.toString().length(), greaterThanOrEqualTo(0));
    }
}
