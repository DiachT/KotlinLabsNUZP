import com.diacht.ktest.FactoryItf
import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import kotlin.math.min

class JuiceFactory(private val storage: FreshJuiceStorage): FactoryItf() {
    override fun resetSimulation() { storage.resetSimulation() }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach { storage.addProduct(it) }
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        val readyOrders = mutableListOf<Product>()
        for ((type, amount) in order) {
            val availableProducts = storage.products.filter { it.type == type }
//            val availableAmount = min(amount, availableProducts.size)
            readyOrders.addAll(availableProducts.take(availableProducts.size))
        }
        return readyOrders
    }

    override fun getLeftovers(): List<Product> = storage.products
}