package com.llanes.foodorderingv2;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Food_layout extends AppCompatActivity {

    //for food swiping
    ImageView imageView;
    TextView quantity, fName, fPrice;
    Button next, previous, plus, minus, atcbtnFood;
    int i;
    int qtyCounter;
    private int[] textureArrayWin = {R.drawable.ricefillet, R.drawable.chickenrice, R.drawable.tocilog};


    Button back; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_layout);

        FoodCart order = new FoodCart();
        atcbtnFood = (Button) findViewById(R.id.addtocartbtnfood);
        atcbtnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(qtyCounter == 0) {
                    return;
                }//ok na

                String qty = quantity.getText().toString();
                qty = qty.replaceAll("QTY : ","");

                String prc = fPrice.getText().toString();
                prc = prc.replaceAll("₱","");

                order.setItemName(fName.getText().toString());
                order.setItemQuantity(Integer.parseInt(qty));
                order.setItemPrice(Double.parseDouble(prc));
                order.addToCart();

                Toast.makeText(Food_layout.this, "Your order was added", Toast.LENGTH_SHORT).show();
            }
        });

        back = (Button) findViewById(R.id.FoodBack); //initialize
        i = 0;
        qtyCounter = 0;

        //another way to initialize
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opening another activity and closing the current one
                Intent mainIntent = new Intent(Food_layout.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });

        //to open the pictures
        imageView = findViewById(R.id.imageview);

        previous = findViewById(R.id.Previous);
        next = findViewById(R.id.Next);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        quantity = findViewById(R.id.qty);
        fName = findViewById(R.id.foodName);
        fPrice = findViewById(R.id.foodPrice);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 0) {
                    return;
                }
                imageView.setImageResource(textureArrayWin[--i]);
                setFoodDescri(i);

                qtyCounter = 0;
                quantity.setText("QTY : 0");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 2) {
                    return;
                }
                imageView.setImageResource(textureArrayWin[++i]);
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
                name = "Chicken Fillet";
                price = "₱75.00";
                break;
            case 1:
                name = "1 Pc Chicken";
                price = "₱99.00";
                break;
            case 2:
                name = "TociLog";
                price = "₱85.00";
                break;
            default:
        }
        fName.setText(name);
        fPrice.setText(price);
    }


}