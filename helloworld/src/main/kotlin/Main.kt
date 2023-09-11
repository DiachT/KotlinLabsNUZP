import com.diacht.ktest.*
import com.diacht.ktest.caffe.*
import com.diacht.ktest.compose.startTestUi
import me.user.helloworld.BuildConfig
import java.util.concurrent.TimeUnit

fun seed(): String = "akutnyak"
fun labNumber() : Int = BuildConfig.LAB_NUMBER

class LocalStorage: Storage {
    private val orderedDrinks: MutableMap<ProductType, Int> = mutableMapOf()
    private var productStorage = mutableListOf<Product>()

    private fun haveProduct(type: ProductType): Boolean {
        for (product in productStorage) {
            if (product.type == type) {
                return true
            }
        }
        return false
    }

    private fun indexProduct(type: ProductType): Int {
        for ((index, product) in productStorage.withIndex()) {
            if (product.type == type) {
                return index
            }
        }
        return 0;
    }

    override fun addProduct(product: Product) {
        val haveProduct: Boolean = haveProduct(product.type);
        if (haveProduct) {
            productStorage[indexProduct(product.type)].count += product.count; // Якщо продукт вже існує додаємо йому кількість
        } else {
            productStorage += product; // Якщо продукту це не існує просто пушимо його в сховище
        }
        orderedDrinks.merge(product.type, product.count, Int::plus)
    }

    override fun checkProductCount(type: ProductType): Int {
        var result: Int = 0
        val haveProduct: Boolean =
            haveProduct(type) && productStorage[indexProduct(type)].count != 0 // Пошук продукту в сховищі
        if (haveProduct) {
            result = productStorage[indexProduct(type)].count // Запис к-сті продукту в сховищі, якщо знайшли
        }
        return result
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        val haveProduct: Boolean =
            haveProduct(productType) && productStorage[indexProduct(productType)].count != 0 // Пошук продукту в сховищі
        var getedProduct = Product(
            NONE,
            0
        ) // Повертаємий продукт продукт(В початковому значенні NONE, якщо умова не проходить, верне пустотий об'єкт.)
        if (haveProduct) {
            getedProduct = Product(productType, count);
            productStorage[indexProduct(productType)].count -= count;
        } // Видача необхідної к-сті продукту
        return getedProduct;
    }

    override fun getLeftovers(): List<Product> {
        return productStorage // Видаємо список всіх продуктів на збереженні
    }

    override fun resetSimulation() {
        productStorage.clear() //Перезапуск симуляції
    }
}

private val productsStorage = LocalStorage()

class LocalMachine(storage: LocalStorage) : Machine(storage) {
    private val storage = LocalStorage()
    fun makeDrink(receipt: Receipt): Product {
        setReceipt(receipt)
        val products = receipt.products.map { storage.getProduct(it.type, it.count) }
        consumeProducts(products)
        return executeProcess()
    }
}
private val cafeMachine = LocalMachine(productsStorage)

class CafeFactory(private val productsStorage: LocalStorage,
                  private val cafeMachine : LocalMachine) : FactoryItf() {

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach { productsStorage.addProduct(it) }
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        val drinks = mutableListOf<Product>()
        order.forEach { (productType, count) ->
            val receipt = when (productType) {
                ESPRESSO -> EspressoReceipt
                AMERICANO -> AmericanoReceipt
                CAPPUCCINO -> CappuccinoReceipt
                AMERICANO_WI_MILK -> AmericanoWithMilkReceipt
                LATE -> LateReceipt
                CACAO_DRINK -> CacaoDrinkReceipt
                else -> throw IllegalArgumentException("Invalid product type")
            }
            repeat(count) {
                val drink = cafeMachine.makeDrink(receipt)
                drinks.add(drink)
            }
        }
        return drinks
    }
    override fun getLeftovers(): List<Product> {
        val storageLeftovers = productsStorage.getLeftovers()
        //val machineLeftovers = orderedStats.getLeftovers()
        val leftovers = mutableMapOf<ProductType, Int>()
        storageLeftovers.forEach { leftovers.merge(it.type, it.count, Int::plus) }
        //machineLeftovers.forEach { leftovers.merge(it.type, it.count, Int::plus) }
        return leftovers.map { Product(it.key, it.value) }
    }

    override fun getUnpopularDrink(): Product {
        val drinkCounts = mutableMapOf<ProductType, Int>()
        val statistic = productsStorage.getLeftovers()
        statistic.forEach { drinkCounts.merge(it.type, it.count, Int::plus) }
        val unpopularDrink = drinkCounts.minByOrNull { it.value }
        return unpopularDrink?.let { Product(it.key, it.value) } ?: Product(NONE, 0)
    }

    override fun resetSimulation() {
        productsStorage.resetSimulation()
    }
}

object EspressoReceipt :Receipt(
    products = listOf(
        Product(type = COFFEE, count = 7),
        Product(type = WATER, count = 25),
    ),
    time=5,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ESPRESSO,
    price=25,
)
object AmericanoReceipt:Receipt(
    products = listOf(
        Product(type = COFFEE, count = 7),
        Product(type = SUGAR, count = 7),
        Product(type = WATER, count = 120),
    ),
    time=6,
    timeUnit = TimeUnit.SECONDS,
    outProductType = AMERICANO,
    price=30,
)
object CappuccinoReceipt :Receipt(
    products = listOf(
        Product(type = MILK, count = 50),
        Product(type = COFFEE, count = 9),
        Product(type = SUGAR, count = 7),
        Product(type = WATER, count = 110),
    ),
    time=10,
    timeUnit = TimeUnit.SECONDS,
    outProductType = CAPPUCCINO,
    price=30,
)
object AmericanoWithMilkReceipt :Receipt(
    products = listOf(
        Product(type = MILK, count = 30),
        Product(type = COFFEE, count = 7),
        Product(type = SUGAR, count = 14),
        Product(type = WATER, count = 90),
    ),
    time=8,
    timeUnit = TimeUnit.SECONDS,
    outProductType = AMERICANO_WI_MILK,
    price=35,
)
object LateReceipt :Receipt(
    products = listOf(
        Product(type = MILK, count = 150),
        Product(type = COFFEE, count = 10),
        Product(type = SUGAR, count = 14),
        Product(type = WATER, count = 50),
    ),
    time=10,
    timeUnit = TimeUnit.SECONDS,
    outProductType = LATE,
    price=40,
)
object CacaoDrinkReceipt :Receipt(
    products = listOf(
        Product(type = MILK, count = 180),
        Product(type = SUGAR, count = 25),
        Product(type = WATER, count = 30),
        Product(type = CACAO_POWDER, count = 13),
    ),
    time=9,
    timeUnit = TimeUnit.SECONDS,
    outProductType = CACAO_DRINK,
    price=40,
)

val mainFactory = CafeFactory(productsStorage, cafeMachine)

fun getSimulationObject(myFactory: CafeFactory = mainFactory): CafeFactory {
    return myFactory
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    getSimulationObject(mainFactory)
    startTestUi(seed(), labNumber())
}