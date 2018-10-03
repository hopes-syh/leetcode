package com.syh.zdemo;

import java.io.*;
import java.util.*;

class Test {

}

public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }
    }

    public int value(int nums, int[][] citys){

        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        Stack<Integer> visiting = new Stack<Integer>();
        Stack<Integer> visited = new Stack<Integer>();
        for(int i=0; i<nums-1; i++){
            doValue(citys, i, visiting, visited);

            pathsList.add(Arrays.asList(visited.toArray(new Integer[]{})));
            visiting = new Stack<Integer>();
            visited = new Stack<Integer>();
        }

        int doX = 0, value = 0;
        List<Integer> paths1, paths2;
        for(int i=0; i<pathsList.size(); i++){
            paths1 = pathsList.get(i);
            doX = 0;

            for(int j=i+1; j<pathsList.size(); j++){
                paths2 = pathsList.get(j);

                for(Integer p1 : paths1){
                    if(paths2.contains(p1)){
                        doX = 1;
                        break;
                    }
                }

                if(doX == 0){
                    int tmpvalue = paths1.size() * paths2.size();
                    value = value>tmpvalue ? value : tmpvalue;
                }
            }
        }

        return value;
    }

    private void doValue(int[][] citys, int inode, Stack<Integer> visiting, Stack<Integer> visited) {
        if(visited.contains(inode)){
            return;
        }
        if(visiting.contains(inode)){
            return;
        }

        visiting.push(inode);
        for(int i=0; i<citys.length; i++){
            if(citys[i][0] == inode){
                visited.push(citys[i][1]);
                doValue(citys, citys[i][1], visiting, visited);
            }
            else if(citys[i][1] == inode){
                visited.push(citys[i][0]);
                doValue(citys, citys[i][0], visiting, visited);
            }
        }
        visiting.pop();
    }
}