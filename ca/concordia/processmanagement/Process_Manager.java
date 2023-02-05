package ca.concordia.processmanagement;

public interface Process_Manager {
    default int createProcess(PIDManager pidManager){
        try{
            int pid = pidManager.allocatePid();
            boolean process_status = true;
            ProcessControlBlock processControlBlock = new ProcessControlBlock(pid, process_status);
            return pid;}
        catch(Exception e) {
            throw new ArithmeticException("something went wrong unable to create " +
                    "and allocate the process");
        }
    }
    default void terminateProcess(int pid, PIDManager pidManager){
        try{
        pidManager.releasePid(pid);}
        catch(Exception e){
            throw new ArithmeticException("pid was already set to zero therefore " +
                    "the process was already terminated");
        }
    }
}
