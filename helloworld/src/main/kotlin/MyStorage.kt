import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class MyStorage : Storage {

    private var products = mutableListOf<Product>()
    private fun getProductIndex(type : ProductType) : Int {
        for (index in products.indices) {
            if (products[index].type == type) {
                return index
            }
        }
        return -1
    }

    override fun addProduct(product: Product) {
        val index = getProductIndex(product.type)
        if (index != -1)
            products[index] = Product(products[index].type, products[index].count + product.count);
        else
            products.add(product)
    }
    override fun checkProductCount(type: ProductType): Int {
        var count = 0
        val index = getProductIndex(type)
        if (index != -1)
            count = products[index].count
        return count;
    }
    override fun getProduct(productType: ProductType, count: Int): Product {
        if(checkProductCount(productType) >= count){
            val index = getProductIndex(productType)
            if (index != -1)
                products[index] = Product(products[index].type, products[index].count - count)
            return Product(productType, count)
        }
        else
            throw IllegalStateException("There is no such product or quantity")
    }
    override fun getLeftovers(): List<Product> {
        val leftoverProducts = mutableListOf<Product>()
        for (product in products) {
            if (product.count > 0) {
                leftoverProducts.add(product)
            }
        }
        return leftoverProducts
    }
    override fun resetSimulation() {
        products.clear()
    }
}