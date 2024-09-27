package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activate")
public class SimCardActivatorController {
    @Autowired
    private SimCardActivationHandler activationHandler;

    @PostMapping(path = "/", consumes = "application/json")
    public void routeSimActivation(@RequestBody SimCard simCard){
        ActivationResult activationResult = activationHandler.activate(simCard);
        System.out.println(activationResult.getSuccess());
    }

}
