package SQStructure;

import java.util.Arrays;
import java.util.Optional;

/**
 * The type Stack.
 */
public class Stack extends SQStructure {
    // Methods here are completely redundant except for the printed strings, that class has no true interest
    /**
     * Push.
     * Add a new element in the array, if the array is full scale it up
     * @param val the value of the new element
     * modifier qd count < 0 et count > size
     */
    public void Push(int val){
        int tmp = Math.abs(val);
        Count();
        Size();
        if (mycount >= mysize || mysize == 0) {
            System.out.println("The Stack is full");
            myarray = Arrays.copyOf(myarray, myarray.length + 1);
            mysize++;
        } else {
            myarray[mycount] = tmp;
        }
        mycount++;
    }
    /**
     * Pop optional.
     * Remove an element of the array, if the array is not empty returns the value of the element
     * @return the optional
     */
    public Optional<Integer> Pop(){
        Count();
        Size();
        if (mysize == 0){
            System.out.println("The Stack is empty");
            return Optional.empty();
        } else {
            int poppedElmt = myarray[mysize - 1];
            if (poppedElmt == -1){
                myarray = Arrays.copyOf(myarray, myarray.length - 1);
                mysize--;
                mycount--;
                return Optional.empty();
            }
            myarray = Arrays.copyOf(myarray, myarray.length - 1);
            mysize--;
            mycount--;
            return Optional.of(poppedElmt);
        }
    }
    /**
     * Clear.
     * Clear the content of the array
     */
    public void Clear(){
        myarray = new int[0];
        Count();
        Size();
        System.out.println("The Stack is cleared");
    }
}
