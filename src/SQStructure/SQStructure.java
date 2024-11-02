package SQStructure;

import java.util.Arrays;
import java.util.Optional;

/**
 * The type SQStructure.
 */
public abstract class SQStructure {

    // TODO: lier package a repo github, mettre lien repo sur discord

    /**
     * The size.
     */
    protected int mysize = 1;
    /**
     * The array.
     */
    protected int[] myarray = new int[mysize];
    /**
     * The number of elements.
     */
    protected int mycount = 0;

    /**
     * Instantiates a new Sq structure fill with minus one.
     */
    public SQStructure(){
        fillMinusOne();
    }

    /**
     * Fill array with minus one.
     */
    public void fillMinusOne(){ Arrays.fill(myarray, -1); }

    /**
     * Count int.
     * Count the numbers of elements in the array
     * @return the int
     */
    public int Count(){
        Size();
        if (CountMinusOne(myarray) > 0) {
            mycount = mysize - CountMinusOne(myarray);
            return mycount;
        } if (CountMinusOne(myarray) == 0) {
            for (int el:myarray) {
                if (el != -1){
                    mycount++;
                }
            }
            return mycount;
        }
        return mycount = 0;
    }

    /**
     * Size int.
     * Return the length of the array
     * @return the int
     */
    public int Size(){
        mysize = myarray.length;
        return mysize;
    }

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
            System.out.println("The SQStructure is full");
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
            System.out.println("The SQStructure is empty");
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
        System.out.println("The SQStructure is cleared");
    }

    public static int CountMinusOne(int[] tab){
        int nbrMinusOne = 0;
        for (int j : tab) {
            if (j == -1) {
                nbrMinusOne++;
            }
        }
        return nbrMinusOne;
    }

}

