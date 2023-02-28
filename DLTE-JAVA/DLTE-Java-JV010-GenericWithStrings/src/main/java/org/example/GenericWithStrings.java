package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class GenericWithStrings {
    public static void main(String[] args){
        Operations<String> objectString = new Operations<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        String[] genericArray = new String[];
        int  size = sc.nextInt();
        for(int i=0;i<size;i++){
            genericArray[i]=sc.next();
        }
        String converted = Arrays.toString(genericArray);
        objectString.binarySearch(converted);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor

class Operations<T> {
    Scanner sc = new Scanner(System.in);
    private T[] objects;
    public void binarySearch(String abc){
        byte[] convertedBytes = abc.getBytes();
        convertedBytes= Arrays.sort(convertedBytes);
        int start = 0;
        int end = convertedBytes.length;
        int mid = (end + start)/2;
        String key = sc.nextLine();
        byte[] keyByte = key.getBytes();
        if(keyByte[0]<convertedBytes[end] || keyByte[0]>convertedBytes[start]){
            if(keyByte[0]>convertedBytes[mid]){
                start = mid + 1;
                mid = (end + start)/2;
            }
            else if(keyByte[0]<convertedBytes[mid]){
                end = mid - 1;
                mid = (end + start)/2;

            }
            else if (keyByte[0] == convertedBytes[mid]){
                System.out.println("key found: "+keyByte[0]);
            }
        }
    }
}