import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class MyStorage : Storage {
    private var ProductsAndQuantity = mutableListOf<Product>()

    private fun getProductIndex(type : ProductType) : Int {
        return ProductsAndQuantity.indices.find { ProductsAndQuantity[it].type == type } ?: -1
    }

    override fun addProduct(product: Product) {
        val index = getProductIndex(product.type)
        if (index != -1)
            ProductsAndQuantity[index].count += product.count
        else
            ProductsAndQuantity.add(product)
    }

    override fun checkProductCount(type: ProductType): Int {
        var count = 0
        val index = getProductIndex(type)
        if (index != -1)
            count = ProductsAndQuantity[index].count
        return count
    }

    override fun getProduct(productType: ProductType, count: Int) : Product {
        if(checkProductCount(productType) >= count){
            val index = getProductIndex(productType)
            if (index != -1)
                ProductsAndQuantity[index].count -= count
            return Product(productType, count)
        }
        else
            throw IllegalStateException("No such product or quantity")
    }

    override fun getLeftovers() : List<Product> {
        return ProductsAndQuantity.filter { it.count > 0 }
    }

    override fun resetSimulation() {
        ProductsAndQuantity.clear()
    }
}