package com.dimon.test;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Solution {

    private boolean flag = true;

    public void runPr(LinkedHashMap<String, Object> json, int count) {
        flag = true;
        run(json,count);
    }

    private void run(LinkedHashMap<String, Object> json, int count) {
        Set<String> keys = json.keySet();

        for (String key : keys) {
            if (flag && key.equals("dark green")){
                // TODO: Ak naozaj potrebujete zobraziť prvú tmavozelenú farbu s 5 bodkami, stačí nastaviť príznak na true, inak musíte nastaviť príznak na false
                System.out.println(".".repeat(count+1) +" " + key);
                flag = false;
            }else {
                System.out.println(".".repeat(count) + (((count == 0) ? "" : " ")) + key);
            }

            if (json.get(key) instanceof LinkedHashMap) {
                run((LinkedHashMap<String, Object>) json.get(key), (count + 2));
            }
        }

    }

    public int maxValue = Integer.MIN_VALUE;
    public void findMaxPr(LinkedHashMap<String, Object> json) {
        maxValue = Integer.MIN_VALUE;
        ArrayList<String> currentStack = new ArrayList<>();
        ArrayList<String> maxStack = new ArrayList<>();
        findMax(json,0, currentStack, maxStack);
        for (int i = 0;i < maxStack.size();i++) {
            System.out.print(maxStack.get(i) + ((i + 1)== maxStack.size() ? ": " : " -> "));
        }
        System.out.println(maxValue);
    }

    public void findMax(LinkedHashMap<String, Object> json, int count, ArrayList<String> currentStack, ArrayList<String> maxStack) {
        Set<String> keys = json.keySet();
        for (String key : keys) {
            if (currentStack.size() <= count ) {
                currentStack.add(key);
            } else {
                currentStack.set(count, key);
            }
            if(json.get(key) instanceof LinkedHashMap<?,?>) {
                findMax((LinkedHashMap<String, Object>) json.get(key), (count + 1), currentStack, maxStack);
            } else {
                int value = (Integer) json.get(key);
                if (maxValue < value) {
                    while (maxStack.size() < currentStack.size())
                        maxStack.add(null);
                    Collections.copy(maxStack, currentStack);
                    maxValue = value;
                }
            }
        }
    }
}
