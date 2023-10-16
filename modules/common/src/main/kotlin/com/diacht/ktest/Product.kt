package com.diacht.ktest

import java.util.concurrent.TimeUnit

open class ProductType()

object WATER : ProductType()
object SUGAR : ProductType()
object NONE : ProductType()

data class Product(val type: ProductType, var count: Int)

open class Receipt(
    val products: List<Product>,
    val time: Long,
    val timeUnit: TimeUnit,
    val outProductType: ProductType,
    val price: Int,
)

