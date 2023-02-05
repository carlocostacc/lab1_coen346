package ca.concordia.processmanagement;

import java.util.BitSet;

public class PIDManager {
    static final int MIN_PID = 300;
    static final int MAX_PID = 500;
    BitSet bitSet = new BitSet();
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
            int index = bitSet.nextClearBit(0);
            if(index <= 200){
                bitSet.flip(index);
                return index;
            }
            else{

                System.out.println("unable to allocate pid");
                }

        }
        catch(Exception e){
            return 0;
        }
        return 0;
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
