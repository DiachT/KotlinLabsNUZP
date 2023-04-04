import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class FreshJuiceStorage: Storage {
    internal val products = mutableListOf<Product>()
    override fun addProduct(product: Product) {
        for (item in 0 until product.count) products.add(product)
    }
    override fun checkProductCount(type: ProductType): Int {
        products.forEach { if (it.type == type) return it.count }
        return 0
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        products.forEach {
            if (it.type == productType) {
                for (item in 0..count) products.remove(it)
                return it
            }
        }
        throw IllegalStateException("Impossible to take the product out of the list")
    }

    override fun getLeftovers(): List<Product> = products

    override fun resetSimulation() { products.clear() }

}