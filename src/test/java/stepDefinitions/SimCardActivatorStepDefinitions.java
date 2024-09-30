package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.telstra.simcardactivator.ActivationResult;
import au.com.telstra.simcardactivator.SimCardRecord;
import au.com.telstra.simcardactivator.SimCardActivator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private SimCardRecord simCard;

    @Given("SIM card ICCID is {string}")
    public void simcard_is(String iccid) {
        this.simCard = new SimCardRecord(iccid, "random@yahoo.com", true);
    }

    @When("I ask whether it's activated")
    public void i_ask_whether_it_s_activated() {
        restTemplate.postForObject("http://localhost:8080/activate/", this.simCard, ActivationResult.class);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedStatus) throws JsonMappingException, JsonProcessingException {
        String endpoint = this.simCard.getIccid().equals("1255789453849037777") ? "?simCardId=1" : "?simCardId=2";
        ResponseEntity<String> actualStatus = restTemplate.getForEntity("http://localhost:8080/activate/" + endpoint, String.class);

        SimCardRecord response = objectMapper.readValue(actualStatus.getBody(), SimCardRecord.class);
        String activeStatus = response.getActivationSuccess() ? "true" : "false"; // Convert boolean to String
        System.out.println(activeStatus);
        assertEquals(expectedStatus, activeStatus);
    }

}