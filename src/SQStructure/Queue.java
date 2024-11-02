package SQStructure;

import java.util.Arrays;
import java.util.Optional;

/**
 * The type Queue.
 */
public class Queue extends SQStructure{
    /**
     * A redefinition of Pop method for a Queue (remove first element)
     * @return the removed element if there is one
     */
    @Override
    public Optional<Integer> Pop() {
        Count();
        Size();
        if (mysize == 0){
            System.out.println("The Queue is empty");
            return Optional.empty();
        } else {
            int poppedElmt = myarray[0];
            if (poppedElmt == -1){
                myarray = Arrays.copyOfRange(myarray, 1, myarray.length);
                mysize--;
                mycount--;
                return Optional.empty();
            }
            myarray = Arrays.copyOfRange(myarray, 1, myarray.length);
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
        System.out.println("The Queue is cleared");
    }
}
