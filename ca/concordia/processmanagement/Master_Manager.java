package ca.concordia.processmanagement;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Master_Manager implements Process_Manager {
    Queue<ProcessControlBlock> ready_queue = new LinkedList<>();
    PIDManager PID_MANAGER = new PIDManager();

    @Override
    public void terminateProcess(int pid, PIDManager pidManager) {
        try{
            pidManager.releasePid(pid);}
        catch(Exception e){
            throw new ArithmeticException("pid was already set to zero therefore " +
                    "the process was already terminated");
        }
    }


    @Override
    public int createProcess(PIDManager pidManager) {
        try{
            int pid = pidManager.allocatePid();
            boolean process_status = true;
            ProcessControlBlock processControlBlock = new ProcessControlBlock(pid, process_status);
            System.out.println("this is the pid " + pid);
            return pid;}
        catch(Exception e) {
            throw new ArithmeticException("something went wrong unable to create " +
                    "and allocate the process");
        }
    }

    public void create_process(){
        try {
            int pid = createProcess(PID_MANAGER);
            ProcessControlBlock controlBlock = new ProcessControlBlock(pid, true);
            ready_queue.add(controlBlock);
        }
        catch(Exception e){
            throw new ArithmeticException("unable to assign pid");
        }
    }

    public void Terminate_Process(int pid){
        terminateProcess(pid, PID_MANAGER);
        boolean succes = false;
        // we need to remove element from the queue to find the specific process and then add the
        // removed items back once we found the correct process control bloc k
        Queue<ProcessControlBlock> temp = new LinkedList<>();
        for (int i =0; i < ready_queue.size(); i++){
            ProcessControlBlock block  = ready_queue.remove();
            int element = block.getPID();
            if(element == pid){
                // put all the ProcessControlBlocks that are in temp back in the ready queue
                for (int y =0;y < temp.size(); y++){
                    ready_queue.add(temp.remove());
                }
                System.out.println("the process was terminated pid :" + pid);
                succes  = true;
                break;
            }
            temp.add(block);
        }
        for (int y =0;y < temp.size(); y++){
            ready_queue.add(temp.remove());
        }
        if (!succes) {System.out.println("unable to find the request pid");}
    }
    public void Print_Ready_Queue(){
        System.out.println("size of the queue: " + ready_queue.size());
        Queue<ProcessControlBlock> temp = new LinkedList<>();
        List<Integer> list=new ArrayList<Integer>();
        for(int i = 0; i < ready_queue.size(); i++){
            ProcessControlBlock process_block = ready_queue.remove();
            int pid = process_block.getPID();
            temp.add(process_block);
            list.add(pid);
        }
        for(int i = 0; i < ready_queue.size(); i++){
            ProcessControlBlock process_block = temp.remove();
            ready_queue.add(process_block);
        }
    }
}
