import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class FreshJuiceStorage: Storage {
    internal val products = mutableListOf<Product>()
    override fun addProduct(product: Product) {
        products.add(product)
    }

    override fun checkProductCount(type: ProductType): Int {
        return products.count { it.type == type }
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        val availableProducts = products.filter { it.type == productType }
        if (availableProducts.size < count) {
            throw IllegalStateException("Not enough products in storage")
        }
        val takenProducts = availableProducts.subList(0, count)
        products.removeAll(takenProducts)
        return takenProducts.first()
    }

    override fun getLeftovers(): List<Product> {
        return products.toList()
    }

    override fun resetSimulation() {
        products.clear()
    }

}