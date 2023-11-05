import com.diacht.ktest.*
import com.diacht.ktest.juicefactory.*

class CafeFactory (private val storage: MyStorage, private val cafeFactory: JuicePress) : FactoryItf() {
    private fun getProductIndex(ProductList: List<Product>, typeOfProduct : ProductType) : Int {
        for (index in ProductList.indices) {
            if (ProductList[index].type == typeOfProduct) {
                return index
            }
        }
        return -1
    }
    override fun loadProducts(productsFromSupplier: List<Product>) {
       productsFromSupplier.forEach{
           storage.addProduct(it)
       }
    }
    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        val successfullyOrdered = mutableListOf<Product>()
        order.forEach{
            val receipt = when(it.first){
                ORANGE_JUICE -> OrangeJuice;
                APPLE_JUICE -> AppleJuice;
                APPLE_CARROT_JUICE -> AppleCarrotJuice;
                TOMATO_CARROT_JUICE -> TomatoCarrotJuice;
                TOMATO_JUICE -> TomatoJuice;
                else -> { throw IllegalArgumentException("No such juice") }
            }
            repeat(it.second){
                val drink  = cafeFactory.makeDrink(receipt)
                val index = getProductIndex(successfullyOrdered, drink.type)
                if (index != -1) {
                    successfullyOrdered[index] = Product(successfullyOrdered[index].type, successfullyOrdered[index].count + drink.count)
                }
                else {
                    successfullyOrdered.add(drink.copy())
                }
            }
        }
        return successfullyOrdered
    }
    override fun getLeftovers(): List<Product> {
        return storage.getLeftovers()
    }
//    override fun getUnpopularDrink(): Product {
//        return juicePress.getUnPopularDrink();
//    }
    override fun resetSimulation() {
        storage.resetSimulation();
        cafeFactory.resetSimulation();
    }
}
