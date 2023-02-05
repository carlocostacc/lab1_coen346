package ca.concordia.processmanagement;

public interface Process_Manager {
    int createProcess(PIDManager pidManager);
    void terminateProcess(int pid, PIDManager pidManager);
}
