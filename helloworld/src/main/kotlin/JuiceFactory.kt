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
        val products = mutableListOf<Product>()
        for (item in order) {
            val (productType, count) = item
            val availableCount = storage.checkProductCount(productType)
            if (availableCount < count) {
                throw IllegalStateException("Not enough products in storage")
            }
            storage.getProduct(productType, count)
        }
        return products
    }

    override fun getLeftovers(): List<Product> = storage.getLeftovers()
}