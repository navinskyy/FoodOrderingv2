package com.llanes.foodorderingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declarations
    Button btnHome, btnProfile,  Support, Tools, btnAddToCart;
    ImageButton foodBtn, drinksbtn, breadsbtn, chipsbtn, pepperonibtn, cocacolabtn, ricefilletbtn, piattosbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calling functions
        init();
        addListeners();

    }

    void init() {
        //initialization of variables/objects declared
        btnHome = (Button) findViewById(R.id.btnHome);
        btnProfile= (Button) findViewById(R.id.btnProfile);
        btnAddToCart = (Button) findViewById(R.id.btnAddToCart);
        foodBtn = (ImageButton) findViewById(R.id.foodBtn);
        drinksbtn = (ImageButton) findViewById(R.id.drinksBtn);
        breadsbtn = (ImageButton) findViewById(R.id.breadsBtn);
        chipsbtn = (ImageButton) findViewById(R.id.chipsBtn);
        pepperonibtn = (ImageButton) findViewById(R.id.pepperoniBtn);
        cocacolabtn = (ImageButton) findViewById(R.id.cocacolaBtn);
        ricefilletbtn = (ImageButton) findViewById(R.id.ricefilletBtn);
        piattosbtn = (ImageButton) findViewById(R.id.piattosBtn);

    }

    void addListeners() {
        //adding OnClickListener on buttons
        btnHome.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnAddToCart.setOnClickListener(this);
        foodBtn.setOnClickListener(this);
        drinksbtn.setOnClickListener(this);
        breadsbtn.setOnClickListener(this);
        chipsbtn.setOnClickListener(this);
        pepperonibtn.setOnClickListener(this);
        cocacolabtn.setOnClickListener(this);
        ricefilletbtn.setOnClickListener(this);
        piattosbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //comparing ids in the xml and the cases in the switch method
        switch (view.getId()) {
            case R.id.btnHome:
                Toast.makeText(MainActivity.this,"HOME CLICKED!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnProfile:
                Toast.makeText(MainActivity.this,"PROFILE CLICKED!",Toast.LENGTH_SHORT).show();
                //opening intent

                //first param : the current class, second param : the activity to be opened
                Intent profileIntent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(profileIntent);
                finish(); //closing the current activity
                break;

            case R.id.btnAddToCart:
                Toast.makeText(MainActivity.this, "ADD TO CART CLICKED!", Toast.LENGTH_SHORT).show();
                Intent addtocart_layoutIntent = new Intent(MainActivity.this,addtocart_layout.class);
                startActivity(addtocart_layoutIntent);
                finish();
                break;

            case R.id.foodBtn:
                //food-layout first param : the current class, second param : the activity to be opened
                Intent Food_layoutIntent = new Intent(MainActivity.this,Food_layout.class);
                startActivity(Food_layoutIntent);
                finish();
                break;


            case R.id.drinksBtn:
                //drink-layout first param : the current class, second param : the activity to be opened
                Intent Drinks_layout = new Intent(MainActivity.this,Drinks_layout.class);
                startActivity(Drinks_layout);
                finish();
                break;

            case R.id.breadsBtn:
                //drink-layout first param : the current class, second param : the activity to be opened
                Intent breads_layout = new Intent(MainActivity.this,breads_layout.class);
                startActivity(breads_layout);
                finish();
                break;

            case R.id.chipsBtn:
                //chips-layout first param : the current class, second param : the activity to be opened
                Intent chips_layout = new Intent(MainActivity.this,chips_layout.class);
                startActivity(chips_layout);
                finish();
                break;

            case R.id.pepperoniBtn:
                // mapupunta sa breads
                Intent bread_layout = new Intent(MainActivity.this,breads_layout.class);
                startActivity(bread_layout);
                finish();
                break;

            case R.id.cocacolaBtn:
                // mapupunta sa drinks
                Intent drinks_layout = new Intent(MainActivity.this,Drinks_layout.class);
                startActivity(drinks_layout);
                break;

            case R.id.ricefilletBtn:
                //mapupunta sa food meals
                Intent food_layout = new Intent(MainActivity.this, Food_layout.class);
                startActivity(food_layout);
                break;

            case R.id.piattosBtn:
                //mapupunta sa chips
                Intent chip_layout = new Intent(MainActivity.this, chips_layout.class);
                startActivity(chip_layout);
                break;


            default:
        }

    }
}