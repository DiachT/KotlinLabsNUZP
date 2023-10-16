import com.diacht.ktest.*
import com.diacht.ktest.caffe.*

class MyFactory (private val storage: MyStorage, private val cafeFactory: CafeMachine) : FactoryItf() {

    private fun getProductIndex(ProductList: List<Product>, typeOfProduct : ProductType) : Int {
//        return ProductList.indices.find { ProductList[it].type == typeOfProduct } ?: -1
        for ((index, product) in ProductList.withIndex()) {
            if (product.type == typeOfProduct) {
                return index
            }
        }
        return -1
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
//        println("\n")//
        val successfullyOrdered = mutableListOf<Product>()
        order.forEach{
            val receipt = when(it.first){
                ESPRESSO -> EspressoReceipt
                AMERICANO -> AmericanoReceipt
                CAPPUCCINO -> CappuccinoReceipt
                AMERICANO_WI_MILK -> AmericanoWithMilkReceipt
                LATE -> LateReceipt
                CACAO_DRINK -> CacaoDrinkReceipt
                else -> { throw IllegalArgumentException("No such drink") }
            }

//            println("successfullyOrdered = " + successfullyOrdered + '\n')
            repeat(it.second){
//                println("successfullyOrdered before makedrink = " + successfullyOrdered)
                val drink  = cafeFactory.makeDrink(receipt)

//                println("Drink returned by cafeFactory.makeDrink(receipt) = " + drink)
//                println("successfullyOrdered brfore index = " + successfullyOrdered)

                val index = getProductIndex(successfullyOrdered, drink.type)

                if (index != -1) {
                    successfullyOrdered[index].count += drink.count
                    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                }
                else {
                    successfullyOrdered.add(drink)
                }
//                println("successfullyOrdered after index= " + successfullyOrdered + '\n')
            }
//            println("\nsuccessfullyOrdered = " + successfullyOrdered + '\n')
        }

//        println("\n")

        return successfullyOrdered
    }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach{ storage.addProduct(it) }
    }

    override fun getLeftovers(): List<Product> {
        return storage.getLeftovers()
    }

    override fun getPopularDrink(): Product {
        return cafeFactory.getPopularDrink()
    }

    override fun resetSimulation() {
        storage.resetSimulation()
        cafeFactory.resetSimulation()
    }
}