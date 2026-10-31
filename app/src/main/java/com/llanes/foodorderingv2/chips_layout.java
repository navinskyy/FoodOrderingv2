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



public class chips_layout extends AppCompatActivity {

    //for food swiping

    ImageView imageView4;

    TextView quantity, cName, cPrice;

    Button next, previous, plus, minus, atcbtnCheaps;

    int i;

    int qtyCounter;

    private int[] textureArrayWin = {R.drawable.piattos, R.drawable.breadpan, R.drawable.pillows, R.drawable.vcut, R.drawable.clover};

    Button back; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips_layout);

        FoodCart order = new FoodCart();
        atcbtnCheaps = (Button) findViewById(R.id.addtocartbtnchips) ;
        atcbtnCheaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(qtyCounter == 0) {
                    return;
                }

                String qty = quantity.getText().toString();
                qty = qty.replaceAll("QTY : ", "");

                String prc = cPrice.getText().toString();
                prc = prc.replaceAll("₱","");

                order.setItemName(cName.getText().toString());
                order.setItemQuantity(Integer.parseInt(qty));
                order.setItemPrice(Double.parseDouble(prc));
                order.addToCart();

                Toast.makeText(chips_layout.this, "Your order was added", Toast.LENGTH_SHORT).show();
            }
        });

        back = (Button) findViewById(R.id.chipBack);
        i = 0;
        qtyCounter = 0;

        //another way to initialize
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opening another activity and closing the current one
                Intent mainIntent = new Intent(chips_layout.this, MainActivity.class);
                startActivity(mainIntent);
                finish();

            }
        });

        //to open the pictures
        imageView4 = findViewById(R.id.imageview4);

        previous = findViewById(R.id.Previous);
        next = findViewById(R.id.Next);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        quantity = findViewById(R.id.qty);
        cName = findViewById(R.id.chipsName);
        cPrice = findViewById(R.id.chipsPrice);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 0) {
                    return;
                }
                imageView4.setImageResource(textureArrayWin[--i]);
                setFoodDescri(i);

                qtyCounter = 0;
                quantity.setText("QTY : 0");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 4) {
                    return;
                }
                imageView4.setImageResource(textureArrayWin[++i]);
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
                name = "Piattos";
                price = "₱25.00";
                break;
            case 1:
                name = "BreadPan";
                price = "₱18.00";
                break;
            case 2:
                name = "Pillows";
                price = "₱15.00";
                break;
            case 3:
                name = "V-cut";
                price = "₱25.00";
            case 4:
                name = "Clover";
                price = "₱18.00";
            default:
        }
        cName.setText(name);
        cPrice.setText(price);

    }
}