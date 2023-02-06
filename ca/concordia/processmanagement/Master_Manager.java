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
            e.printStackTrace();
            System.out.println( "something went wrong !!!!" + e);
        }

    }

    @Override
    public int createProcess(PIDManager pidManager) {
        try{
            int pid = pidManager.allocatePid();
            boolean process_status = true;
            ProcessControlBlock processControlBlock = new ProcessControlBlock(pid, process_status);
            if(pid!=500)System.out.println("this is the pid " + pid);
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
            if(pid > 499)throw new ArithmeticException("something went wrong unable to create " +
                    "and allocate the process");
        }
        catch(Exception e){

            e.printStackTrace();
            System.out.println( "something went wrong !!!!" + e);
        }
    }

    public void Terminate_Process(int pid){
        try {
            terminateProcess(pid, PID_MANAGER);
            boolean succes = false;
            // we need to remove element from the queue to find the specific process and then add the
            // removed items back once we found the correct process control bloc k
            Queue<ProcessControlBlock> temp = new LinkedList<>();
            int size = ready_queue.size();
            int size2;
            for (int i =0; i < size; i++){
                ProcessControlBlock block  = ready_queue.remove();
                int element = block.getPID();
                System.out.println("PID : " + element);
                if(element == pid){
                    size2 = temp.size();
                    // put all the ProcessControlBlocks that are in temp back in the ready queue
                    for (int y =0;y < size2; y++){
                        ready_queue.add(temp.remove());
                    }
                    System.out.println("the process was terminated pid :" + pid);
                    succes  = true;
                    break;
                }
                temp.add(block);
            }
            size2 = temp.size();
            for (int y =0;y < size2; y++){
                ready_queue.add(temp.remove());
            }
            if (!succes) {throw new ArithmeticException("unable to find the requested pid");}
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println( "something went wrong !!!!" + e);
        }

    }
    public void Print_Ready_Queue(){
        System.out.println("size of the queue: " + ready_queue.size());
        Queue<ProcessControlBlock> temp = new LinkedList<>();
        List<Integer> list=new ArrayList<Integer>();
        int size  = ready_queue.size();
        for(int i = 0; i < size; i++){
            ProcessControlBlock process_block = ready_queue.remove();
            int pid = process_block.getPID();
            temp.add(process_block);
            list.add(pid);
        }
        System.out.println(list);
        size = temp.size();
        for(int i = 0; i < size; i++){
            ProcessControlBlock process_block = temp.remove();
            ready_queue.add(process_block);
        }
    }
}
