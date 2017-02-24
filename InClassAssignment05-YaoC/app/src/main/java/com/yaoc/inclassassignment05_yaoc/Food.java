package com.yaoc.inclassassignment05_yaoc;

import java.io.Serializable;

/**
 * Created by YaoChen on 2/23/17.
 */

public class Food implements Serializable{
    String whatYouAte;
    double price;
    String emotion;
    boolean wasSpicy;
    boolean wasHealthy;
    boolean onADiet;


    public Food(String whatYouAte, double price, String emotion, boolean wasSpicy, boolean wasHealthy, boolean onADiet) {
        this.whatYouAte = whatYouAte;
        this.price = price;
        this.emotion = emotion;
        this.wasSpicy = wasSpicy;
        this.wasHealthy = wasHealthy;
        this.onADiet = onADiet;
    }

    @Override
    public String toString() {
        return "Choice{ "+'\n' +
                "what You Ate: " + whatYouAte +'\n' +
                "price: " + price +'\n'+
                "how was it? " + emotion +'\n' +
                "Had something Spicy? " + wasSpicy +'\n' +
                "was the food Healthy? " + wasHealthy +'\n' +
                "were you on A Diet? " + onADiet +'\n' +
                '}'+'\n'+'\n'+'\n';
    }
}
