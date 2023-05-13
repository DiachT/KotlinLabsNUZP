import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class FreshJuiceStorage: Storage {
    internal val productsStorage = mutableListOf<Product>()
    // to add a list of orders
    override fun addProduct(product: Product) {
    // TODO: To check if product is in a storage
        productsStorage.add(product)
    }

    override fun checkProductCount(type: ProductType): Int {
        // TODO: If there are no products, return 0
        return productsStorage.count { it.type == type }
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        val filteredProducts = productsStorage.filter { it.type == productType }

        if (filteredProducts.size > count) {
            throw IllegalStateException("Not enough products in storage")
        }

        val productsToTake = filteredProducts.take(count)
        productsStorage.removeAll(productsToTake)
        return Product(productType, count)
    }

    override fun getLeftovers(): List<Product> = productsStorage

    override fun resetSimulation() { productsStorage.clear() }
}