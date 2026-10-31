# FoodOrderingv2

An Android food ordering app for campus canteens. Students pick a canteen, browse the menu by category, add items to a cart, and get a queue number when they confirm their order.

Built in Java with Android Studio.

## Features

- **Login screen** – entry point of the app
- **Canteen selection** – choose between three canteens: **TYK**, **LCT**, and **Urban**
- **Menu by category** – Meals, Drinks, Breads, and Chips, with next/previous image browsing for each item
- **Quantity picker** – increase or decrease quantity before adding an item to the cart
- **Cart** – lists ordered items with quantity and price, shows the total, and can be cleared
- **Queue number** – generates a queue number after confirming the order
- **Profile screen** and logout

## Menu

| Category | Items |
|----------|-------|
| Meals  | Chicken Fillet (₱75), 1 Pc Chicken (₱99), TociLog (₱85) |
| Drinks | Iced Coffee (₱75), Blue Lemonade (₱60), Iced Tea (₱55), Coca-Cola (₱25) |
| Breads | Foot Long (₱40), Pepperoni Pizza (₱38), Sandwich (₱30), Hawaiian Pizza (₱36) |
| Chips  | Piattos (₱25), BreadPan (₱18), Pillows (₱15), V-Cut (₱25), Clover (₱18) |

## App flow

```
Login → Choose canteen → Canteen intro → Home (categories)
                                           ├── Meals / Drinks / Breads / Chips → Add to cart
                                           ├── Cart → Confirm → Queue number
                                           └── Profile
```

## Tech stack

| | |
|---|---|
| Language | Java 8 |
| Min SDK | 24 (Android 7.0) |
| Target / Compile SDK | 33 (Android 13) |
| Build | Gradle 7.5, Android Gradle Plugin 7.4.2 |
| UI | AndroidX AppCompat, Material Components, ConstraintLayout |

## Project structure

```
app/src/main/
├── java/com/llanes/foodorderingv2/
│   ├── loginaos.java            # Login screen (launcher)
│   ├── canteenchoose.java       # Canteen selection + logout
│   ├── tykintro.java            # TYK canteen intro
│   ├── lctintro.java            # LCT canteen intro
│   ├── IntroActivity.java       # Urban canteen intro
│   ├── MainActivity.java        # Home screen with categories
│   ├── Food_layout.java         # Meals menu
│   ├── Drinks_layout.java       # Drinks menu
│   ├── breads_layout.java       # Breads menu
│   ├── chips_layout.java        # Chips menu
│   ├── FoodCart.java            # Cart data (items, quantities, total)
│   ├── addtocart_layout.java    # Cart screen
│   ├── queue_number.java        # Queue number screen
│   └── ProfileActivity.java     # Profile screen
├── res/layout/                  # XML layouts for each screen
├── res/drawable/                # Food images and icons
└── AndroidManifest.xml
```

## Getting started

1. Clone the repo:
   ```bash
   git clone https://github.com/navinskyy/FoodOrderingv2.git
   ```
2. Open the project folder in **Android Studio**.
3. Let Gradle sync. Android Studio creates `local.properties` with your SDK path automatically.
4. Run the app on an emulator or a device running Android 7.0 or newer.

To build a debug APK from the command line:

```bash
./gradlew assembleDebug        # macOS / Linux
gradlew.bat assembleDebug      # Windows
```

The APK is written to `app/build/outputs/apk/debug/`.

## Current limitations

This is a front-end prototype without a backend:

- Login does not check credentials. Any input takes you to canteen selection.
- The cart is kept in memory only and is lost when the app closes.
- The queue number is randomly generated (0–1000), and orders are not actually sent anywhere.
- All three canteens currently share the same menu.

## Author

**Navin Llanes** – [@navinskyy](https://github.com/navinskyy)
