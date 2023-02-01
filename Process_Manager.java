package ca.concordia.processmanagement;

public interface Process_Manager {
    PIDManager PID_MANAGER = new PIDManager();
    default int createProcess(){
        try{
            int pid = PID_MANAGER.allocatePid();
            boolean process_status = true;
            ProcessControlBlock processControlBlock = new ProcessControlBlock(pid, process_status);
            return pid;}
        catch(Exception e) {
            throw new ArithmeticException("something went wrong unable to create " +
                    "and allocate the process");
        }

    }
    default void terminateProcess(int pid){
        try{
        PID_MANAGER.releasePid(pid);}
        catch(Exception e){
            throw new ArithmeticException("pid was already set to zero therefore " +
                    "the process was already terminated");

        }

    }
}
