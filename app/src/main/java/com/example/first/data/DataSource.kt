package com.example.first.data

import com.example.first.R
import com.example.first.model.MenuItem.AccompanimentItem
import com.example.first.model.MenuItem.EntreeItem
import com.example.first.model.MenuItem.SideDishItem
import com.example.first.model.Plant


object DataSource {
    val flavors = listOf(
        R.string.vanilla,
        R.string.chocolate,
        R.string.red_velvet,
        R.string.salted_caramel,
        R.string.coffee
    )

    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),
        Pair(R.string.six_cupcakes, 6),
        Pair(R.string.twelve_cupcakes, 12)
    )

    /**
     * Map of available menu items to be displayed in the menu fragments.
     */

    val entreeMenuItems = listOf(
            EntreeItem(
            name = "Cauliflower" ,
            description = "Whole cauliflower, brined, roasted, and deep fried" ,
            price = 7.00 ,
        ) ,
            EntreeItem(
                name = "Three Bean Chili",
                description = "Black beans, red beans, kidney beans, slow cooked, topped with onion",
                price = 4.00,
            ),
            EntreeItem(
                name = "Mushroom Pasta",
                description = "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic " +
                        "and olive oil",
                price = 5.50,
            ),
            EntreeItem(
                name = "Spicy Black Bean Skillet",
                description = "Seasonal vegetables, black beans, house spice blend, served with " +
                        "avocado and quick pickled onions",
                price = 5.50,
            )
        )

        val sideDishMenuItems = listOf(
            SideDishItem(
                name = "Summer Salad",
                description = "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
                price = 2.50,
            ),
            SideDishItem(
                name = "Butternut Squash Soup",
                description = "Roasted butternut squash, roasted peppers, chili oil",
                price = 3.00,
            ),
            SideDishItem(
                name = "Spicy Potatoes",
                description = "Marble potatoes, roasted, and fried in house spice blend",
                price = 2.00,
            ),
            SideDishItem(
                name = "Coconut Rice",
                description = "Rice, coconut milk, lime, and sugar",
                price = 1.50,
            )
        )

        val accompanimentMenuItems = listOf(
            AccompanimentItem(
                name = "Lunch Roll",
                description = "Fresh baked roll made in house",
                price = 0.50,
            ),
            AccompanimentItem(
                name = "Mixed Berries",
                description = "Strawberries, blueberries, raspberries, and huckleberries",
                price = 1.00,
            ),
            AccompanimentItem(
                name = "Pickled Veggies",
                description = "Pickled cucumbers and carrots, made in house",
                price = 0.50,
            )
        )

    /**
     * water me app datasource
     */
    val plants = listOf(
        Plant(
            name = R.string.lithop,
            schedule = R.string.monthly,
            type = R.string.succulent,
            description = R.string.stone_mimicking_succulent
        ) ,
        Plant(
            name = R.string.carrot,
            schedule = R.string.daily,
            type = R.string.root,
            description = R.string.hardy_root_vegetable
        ),
        Plant(
            name = R.string.peony,
            schedule = R.string.weekly,
            type = R.string.flower,
            description = R.string.spring_blooming_flower
        ),
        Plant(
            name = R.string.pothos,
            schedule = R.string.weekly,
            type = R.string.houseplant,
            description = R.string.indoor_vine
        ),
        Plant(
            name = R.string.fiddle_leaf_fig,
            schedule = R.string.weekly,
            type = R.string.broadleaf_evergreen,
            description = R.string.ornamental_fig
        ),
        Plant(
            name = R.string.strawberry,
            schedule = R.string.daily,
            type = R.string.fruit,
            description = R.string.delicious_multiple_fruit
        )
    )
}