package com.leonidlisin.resttest.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GetService {

    private final List<String> months = Arrays.asList(
            "январь", "февраль", "март", "апрель", "май", "июнь",
            "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь");

    public String getFormattedMonth(String s){
        String errorText = "INCORRECT INPUT DATA";
        try{
            int n = Integer.parseInt(s);
            if (n < 1 || n > 12) return errorText;
            return formatMonthTitle(months.get(n-1));
        }
        catch (NumberFormatException ex){
            System.out.println("exxeption nafig");
            return errorText;
        }
    }

    private String formatMonthTitle (String monthTitle){
        StringBuilder sb = new StringBuilder();
        monthTitle = monthTitle.toUpperCase();
        for (int i=0; i<monthTitle.length(); i++){
            sb.append(monthTitle.charAt(i));
            if (i < monthTitle.length()-1)
                sb.append("-");
        }
        return sb.toString();
    }

}
