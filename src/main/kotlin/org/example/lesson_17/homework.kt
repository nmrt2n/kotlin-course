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