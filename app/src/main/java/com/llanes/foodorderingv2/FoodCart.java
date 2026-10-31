package com.llanes.foodorderingv2;

import java.util.ArrayList;

public class FoodCart {


    private static ArrayList<Double> itemPrices = new ArrayList<>();
    private static ArrayList<String> itemNames = new ArrayList<>();
    private static ArrayList<Integer> itemQuantities = new ArrayList<>();

    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private static double totalPrice;


    public FoodCart() {
        this.itemName = "";
        this.itemQuantity = 0;
        this.itemPrice = 0;
        this.totalPrice = 0;
    }

    public void setItemPrice(double price) {
        this.itemPrice = price;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public void setItemQuantity(int quantity) {
        this.itemQuantity = quantity;
    }

    public static ArrayList<Double> getItemPrices() {
        return itemPrices;
    }

    public static ArrayList<String> getItemNames() {
        return itemNames;
    }

    public static ArrayList<Integer> getItemQuantities() {
        return itemQuantities;
    }

    public void addToCart() {
        itemPrices.add(itemPrice * itemQuantity);
        itemNames.add(itemName);
        itemQuantities.add(itemQuantity);
    }

    public static double getTotalPrice() {
        for (int i = 0; i < itemPrices.size(); i++) {
            totalPrice += itemPrices.get(i);
        }
        return totalPrice;
    }

}
