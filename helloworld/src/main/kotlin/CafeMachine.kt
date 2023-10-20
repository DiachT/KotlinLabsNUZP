import com.diacht.ktest.*

class CafeMachine(storage: MyStorage) : Machine(storage) {
    private var orderedDrinks = mutableListOf<Product>()

    private fun getProductIndex(type : ProductType) : Int {
        return orderedDrinks.indices.find { orderedDrinks[it].type == type } ?: -1
    }

    fun makeDrink (receipt: Receipt) : Product {
        var drink = Product(NONE, 0)
        if (receipt.products.all { storage.checkProductCount(it.type) > 0 }){
            setReceipt(receipt)
            drink = executeProcess()
            val index = getProductIndex(drink.type)
            if (index != -1) {
                orderedDrinks[index] = Product(orderedDrinks[index].type, orderedDrinks[index].count + drink.count)
            }
            else {
                orderedDrinks.add(drink.copy())
            }
        }
        return drink
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