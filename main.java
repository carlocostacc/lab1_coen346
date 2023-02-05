import ca.concordia.processmanagement.Master_Manager;

public class main {
    public static void main(String []args){
        Master_Manager masterManager = new Master_Manager();
        for(int i = 0; i< 202;i++){
            masterManager.create_process();
        }

    }
}