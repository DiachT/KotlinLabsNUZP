import com.diacht.ktest.*

class CafeMachine(storage: MyStorage) : Machine(storage) {
    private var orderedDrinks = mutableListOf<Product>()

    private fun getProductIndex(type : ProductType) : Int {
        return orderedDrinks.indices.find { orderedDrinks[it].type == type } ?: -1
    }

    fun makeDrink (receipt: Receipt) : ProductType {
        var drink = Product(NONE, 0)
        if (receipt.products.all { storage.checkProductCount(it.type) > 0 }){
            setReceipt(receipt)
            drink = executeProcess()
            val index = getProductIndex(drink.type)
            if (index != -1) {
                orderedDrinks[index].count++
            }
            else {
                orderedDrinks.add(drink)
            }
        }
        return drink.type
    }

    fun getPopularDrink() : Product {
        if (orderedDrinks.isEmpty()) {
            return Product(NONE, 0)
        }
        return orderedDrinks.maxWith(Comparator.comparingInt { it.count })
    }

    fun resetSimulation() {
        orderedDrinks.clear()
    }
}