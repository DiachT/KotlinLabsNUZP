import com.diacht.ktest.*
import com.diacht.ktest.caffe.*

class MyFactory (private val storage: MyStorage, private val cafeFactory: CafeMachine) : FactoryItf() {

    private fun getProductIndex(ProductList: List<Product>, typeOfProduct : ProductType) : Int {
        return ProductList.indices.find { ProductList[it].type == typeOfProduct } ?: -1
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
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
            repeat(it.second){
                val drink  = cafeFactory.makeDrink(receipt)
                val index = getProductIndex(successfullyOrdered, drink)
                if (index != -1) {
                    successfullyOrdered[index].count++
                }
                else {
                    successfullyOrdered.add(Product(drink, 1))
                }
            }
        }

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