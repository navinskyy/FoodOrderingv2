package com.llanes.foodorderingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class addtocart_layout extends AppCompatActivity {

    Button back, ATCconfirm, ATclear;
    TextView tvTotalPrice;
    LinearLayout orderholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocart_layout);

        orderholder = (LinearLayout) findViewById(R.id.layoutHolder);
        tvTotalPrice = (TextView) findViewById(R.id.tvTotalprice);

        back = (Button) findViewById(R.id.ATCBack);
        ATCconfirm = (Button) findViewById(R.id.ATCconfirm);
        ATclear = (Button) findViewById(R.id.ATCclear);

        int j = 0; //test
        for (int i = 0; i < FoodCart.getItemNames().size(); i++) {
            j++;
            addOrderOnList(FoodCart.getItemNames().get(i),
                    FoodCart.getItemQuantities().get(i),
                    FoodCart.getItemPrices().get(i));
            Toast.makeText(addtocart_layout.this, "countert : "+j, Toast.LENGTH_SHORT).show();
        }
        tvTotalPrice.setText("TOTAL : ₱"+FoodCart.getTotalPrice());

        //initialize
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opening another activity and closing the current one
                Intent mainIntent = new Intent(addtocart_layout.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
        ATCconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(addtocart_layout.this, queue_number.class);
                startActivity(mainIntent);
                finish();
            }
        });

        ATclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderholder.removeAllViews();
                tvTotalPrice.setText("TOTAL : P0");
            }
        });
    }

    private void addOrderOnList(String itemName, int itemQuantity, double itemPrice) {
        View order_per_row = getLayoutInflater().inflate(R.layout.order_per_row_layout, null);
        TextView tvName = (TextView) order_per_row.findViewById(R.id.itemName);
        TextView tvQuantity = (TextView) order_per_row.findViewById(R.id.itemQuantity);
        TextView tvPrice = (TextView) order_per_row.findViewById(R.id.itemPrice);

        //setValue
        tvName.setText(itemName);
        tvQuantity.setText(String.valueOf(itemQuantity)+"x");
        tvPrice.setText("₱"+String.valueOf(itemPrice));
        orderholder.addView(order_per_row);
    }
}