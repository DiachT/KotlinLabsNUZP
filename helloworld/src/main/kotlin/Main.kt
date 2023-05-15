import com.diacht.ktest.*
import com.diacht.ktest.compose.startTestUi
import com.diacht.ktest.library.BuildConfig
import kotlin.math.*

fun seed(): String = "picardKotlin"

fun labNumber() : Int = 3

fun iCalculate(x0 : Int = 27, x1 : Int = 98, x2 : Int = 53) : Double{
    var result : Double = sqrt((x0 * x1 * x2).toDouble()) // Розрахунок по формулі
    return result // Повернення результату
}

fun dCalculate(x0 : Double = 104.55, x1 : Double = -182.56, x2 : Double = -30.3, x3 : Double = 0.51) : Double{
    var result : Double = tanh(maxOf(abs(x0), abs(x1), abs(x2), abs(x3))) // Розрахунок по формулі
    return result // Повернення результату
}

fun strCalculate(x0 : String = "TGTCJA", x1 : String = "AJJTTJ") : Int{
    var result : Int = 0
    for (i in x0.indices) { // Цикл для проходження по рядку
        if(x0[i] == 'T' || x0[i] == 'C'){ // Умова за якої починається порівняння з другою строкою
            if (x0[i] != x1[i]) { // Порівняння символу першої строки з відповідним символом другої
                if (i < x0.length / 2) { // Перевірка на місцезнаходження елемента в першій або другій частині рядка
                    result += 2
                } else {
                    result++
                }
            }
        }
    }
    return result // Повернення результату
}

class localStorage : Storage{
    var productStorage : List<Product> = mutableListOf<Product>();

    private fun haveProduct(type: ProductType) : Boolean{
        for (product in productStorage){
            if (product.type == type){
                return true;
            };
        }
        return false;
    }

    private fun indexProduct(type: ProductType) : Int {
        for ((index, product) in productStorage.withIndex()){
            if (product.type == type){
                return index;
            };
        }
        return 0;
    }
    override fun addProduct(product: Product) {
        val haveProduct : Boolean = haveProduct(product.type);
        if(haveProduct) {
            productStorage[indexProduct(product.type)].count += product.count; // Якщо продукт вже існує додаємо йому кількість
        } else{
            productStorage += product; // Якщо продукту це не існує просто пушимо його в сховище
        }
    }

    override fun checkProductCount(type: ProductType): Int {
        var result : Int = 0;
        val haveProduct : Boolean = haveProduct(type) && productStorage[indexProduct(type)].count != 0; // Пошук продукту в сховищі
        if (haveProduct) {
            result = productStorage[indexProduct(type)].count; // Запис к-сті продукту в сховищі, якщо знайшли
        }
        return result;
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        val haveProduct : Boolean = haveProduct(productType) && productStorage[indexProduct(productType)].count != 0; // Пошук продукту в сховищі
        var getedProduct = Product(NONE, 0); // Повертаємий продукт продукт(В початковому значенні NONE, якщо умова не проходить, верне пустотий об'єкт.)
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
        productStorage = mutableListOf<Product>(); //Перезапуск симуляції
    }
}
private val productsStorage = localStorage();
private val orderedStats = localStorage();

class localMachine(storage: localStorage) : Machine(storage)
private val JuicePress = localMachine(productsStorage);

class localFactory(private val productsStorage: localStorage, private val JuicePress : localMachine, private val orderedStats: localStorage) : FactoryItf(){

    val drinkList = mapOf<ProductType, Receipt>(
        ORANGE_JUICE to OrangeJuice,
        APPLE_JUICE to AppleJuice,
        APPLE_CARROT_JUICE to AppleCarrotJuice,
        TOMATO_CARROT_JUICE to TomatoCarrotJuice,
        TOMATO_JUICE to TomatoJuice
    )
    override fun resetSimulation() {
        productsStorage.resetSimulation()
        orderedStats.resetSimulation()
    }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        JuicePress.consumeProducts(productsFromSupplier)
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        var ordered : List<Product> = mutableListOf<Product>();
        for (juice in order){
            for(i in 0 until juice.second) {
                drinkList[juice.first]?.let { JuicePress.setReceipt(it) }
                orderedStats.addProduct(JuicePress.executeProcess())
            }
            ordered += Product(JuicePress.executeProcess().type, juice.second)
        }
        return ordered;
    }

    override fun getLeftovers(): List<Product> {
        return JuicePress.getLeftovers()
    }

    override fun getEarnings(): Int {
        return super.getEarnings()
    }

    override fun getOrderStatistics(): List<Product> {
        var statistic = orderedStats.getLeftovers();
        if (statistic.size > 0)
            return statistic;
        else
            return super.getOrderStatistics()
    }

    override fun getPopularDrink(): Product {
        var statistic = orderedStats.getLeftovers();
        var topDrink : Product = Product(NONE, 0);
        if (statistic.size > 0){
            for (product in statistic) {
                if (product.count > topDrink.count)
                    topDrink = product;
            }
        }
        return topDrink;
    }

    override fun getUnpopularDrink(): Product {
        var statistic = orderedStats.getLeftovers();
        var worstDrink : Product = Product(NONE, 0);
        if (statistic.size < 0){
            for (product in statistic) {
                if (product.count > worstDrink.count)
                    worstDrink = product;
            }
        }
        return worstDrink;
    }
}

val mainFactory = localFactory(productsStorage, JuicePress, orderedStats);

fun getSimulationObject(myFactory : localFactory = mainFactory): localFactory {
    return myFactory;
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

//    iCalculate() //2.1
//    dCalculate() //2.2
//    strCalculate() //2.3

    getSimulationObject(mainFactory); // 3.1 3.2

    startTestUi(seed(), labNumber())
}