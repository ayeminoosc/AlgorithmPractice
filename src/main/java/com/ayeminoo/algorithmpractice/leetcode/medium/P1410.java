package com.ayeminoo.algorithmpractice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/html-entity-parser/description/
 */
public class P1410 {
    public String entityParser(String text) {
        Map<String, Character> special = new HashMap<>();
        special.put("&quot;", '\"');
        special.put("&apos;", '\'');
        special.put("&amp;", '&');
        special.put("&gt;", '>');
        special.put("&lt;", '<');
        special.put("&frasl;", '/');
        boolean started = false;

        StringBuffer buffer = new StringBuffer();
        StringBuffer specialBuffer = new StringBuffer();
        for(int i = 0; i<text.length();i++){

            if(text.charAt(i) == ' '){
                if(started) buffer.append(specialBuffer);
                started = false;
                specialBuffer.setLength(0);
                buffer.append(' ');
            }else if(text.charAt(i) == '&'){
                started = true;
                buffer.append(specialBuffer);
                specialBuffer.setLength(0);
                specialBuffer.append('&');
            }else if(started){
                specialBuffer.append(text.charAt(i));
                if(text.charAt(i)==';'){
                    started=false;
                    //replace logic
                    Character replaced = special.get(specialBuffer.toString());
                    if(replaced != null){
                        buffer.append(replaced);
                    }else {
                        buffer.append(specialBuffer);
                    }
                    specialBuffer.setLength(0);
                }
            }else {
                buffer.append(text.charAt(i));
            }
        }
        if(started) buffer.append(specialBuffer);
        return buffer.toString();
    }

    public static void main(String[]args){
        String text = "&&& &amp; is a &"; //"&amp; is an HTML entity but &ambassador; is not.";
        System.out.println(new P1410().entityParser(text));
    }
}
