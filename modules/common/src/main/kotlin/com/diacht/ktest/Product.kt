package com.diacht.ktest

import java.util.concurrent.TimeUnit

open class ProductType()

object WATER : ProductType()
object NONE : ProductType()
object SUGAR : ProductType()
object SALT : ProductType()
object APPLE : ProductType()
object ORANGE : ProductType()
object CARROT : ProductType()
object TOMATO : ProductType()

object ORANGE_JUICE : ProductType()
object APPLE_JUICE : ProductType()
object APPLE_CARROT_JUICE : ProductType()
object TOMATO_CARROT_JUICE : ProductType()
object TOMATO_JUICE : ProductType()

data class Product(
    val type: ProductType,
    var count: Int
)

open class Receipt(
    val products: List<Product>,
    val time: Long,
    val timeUnit: TimeUnit,
    val outProductType: ProductType,
    val price: Int,
)

object OrangeJuice : Receipt(
    products = listOf(
        Product(type = ORANGE, count = 1200),
        Product(type = WATER, count = 250),
        Product(type = SUGAR, count = 25),
    ),
    time = 8,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ORANGE_JUICE,
    price = 50,
)

object AppleJuice : Receipt(
    products = listOf(
        Product(type = APPLE, count = 1500),
        Product(type = WATER, count = 350),
        Product(type = SUGAR, count = 35),
    ),
    time = 10,
    timeUnit = TimeUnit.SECONDS,
    outProductType = APPLE_JUICE,
    price = 30,
)

object AppleCarrotJuice : Receipt(
    products = listOf(
        Product(type = APPLE, count = 800),
        Product(type = CARROT, count = 700),
        Product(type = WATER, count = 340),
        Product(type = SUGAR, count = 40),
    ),
    time = 12,
    timeUnit = TimeUnit.SECONDS,
    outProductType = APPLE_CARROT_JUICE,
    price = 38,
)

object TomatoCarrotJuice : Receipt(
    products = listOf(
        Product(type = CARROT, count = 400),
        Product(type = TOMATO, count = 1000),
        Product(type = WATER, count = 250),
        Product(type = SALT, count = 8),
    ),
    time = 11,
    timeUnit = TimeUnit.SECONDS,
    outProductType = TOMATO_CARROT_JUICE,
    price = 41,
)

object TomatoJuice : Receipt(
    products = listOf(
        Product(type = TOMATO, count = 1300),
        Product(type = WATER, count = 200),
        Product(type = SALT, count = 6),
    ),
    time = 7,
    timeUnit = TimeUnit.SECONDS,
    outProductType = TOMATO_JUICE,
    price = 39,
)