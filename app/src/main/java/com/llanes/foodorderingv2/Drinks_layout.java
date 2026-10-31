package com.llanes.foodorderingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Drinks_layout extends AppCompatActivity {

    //for food swiping

    ImageView imageView2;

    TextView quantity, dName, dPrice;

    Button next, previous, plus, minus, atcbtnDrinks;

    int i;

    int qtyCounter;

    private int[] textureArrayWin = {R.drawable.icedcoffee, R.drawable.bluelemonade, R.drawable.icedtea, R.drawable.omsim};

    Button back; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_layout);

        FoodCart order = new FoodCart();
        atcbtnDrinks = (Button) findViewById(R.id.addtocartbtndrinks) ;
        atcbtnDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(qtyCounter == 0) {
                    return;
                }

                String qty = quantity.getText().toString();
                qty = qty.replaceAll("QTY : ", "");

                String prc = dPrice.getText().toString();
                prc = prc.replaceAll("₱","");

                order.setItemName(dName.getText().toString());
                order.setItemQuantity(Integer.parseInt(qty));
                order.setItemPrice(Double.parseDouble(prc));
                order.addToCart();

                Toast.makeText(Drinks_layout.this, "Your order was added", Toast.LENGTH_SHORT).show();
            }
        });

        back = (Button) findViewById(R.id.DrinkBack);
        i = 0;
        qtyCounter = 0;

        //another way to initialize
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opening another activity and closing the current one
                Intent mainIntent = new Intent(Drinks_layout.this, MainActivity.class);
                startActivity(mainIntent);
                finish();

            }
        });

        //to open the pictures
        imageView2 = findViewById(R.id.imageview2);

        previous = findViewById(R.id.Previous);
        next = findViewById(R.id.Next);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        quantity = findViewById(R.id.qty);
        dName = findViewById(R.id.drinkName);
        dPrice = findViewById(R.id.drinkPrice);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 0) {
                    return;
                }
                imageView2.setImageResource(textureArrayWin[--i]);
                setFoodDescri(i);

                qtyCounter = 0;
                quantity.setText("QTY : 0");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 3) {
                    return;
                }
                imageView2.setImageResource(textureArrayWin[++i]);
                setFoodDescri(i);

                qtyCounter = 0;
                quantity.setText("QTY : 0");
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity.setText("QTY : " + (++qtyCounter));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qtyCounter == 0) {
                    return;
                }
                quantity.setText("QTY : " + (--qtyCounter));
            }
        });


    }

    void setFoodDescri(int imageNumber) {
        String name = "", price = " ";
        switch (imageNumber) {
            case 0:
                name = "Iced Coffee";
                price = "₱75.00";
                break;
            case 1:
                name = "Blue Lemonade";
                price = "₱60.00";
                break;
            case 2:
                name = "Iced Tea";
                price = "₱55.00";
                break;
            case 3:
                name = "Coca - Cola mismo";
                price = "₱25.00";
            default:
        }
        dName.setText(name);
        dPrice.setText(price);

    }
}