package com.mateuszwalczyk.buffetapp.domain;

//In process
public class OrderTime {

    public static void countingDown(int time){
        while(time >= 0){
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        time--;
    }
}
