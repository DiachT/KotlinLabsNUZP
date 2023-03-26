import com.diacht.ktest.FactoryItf
import com.diacht.ktest.Product
import com.diacht.ktest.ProductType

class JuiceFactory(private val storage: FreshJuiceStorage): FactoryItf() {
    override fun resetSimulation() { storage.resetSimulation() }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach { storage.addProduct(it) }
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        val orderMap = order.associate { it.first to it.second }
        val product = Product(orderMap.keys.first(), orderMap.values.size)
        val orders = mutableListOf<Product>()
        for (item in 0..orderMap.values.size) { orders.add(product) }
        return orders
    }

    override fun getLeftovers(): List<Product> = storage.products
}