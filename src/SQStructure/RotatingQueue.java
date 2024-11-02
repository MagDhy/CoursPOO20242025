package SQStructure;

import java.util.Arrays;
import java.util.Optional;

/**
 * The type Rotating queue.
 */
public class RotatingQueue extends Queue {
    /**
     * Push.
     * Redefinition of Push to add element at the beginning of RotatingQueue if first place is empty in array
     * @param val the value of the new element
     */
    @Override
    public void Push(int val) {
        int tmp = Math.abs(val);
        Count();
        Size();
        if (mycount >= mysize || mysize == 0) {
            System.out.println("The RotatingQueue is full");
            myarray = Arrays.copyOf(myarray, myarray.length + 1);
            mysize++;
        } else if (mysize > 0 && myarray[0] == -1) {
            myarray[0] = tmp;
        } else {
            myarray[mycount] = tmp;
        }
        mycount++;
    }

    /**
     * Redefinition of Pop method to not shrink the list at the beginning but use the spot for new element if RotatingQueue is full
     * @return popped element if Queue not empty
     */
    @Override
    public Optional<Integer> Pop() {
        Count();
        Size();
        if (mysize == 0){
            System.out.println("The RotatingQueue is empty");
            return Optional.empty();
        } else {
            int poppedElmt = myarray[0];
            if (poppedElmt == -1){
                mysize--;
                mycount--;
                return Optional.empty();
            }
            myarray[0] = -1;
            mycount--;
            mysize = mysize - CountMinusOne(myarray);
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
        System.out.println("The SQStructure is cleared");
    }
}
