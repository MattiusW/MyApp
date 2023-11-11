package com.mateuszwalczyk.gamex.utils;

import jakarta.transaction.Transactional;

import java.util.Set;

public class Ids {

    //Generate new ID to put game in map
    static public int getNewID(Set<Integer> existingIds){
        if(existingIds.isEmpty()){
            return 0;
        }
        else{
            Integer maxID = existingIds.stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return maxID + 1;
        }
    }
}
