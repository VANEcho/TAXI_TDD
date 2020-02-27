package com.jiker.keju.taxi;

import java.util.Arrays;

public class TaxiCalculator {
    String receipt="";
    public TaxiCalculator(String dataInfo) {
        Arrays.asList(dataInfo.split(","))
                .stream()
                .forEach(data->{
                    String[] dataValue = data.split("&");
                    receipt = receipt + calculator(dataValue[0],dataValue[1]) + "\\n";
                });
    }

    private String calculator(String miles, String time) {
        int price = 6;
        if (Double.valueOf(miles) <= 2){
            price = (int) Math.round(price + 0.25*Double.valueOf(time));
        }else if (Double.valueOf(miles)<=8){
            price = (int) Math.round(price + (Double.valueOf(miles)-2)*0.8);
        }else {
            price = (int) Math.round(price + (Double.valueOf(miles)-2)*0.8 + (Double.valueOf(miles)-8)*0.4 );
        }
        return "收费" + String.valueOf(price) + "元";
    }

    public String getReceipt(){
        return receipt.substring(0,receipt.length()-2);
    }
}
