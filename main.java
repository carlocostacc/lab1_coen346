import ca.concordia.processmanagement.Master_Manager;

public class main {
    public static void main(String []args){
        Master_Manager masterManager = new Master_Manager();
        for(int i = 0; i< 200;i++){
            masterManager.createProcess();
        }

        masterManager.terminateProcess(499);
        masterManager.createProcess();
        masterManager.createProcess();
        masterManager.terminateAllProcess();
        masterManager.createProcess();
        masterManager.Print_Ready_Queue();

    }
}