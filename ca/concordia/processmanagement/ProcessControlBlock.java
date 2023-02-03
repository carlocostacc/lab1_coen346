package ca.concordia.processmanagement;

public class ProcessControlBlock {
    public int PID;
    public boolean process_status;
    public ProcessControlBlock(int pid, boolean status){
        PID = pid;
        process_status = status;
    }
}
