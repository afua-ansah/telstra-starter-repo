package au.com.telstra.simcardactivator;

public class ActivationResult {
    private boolean success;

    public ActivationResult() {
    }

    public ActivationResult(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

}
