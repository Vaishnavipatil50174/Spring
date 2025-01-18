package com.epam.notificationsystemusingspringboot;

import java.util.Scanner;

public class Trying {
    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        int n= scn.nextInt();

        int low=1,high=n;
        while (low<=high){
            int mid=(low+high)/2;
            int msq=mid*mid;

            if(msq==n){
                System.out.println("its perfect");
                break;
            } else if (msq>n) {
                high=mid-1;

            }
            else {
                low=mid+1;
            }
        }

    }
}
