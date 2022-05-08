package com.greatlearning.skyscrapper;

import java.util.*;

public class SkyScraper {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //printing input for user
        System.out.println("Enter the total number of floors in the building");

        Queue<Integer> queue = new LinkedList<>();

        int floors = sc.nextInt();

        //looping for getting input from user
        for(int i = 1; i<=floors;i++){
            System.out.println("enter the floor size given on day : "+i);
            int size = sc.nextInt();
            queue.add(size);
        }

        System.out.println("The order of construction is as follows:");

        // determining order of construction
        int lastFloor = floors;
        List<Integer> discardedArray = new ArrayList<>();
        for(int day = 1;day<=floors;day++){
            int val = queue.poll();

            //printing floor values if there is a match
            if(val == lastFloor){
                System.out.println("Day : "+day);
                System.out.print(val+ "\t");
                lastFloor = lastFloor-1;
                if(!discardedArray.isEmpty()){
                    List<Integer> valuesToDelete = new ArrayList<>();
                    for(int eachDiscValue : discardedArray) {
                        if (eachDiscValue == lastFloor) {
                            System.out.print(eachDiscValue + "\t");
                            lastFloor--;
                            valuesToDelete.add(eachDiscValue);
                        }
                    }
                    //removing all the placed floors
                    discardedArray.removeAll(valuesToDelete);
                }
                System.out.println("\n");
            // if the value is a no match adding it to a different list
            }else{
                System.out.println("Day : "+day);
                discardedArray.add(val);
            }
        }


    }
}
