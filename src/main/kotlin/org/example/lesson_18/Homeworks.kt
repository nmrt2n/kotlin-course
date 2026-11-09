package org.example.lesson_18


class GameMachine(
    // Неизменяемые характеристики
    val color: String,
    val model: String,
    val hasJoystick: Boolean,
    val owner: String,
    val supportPhone: String,
    val sessionCost: Double,

    // Приватные данные
    private val pinCode: String
) {

    // Состояния автомата могут изменяться
    private var isOn: Boolean = false
    private var osLoaded: Boolean = false

    // Список игр нельзя заменить извне,
    // но внутри класса можно добавлять и удалять игры
    private val installedGames = mutableListOf<String>()

    // Баланс вырученных средств
    private var revenue: Double = Double.ZERO

    // Статус оплаты сеанса
    private var sessionPaid: Boolean = false

    // Включить автомат
    fun turnOn(): Unit {
        isOn = true
    }

    // Выключить автомат
    fun turnOff(): Unit {
        osLoaded = false
        isOn = false
    }

    // Загрузить операционную систему
    fun loadOS(): Boolean {
        if (!isOn) return false
        osLoaded = true
        return true
    }

    // Завершить работу ОС
    fun shutdownOS(): Unit {
        osLoaded = false
    }

    // Показать список игр
    fun showGames(): List<String> {
        return installedGames.toList()
    }

    // Включить игру
    fun startGame(gameName: String): Boolean {
        if (!isOn || !osLoaded || !sessionPaid) return false
        if (gameName !in installedGames) return false

        sessionPaid = false
        return true
    }

    // Оплатить игровой сеанс
    fun paySession(amount: Double): Boolean {
        if (amount < sessionCost) return false

        revenue += amount
        sessionPaid = true
        return true
    }

    // Забрать наличные с помощью пин-кода
    fun withdrawCash(inputPin: String): Double? {
        if (inputPin != pinCode) return null

        return openSafeAndDispenseCash()
    }

    // Открыть сейф и выдать наличные
    private fun openSafeAndDispenseCash(): Double {
        val cash = revenue
        revenue = Double.ZERO
        return cash
    }

    // Добавление игры (служебный метод)
    fun installGame(gameName: String): Unit {
        if (gameName !in installedGames) {
            installedGames.add(gameName)
        }
    }
}


abstract class BaseClass(
    // 1. privateVal доступен в main() через ChildrenClass,
    // потому что в ChildrenClass он объявлен как публичное свойство val.
    // Это отдельное свойство дочернего класса, а не доступ к privateVal родителя.
    private val privateVal: String,

    // 2. protectedVal недоступен в main(), потому что protected
    // разрешает доступ только внутри класса и его наследников.
    protected val protectedVal: String,

    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    // 5. protectedField можно изменить из дочернего класса,
    // но нельзя напрямую изменить из main().
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"

    // 6. privateField недоступно напрямую из main() и наследника.
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. Этот метод protected, потому что он возвращает ProtectedClass,
    // который тоже имеет модификатор protected.
    // Нельзя сделать метод public, так как тогда публичный метод
    // предоставлял бы доступ к типу с ограниченной видимостью.
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. При вызове getAll() будет вызвана версия generate()
    // из ChildrenClass, если объект создан как ChildrenClass.
    // Это происходит благодаря полиморфизму.
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. Этот метод private, потому что возвращает PrivateClass,
    // который тоже объявлен private.
    // Сделать метод public или protected нельзя,
    // так как он предоставлял бы доступ к приватному типу.
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}

class ChildrenClass(
    // 1. Здесь privateVal объявлен как публичное свойство val.
    // Поэтому child.privateVal доступен в main().
    val privateVal: String,

    // 2. protectedVal не объявлен через val или var,
    // поэтому это только параметр конструктора.
    // Он передаётся родительскому классу.
    protectedVal: String,

    // 10. publicVal также не объявлен через val или var.
    // Поэтому это параметр конструктора, а не свойство объекта.
    // Его можно передать при создании объекта,
    // но нельзя получить через child.publicVal.
    publicVal: String

) : BaseClass(privateVal, protectedVal, publicVal) {

    // 4. Переопределяем проверку значения.
    // Теперь можно записать строку "Антонио Бандераса",
    // поскольку она не пустая.
    override fun verifyPublicField(value: String): Boolean {
        return value.isNotBlank()
    }

    // 5. Публичный сеттер для изменения protectedField.
    // Доступ к protectedField разрешён внутри наследника.
    fun setProtectedField(value: String) {
        protectedField = value
    }

    // 6. Сеттер для изменения privateField через Reflection.
    // Обычный доступ невозможен, потому что поле private
    // и принадлежит BaseClass.
    // Reflection позволяет получить доступ к нему на JVM.
    // Это обход ограничения доступа, а не рекомендуемый подход.
    fun setPrivateField(value: String) {
        val field = BaseClass::class.java
            .getDeclaredField("privateField")

        field.isAccessible = true
        field.set(this, value)
    }

    // 7. Метод для проверки возможности получить ProtectedClass.
    // Сам тип ProtectedClass доступен наследнику.
    fun createProtectedClass() {
        getProtectedClass()
    }

    // 8. Переопределяем метод generate().
    // При вызове getAll() будет использоваться эта версия.
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    // 12. Этот метод не переопределяет privatePrint() родителя.
    // Он является отдельным методом дочернего класса,
    // потому что private-методы не наследуются.
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
}

fun main() {

    // Создаём объект дочернего класса.
    val child = ChildrenClass(
        "Моё значение privateVal",
        "Моё значение protectedVal",
        "Моё значение publicVal"
    )

    // 1. Доступ к публичному свойству дочернего класса.
    println(child.privateVal)

    // 2. Так обратиться нельзя:
    // println(child.protectedVal)
    // protectedVal не является публичным свойством ChildrenClass.

    // 3 и 4. Изменяем publicField на Антонио Бандераса.
    // Значение пройдёт проверку verifyPublicField() из ChildrenClass.
    child.publicField = "Антонио Бандераса"

    // 5. Изменяем protectedField через метод наследника.
    child.setProtectedField("Новое значение protectedField")

    // 6. Изменяем privateField через Reflection.
    child.setPrivateField("Новое значение privateField")

    // 8 и 11. getAll() наследуется от BaseClass.
    // Внутри getAll() вызывается переопределённый generate().
    println("\nВсе значения объекта:")
    println(child.getAll())

    // 12. Вызываем метод родительского класса.
    // Он обращается к своему privatePrint(),
    // поэтому выводится текст из BaseClass.
    child.printText()

    // 10. publicVal нельзя получить через child.publicVal,
    // так как он является только параметром конструктора.
}
