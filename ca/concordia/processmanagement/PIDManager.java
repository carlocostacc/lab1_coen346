package ca.concordia.processmanagement;

import java.util.BitSet;

public class PIDManager {
    static final int MIN_PID = 300;
    static final int MAX_PID = 500;
    BitSet bitSet = new BitSet(MAX_PID);
    void allocateMap(){
        try{
            bitSet.clear();
        }
        catch (Exception e){
            throw new ArithmeticException("bitset was not created successfully");
        }

    }
    int allocatePid(){
        // TODO fix error detection the function doesn't return an error after creating more than 200 processes
        // TODO Make the bitSet list start at value 200 and end at value 500
        try{
            int index = bitSet.nextClearBit(MIN_PID);
            if(index <= MAX_PID){
                bitSet.flip(index);
                return index;
            }
            else{

                throw new ArithmeticException("unable to allocate pid");
                }

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            return 505;
        }

    }

    void releasePid(int pid){
        boolean value = bitSet.get(pid);
        if (value){
            bitSet.flip(pid);
        }
        else{
            throw new ArithmeticException("pid is already set to 0");
        }
    }
}
