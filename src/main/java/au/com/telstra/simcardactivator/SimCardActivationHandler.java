package au.com.telstra.simcardactivator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimCardActivationHandler {
    private final RestTemplate restTemplate;

    public SimCardActivationHandler(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

    public ActivationResult activate(SimCard simCard) {
        String endPoint = "http://localhost:8444/actuate";
        return restTemplate.postForObject(endPoint, simCard, ActivationResult.class);
    }

}
