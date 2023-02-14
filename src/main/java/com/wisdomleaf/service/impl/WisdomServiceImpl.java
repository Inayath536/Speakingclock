/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.wisdomleaf.service.impl;

import com.wisdomleaf.service.WisdomService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
/**
 * @author Hidayath
 * @version $Id: WisdomServiceImpl.java, v 0.1 2023-02-13 7:10 PM Hidayath Exp $$
 */
@Service
public class WisdomServiceImpl implements WisdomService {
    private static final Logger logger = LoggerFactory.getLogger(WisdomServiceImpl.class);
    @Override
    public String convertNumberToWords(String time){
        if (logger.isInfoEnabled()) {
            logger.info("Service method is called ...");
        }
        String[] splitTime = time.split(":");
        int hours=0;
        int minutes=0;
        try{
            for(int i=0; i< splitTime.length; i++)
            {
                if(i==0){
                    hours= Integer.parseInt(splitTime[i]);
                }
                else {
                    minutes= Integer.parseInt(splitTime[i]);
                }
            }
        }
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormat Exception: invalid input string");
        }
        String printInWords= printWords(hours, minutes);
        return printInWords;
    }

    //This method prints the hours and minutes in to words
   private String printWords(int h, int m)
    {
        String nums[] = { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine",
        };
    String result="";
        if (m == 0)
            result="its "+nums[h] + " o' clock ";
        else if (m == 1)
            result="its "+"one minute past " +nums[h];
        else if (m == 59)
            result="its "+"one minute to " + nums[(h % 12) + 1];
        else if (m == 15)
            result="its "+"quarter past " + nums[h];
        else if (m == 30)
            result="its "+"half past " + nums[h];
        else if (m == 45)
            result="its "+"quarter to " + nums[(h % 12) + 1];
        else if (m <= 30)
            result="its "+ nums[m] + " minutes past " + nums[h];
        else if (m > 30)
            result="its "+ nums[60 - m] + " minutes to " + nums[(h % 12) + 1];
        return result;
    }
}