import ca.concordia.processmanagement.Master_Manager;

public class main {
    public static void main(String []args){
        Master_Manager masterManager = new Master_Manager();
        for(int i = 0; i< 200;i++){
            masterManager.create_process();
        }
        masterManager.Terminate_Process(499);
        masterManager.Print_Ready_Queue();
    }
}