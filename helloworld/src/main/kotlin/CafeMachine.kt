import com.diacht.ktest.*

class CafeMachine(storage: MyStorage) : Machine(storage) {
    private var orderedDrinks = mutableListOf<Product>()

    private fun getProductIndex(type : ProductType) : Int {
//        return orderedDrinks.indices.find { orderedDrinks[it].type == type } ?: -1
        for ((index, product) in orderedDrinks.withIndex()) {
            if (product.type == type) {
                return index
            }
        }
        return -1
    }

    fun makeDrink (receipt: Receipt) : Product {
        var drink = Product(NONE, 0)
        if (receipt.products.all { storage.checkProductCount(it.type) > 0 }){
            setReceipt(receipt)
//            println("orderedDrinks before executeProcess() = " + orderedDrinks)//
            drink = executeProcess()
//            println("orderedDrinks before index = " + orderedDrinks)//
            val index = getProductIndex(drink.type)
            if (index != -1) {
//                println("drink count " + drink.count)
//                orderedDrinks[index].count += drink.count
                // тут проблема !!!!!!!!!!!! завдання 1 пункт 4
            }
            else {
                orderedDrinks.add(drink)
            }
        }
//        println("drink in makedrink = " + drink)//
//        println("orderedDrinks = " + orderedDrinks)//
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