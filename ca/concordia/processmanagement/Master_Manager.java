package ca.concordia.processmanagement;
import java.util.LinkedList;
import java.util.Queue;

public class Master_Manager implements Process_Manager {
    Queue<ProcessControlBlock> ready_queue = new LinkedList<>();
    PIDManager PID_MANAGER = new PIDManager();
    void create_process(){
        try {
            int pid = createProcess(PID_MANAGER);
            ProcessControlBlock controlBlock = new ProcessControlBlock(pid, true);
            ready_queue.add(controlBlock);
        }
        catch(Exception e){
            throw new ArithmeticException("unable to assign pid");
        }
    }

    void Terminate_Process(int pid){
        terminateProcess(pid, PID_MANAGER);
        // we need to remove element from the queue to find the specific process and then add the
        // removed items back once we found the correct process control bloc k
        Queue<ProcessControlBlock> temp = new LinkedList<>();
        for (int i =0;i < ready_queue.size(); i++){
            ProcessControlBlock block  = ready_queue.remove();
            int element = block.getPID();
            if(element == pid && temp.size() != 0){
                // put all the ProcessControlBlocks that are in temp back in the ready queue
                for (int y =0;y < temp.size(); y++){
                    ready_queue.add(temp.remove());
                }
                System.out.println("the process was terminated pid :" + pid);
                break;
            }
            temp.add(block);
        }
        for (int y =0;y < temp.size(); y++){
            ready_queue.add(temp.remove());
        }
        System.out.println("unable to find the request pid");
    }
}
