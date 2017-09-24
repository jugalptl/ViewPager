package com.example.igroup.viewpager.Network;

import java.util.LinkedList;

/**
 * Created by iGroup on 3/24/2017.
 */
public class SumLinkedList {

    public static void main(String[] args)
    {
        System.out.println("Hello Java");
        LinkedList<Integer> num1 = new LinkedList<>();
        LinkedList<Integer> num2 = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        num1.add(5); num2.add(5);
        num1.add(5); num2.add(5);
        num1.add(5);num2.add(5);



        int sum =0;
        int carry =0;
        for(int i=num1.size()-1;i>=0;i--)
        {
            sum = carry+num1.get(i) + num2.get(i);
            if(sum>=10) {
                //sum = carry + num1.get(i) + num2.get(i);
                carry = sum / 10;
                sum = sum%10;
                result.addFirst(sum);

            }
            else{
              //  sum = num1.get(i) + num2.get(i) ;

               result.addFirst(sum);//  result.set(i,sum);
                carry=0;
            }

        }
        for(int i=0,j=0,k=0;i<num1.size() && j<num2.size() && k<result.size();i++,j++,k++) {


            System.out.println("Num1:"+num1.get(i)+"Num2:"+num2.get(j));
        }
for(int k=0;k<result.size();k++)
{
    System.out.println("Result:"+result.get(k));
}




    }
}
