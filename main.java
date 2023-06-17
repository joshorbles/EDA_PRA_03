package Practica3;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        TDAHeap<Integer> myArray = new TDAHeap<>(6);
        myArray.insert(2);
        myArray.insert(9);
        myArray.insert(1);
        myArray.insert(3);
        myArray.insert(0);
        myArray.insert(2);
        myArray.insert(9);
        myArray.insert(1);
        myArray.insert(3);
        myArray.insert(0);
        
        System.out.println(myArray);

        myArray.delete();
        myArray.delete();

        System.out.println(myArray);
        
    }
}
