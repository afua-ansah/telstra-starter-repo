package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activate")
public class SimCardActivatorController {
    @Autowired
    private SimCardActivationHandler activationHandler;

    @Autowired
    private SimCardRepository repository;

    @PostMapping(path = "/", consumes = "application/json")
    public void routeSimActivation(@RequestBody SimCard simCard){
        ActivationResult activationResult = activationHandler.activate(simCard);
        String iccid = simCard.getIccid();
        String email = simCard.getCustomerEmail();
        boolean active = activationResult.getSuccess();
        repository.save(new SimCard(iccid, email, active));
    }

    @GetMapping(path = "/", produces = "application/json")
    public SimCard getSimCard(@RequestParam long simCardId) {
        SimCard simCard = repository.findById(simCardId);
        return simCard;
    }

}
