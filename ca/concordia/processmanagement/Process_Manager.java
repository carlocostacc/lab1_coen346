package ca.concordia.processmanagement;

public interface Process_Manager {
    int createProcess();
    void terminateProcess(int pid);

    void terminateAllProcess( );

}
