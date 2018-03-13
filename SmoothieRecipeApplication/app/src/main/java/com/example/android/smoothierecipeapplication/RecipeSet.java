package com.example.android.smoothierecipeapplication;

import java.util.ArrayList;

/**
 * Created by Android on 10/7/2017.
 */

class RecipeSet {
    private static RecipeSet recipeSet;
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    private RecipeSet() {
        recipes.add(new Recipe("Kiwi Strawberry Twist", R.drawable.recipe_kiwi_strawberry_twist_cropped, new String[]{
                "2 cups kale and dandelion greens fresh",
                "2 cups orange juice fresh squeezed",
                "2 cups strawberries",
                "2 kiwi",
                "1 banana",
                "1 lemon squeezed"}, "By themselves the flavor of the dandelion greens can be a bit overwhelming. We combine them with kale in this kiwi strawberry green smoothie, but feel free to alter the amounts to suit your personal tastes. Pairing the dandelion greens with spinach first might be a good first step if you're still a beginner or a teensy bit scared – no judgment from us! \n\n" +
                "This kiwi strawberry green smoothie is also LOADED with vitamin C. The kiwi and strawberry have even more \"C\" thank the citrus. #themoreyouknow \n\n" +
                "Sip up to give your immune system a boost!", new String[]{"\u2605\u2605\u2605\u2605\u2605\n Tastiest smoothie I've ever had!!","\u2605\u2605\u2605\u2605\u2606\n It was pretty good, but had a lot of seeds and the dandelion is hard to find"}));
        recipes.add(new Recipe("Kiwi Berry Punch", R.drawable.recipe_kiwi_berry_punch_cropped, new String[]{
                "2 cups spinach fresh",
                "2 cups water",
                "1 cup blueberries",
                "1 cup mixed berries",
                "1 bananas",
                "1 kiwi",
                "1/2 avocado"}, "Cherries are naturally sweet immunity boosters, low-calorie, and full of antioxidants. Kiwi is packed with vitamin C and an amazing fat-burning fruit. We always keep several bags of frozen berries in the freezer— which is perfect for this recipe. Banana adds sweetness and avocado makes it nice and creamy.",
                new String[]{"\u2605\u2606\u2606\u2606\u2606\n Absolutely disgsuting!!","\u2605\u2605\u2605\u2606\u2606\n It was okay, not the best I've had"}));
        recipes.add(new Recipe("Coconut Peach", R.drawable.recipe_coconut_peach_cropped, new String[]{
                "2 cups spinach",
                "2 cups coconut milk",
                "2 cups sliced peaches*",
                "1 orange peeled",
                "*Fresh peaches not in season where you are? Use frozen!"},
                "Sometimes the simplest green smoothies are the best, and truly most of our smoothies fall under that category. This one is one of the simplest though— just four ingredients!\n" +
                "-\n" +
                "The coconut milk makes this extra creamy and rich - almost like a peach milkshake. Adding an orange boosts the Vitamin C level and adds an extra sweet-tart element. I can honestly say that this is one of my very favorite recipes!",
                new String[]{"\u2605\u2606\u2606\u2606\u2606\n Not sure why I tried this because I hate Coconuts","\u2605\u2605\u2605\u2605\u2605\n Absolutely delicious!!"}));
        recipes.add(new Recipe("Whole 30 Green Smoothie: Carrot Beet Berry", R.drawable.recipe_carrot_beet_berry_cropped, new String[]{
                "2 cups baby kale",
                "2 cups water",
                "1 medium carrot peeled and sliced",
                "1 small beet peeled and diced",
                "1 cup strawberries frozen",
                "1 banana medium",
                "1-2 tablespoons coconut oil",
                "Optional flavor boosters: 1/4 fresh mint and/or 1/2-inch piece fresh ginger",}, "Eating the Whole 30 way doesn't mean you have to give up your green smoothies. On the contrary! We think it's a great way to pack more plants into your day, which is why we wanted to create a special recipe full of leafy green and veggies goodness that is lower in sugar, high in fiber, and includes a healthy fat, in this case, coconut oil.\n\n" +
                "This gorgeous ruby red smoothie is jam-packed with antioxidants, fiber, and other nutrients to fuel your body with plant-powered goodness while you eat the Whole 30 way.",
                new String[]{"\u2605\u2605\u2605\u2605\u2605\n Best Whole30 Smoothie I've ever had!","\u2605\u2605\u2605\u2605\u2606\n It was pretty good, but had a very strong carrot flavor. Will need to dilute it with something else."}));
        recipes.add(new Recipe("Peach Mango Cream Green Smoothie", R.drawable.recipe_peach_mango_cream_green_cropped, new String[]{
                "1 1/2 cups spinach",
                "1 cup water",
                "2 tbsp raw cashews soaked overnight and drained",
                "1 tbsp coconut oil",
                "1 cup peaches frozen",
                "1/2 cup mango frozen",
                "1/2 tsp vanilla extract optional"},
                "Packed with healthy fats, protein, and nutrient-rich fruit + leafy greens, this delicious smoothie is sure to keep your body going until your next snack or meal. What's more, coconut oil is uniquely absorbed in the small intestine, providing the body with a more immediate form of energy rather than storing it for later. Now that's what we call rawesome! \uD83D\uDE09\n\n" +
                "This dreamy, tropical tasting smoothie has all the bases covered—healthy fats, protein, vitamins, and minerals, plus, it tastes great! The addition of coconut oil helps give your body an energizing boost, while being easy on the digestive system.",
                new String[]{"\u2605\u2605\u2605\u2605\u2605\n Tastiest breakfast smoothie ever!","\u2605\u2605\u2605\u2605\u2605\n It was good!!"}));
    }

    public static RecipeSet getRecipeSet() {
        if(recipeSet == null){
            recipeSet = new RecipeSet();
        }
        return recipeSet;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public Recipe getRecipe(int id) {
        if(id < 0 || id >= recipes.size()) return null;
        return recipes.get(id);
    }
}
