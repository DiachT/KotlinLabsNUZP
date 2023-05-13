import com.diacht.ktest.FactoryItf
import com.diacht.ktest.Product
import com.diacht.ktest.ProductType

class JuiceFactory(private val storage: FreshJuiceStorage): FactoryItf() {
    override fun resetSimulation() {
        // TODO: to add something
        storage.resetSimulation()
    }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach { product -> storage.addProduct(product) }
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        // TODO: JuiceReceipts to check the type of the order
        val products = mutableListOf<Product>()
        for (item in order) {
            val productType = item.first
            // to check whether the products for juice exist in the storage
            val count = item.second
            val product = storage.getProduct(productType, count)
            products.add(product)
        }

        return products
    }

    override fun getLeftovers(): List<Product> = storage.getLeftovers()
}