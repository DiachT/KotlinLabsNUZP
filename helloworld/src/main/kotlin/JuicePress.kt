import com.diacht.ktest.*

class JuicePress(storage: MyStorage) : Machine(storage) {
    private var orderedDrinks = mutableListOf<Product>()
    private fun getProductIndex(type : ProductType) : Int {
        for (index in orderedDrinks.indices) {
            if (orderedDrinks[index].type == type) {
                return index
            }
        }
        return -1
    }
    fun makeDrink(receipt: Receipts): Product {
        val drink = Product(NONE, 0)

        if (receipt.products.all { storage.checkProductCount(it.type) > 0 }) {
            setReceipt(receipt)
            val preparedDrink = executeProcess()
            var index = -1

            for (i in 0 until orderedDrinks.size) {
                if (orderedDrinks[i].type == preparedDrink.type) {
                    index = i
                    break
                }
            }

            if (index != -1) {
                orderedDrinks[index] = Product(preparedDrink.type, orderedDrinks[index].count + preparedDrink.count)
            } else {
                orderedDrinks.add(preparedDrink)
            }
            return preparedDrink
        }

        return drink
    }
    fun getUnPopularDrink() : Product {
        if (orderedDrinks.isEmpty()) {
            return Product(NONE, 0)
        }
        return orderedDrinks.minWith(Comparator.comparingInt { it.count })
    }
    fun resetSimulation() {
        orderedDrinks.clear()
    }
}