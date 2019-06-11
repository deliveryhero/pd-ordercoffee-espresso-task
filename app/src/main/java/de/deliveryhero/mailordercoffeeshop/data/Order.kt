package de.deliveryhero.mailordercoffeeshop.data

import de.deliveryhero.mailordercoffeeshop.data.beverage.Ingredient

data class Order(val customerName: String, val customerEmail: String, val orderName: String, val ingredients: List<Ingredient>)
