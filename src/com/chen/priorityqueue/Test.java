package com.chen.priorityqueue;

import java.util.Comparator;  
import java.util.PriorityQueue;  
import java.util.Queue;  
  
public class Test {  
    private String name;  
    private int population;  
    public Test(String name, int population)  
    {  
        this.name = name;  
        this.population = population;  
    }  
    public String getName()  
    {  
         return this.name;  
    }  
  
    public int getPopulation()  
    {  
         return this.population;  
    }  
    public String toString()  
    {  
         return getName() + " - " + getPopulation();  
    }  
    public static void main(String args[])  
    {  
        Comparator<Test> OrderIsdn =  new Comparator<Test>(){  
            public int compare(Test o1, Test o2) {  
                // TODO Auto-generated method stub  
                int numbera = o1.getPopulation();  
                int numberb = o2.getPopulation();  
                if(numberb > numbera)  
                {  
                    return -1;  
                }  
                else if(numberb<numbera)  
                {  
                    return 1;  
                }  
                else  
                {  
                    return 0;  
                }  
              
            }  
  
              
              
        };  
        Queue<Test> priorityQueue =  new PriorityQueue<Test>(11,OrderIsdn);  
          
                  
              
        Test t1 = new Test("t1",1);  
        Test t3 = new Test("t3",3);  
        Test t2 = new Test("t2",2);  
        Test t4 = new Test("t4",0);  
        priorityQueue.add(t1);  
        priorityQueue.add(t3);  
        priorityQueue.add(t2);  
        priorityQueue.add(t4);  
        System.out.println(priorityQueue.poll().toString());
        System.out.println(priorityQueue.poll().toString());
        System.out.println(priorityQueue.poll().toString());
        System.out.println(priorityQueue.poll().toString());
    }  
}  