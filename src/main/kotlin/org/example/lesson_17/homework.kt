package org.example.lesson_17
import kotlin.math.PI
import kotlin.math.sqrt

// Переопределение методов
//
//Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике,
// чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet".
//Обогати вывод звуков цветом.
//
//Создайте список животных List<Animal> и вызовите в цикле метод makeSound()
//
//
fun main(){
    val animals: List<Animal> = listOf(
        Dog(),
        Cat(),
        Bird()
    )

    animals.forEach { animal ->
        animal.makeSound()
    }

    val shapes: List<Shape> = listOf(
        Circle(5.0),
        Rectangle(4.0, 6.0),
        Triangle(3.0, 8.0)
    )

    shapes.forEach {
        println("Area: ${it.area()}")
}

object Colors {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}
object Background {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}

abstract class Animal() {
    open fun makeSound(){
        println("This animal makes no sound.")
    }
}

class Dog: Animal(){
    override fun makeSound(){
        println("${Colors.RED}Bark${Colors.RESET}")
    }
}

class Cat: Animal(){
    override fun makeSound() {
        println("${Colors.BLUE}Meow${Colors.RESET}")
    }
}

class Bird: Animal(){
    override fun makeSound() {
        println("${Colors.GREEN}Tweet${Colors.RESET}")
    }
}

//Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
abstract class Shape(){
    open fun area(): Double = 0.0
}

class Circle(val radius: Double): Shape(){
    override fun area(): Double {
        return PI * radious * radius
    }
}

class Square(val side: Double): Shape() {
    override fun area(): Double {
        return side * side
    }
}

class Triangle(
    val sideA: Double,
    val height: Double) : Shape() {

    override fun area(): Double {
        return (sideA * height) / 2
    }
}

//Принтер
//Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом фоне
// (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном фоне.
// Слова должны быть разноцветны.
//Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку при выводе текста.
// Проверить работу на длинном тексте

abstract class Printer {
    open fun print(text: String){
        println(text)
    }
}

class LaserPrinter : Printer() {
    override fun print(text: String) {
       val words = text.split(" ")

       words.forEach { word ->
       println("${Colors.BLACK}${Background.WHITE}$word${Colors.RESET}")
       }
    }
}

private val colorPairs: Printer(){

    override fun print(text: String) {
        val words = text.split(" ")

        words.forEachIndexed { index, word ->
            val (textColor, backgroundColor) =
                colorPairs[index % colorPairs.size]

            println("$textColor$backgroundColor$word${Colors.RESET}")
        }
    }
}

// Перегрузка методов
//
//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.
//Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.


// Корзина товаров

    class ShoppingCart {

        private val items = mutableMapOf<Int, Int>()

        // Добавление одного товара
        fun addToCart(itemId: Int) {
            items[itemId] = items.getOrDefault(itemId, 0) + 1
        }

        // Добавление нескольких единиц одного товара
        fun addToCart(itemId: Int, amount: Int) {
            if (amount <= 0) {
                println("Количество должно быть больше нуля!")
                return
            }

            items[itemId] = items.getOrDefault(itemId, 0) + amount
        }

        // Добавление словаря товаров
        fun addToCart(newItems: Map<Int, Int>) {
            newItems.forEach { (itemId, amount) ->
                addToCart(itemId, amount)
            }
        }

        // Добавление списка товаров
        fun addToCart(itemIds: List<Int>) {
            itemIds.forEach { itemId ->
                addToCart(itemId)
            }
        }

        // Красивое отображение корзины
        override fun toString(): String {

            val totalArticles = items.size
            val totalAmount = items.values.sum()

            val result = StringBuilder()

            result.appendLine("========== SHOPPING CART ==========")
            result.appendLine("ID товара     Количество")
            result.appendLine("-----------------------------------")

            items.forEach { (itemId, amount) ->
                result.appendLine(
                    "%-14d %d".format(itemId, amount)
                )
            }

            result.appendLine("-----------------------------------")
            result.appendLine("Всего артикулов: $totalArticles")
            result.appendLine("Всего товаров: $totalAmount")
            result.appendLine("===================================")

            return result.toString()
        }
    }

// Логгер

    class Logger {

        // INFO: одно сообщение
        fun log(message: String) {
            println("${Colors.GREEN}[INFO]${Colors.RESET} $message")
        }

        // Сообщение с выбранным уровнем
        fun log(level: String, message: String) {

            when (level.uppercase()) {

                "INFO" -> {
                    println("${Colors.GREEN}[INFO]${Colors.RESET} $message")
                }

                "WARNING" -> {
                    println("${Colors.YELLOW}[WARNING]${Colors.RESET} $message")
                }

                "ERROR" -> {
                    println(
                        "${Colors.WHITE}${Background.RED}[ERROR] $message${Colors.RESET}"
                    )
                }

                "DEBUG" -> {
                    println("${Colors.BLUE}[DEBUG]${Colors.RESET} $message")
                }

                else -> {
                    println("[UNKNOWN] $message")
                }
            }
        }

        // Список сообщений
        fun log(messages: List<String>) {
            messages.forEach { message ->
                log(message)
            }
        }

        // Вывод исключения
        fun log(exception: Exception) {
            println(
                "${Colors.WHITE}${Background.RED}" +
                        "[ERROR] ${exception.message}${Colors.RESET}"
            )
        }
    }

// Главная функция

    fun main() {

        // Проверка корзины

        val cart = ShoppingCart()

        println("Добавляем товары в корзину:")

        // Добавляем один товар
        cart.addToCart(101)

        // Добавляем несколько единиц товара
        cart.addToCart(102, 5)

        // Добавляем словарь товаров
        cart.addToCart(
            mapOf(
                101 to 3,
                103 to 2,
                104 to 4
            )
        )

        // Добавляем список товаров
        cart.addToCart(
            listOf(101, 102, 105, 105, 106)
        )

        println(cart)

        // Проверка логгера

        val logger = Logger()

        println("========== LOGGER ==========")

        // Обычное сообщение
        logger.log("Программа успешно запущена")

        // Сообщения с разными уровнями
        logger.log("WARNING", "Недостаточно места на диске")
        logger.log("ERROR", "Не удалось подключиться к серверу")
        logger.log("DEBUG", "Проверка переменной")

        // Список сообщений
        logger.log(
            listOf(
                "Пользователь вошёл в систему",
                "Данные загружены",
                "Операция выполнена успешно"
            )
        )

        // Исключение
        try {
            val number = 10 / 0
        } catch (e: Exception) {
            logger.log(e)
        }
    }
