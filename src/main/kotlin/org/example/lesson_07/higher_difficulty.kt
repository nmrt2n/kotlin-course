package org.example.lesson_07

fun main(){
    //Используя вложенный цикл
    // реализовать таблицу умножения,
    // как на картинке.
    for (i in 1..10) {
        for (j in 1..10) {
            print("${i * j}\t")
        }
        println()
    }
    // Напишите функцию, которая суммирует числа
    // от 1 до 'arg' с помощью цикла for.
    // 'arg' - целочисленный аргумент функции.
    val arg: Int = 14
    result = 0
    for (i in 1..arg){
        result += i
    }
    println(result)
    // Напишите функцию, которая вычисляет
    // факториал числа 'arg' с использованием
    // цикла while.
    var arg1: Int = 4
    var factorial: Int = 1
    while (arg1 > 0) {
        factorial *= arg1--
    }
    println(factorial)
    //Напишите функцию, которая находит
    // сумму всех четных чисел от 2 до 'arg',
    // используя цикл while.
    var arg2: Int = 4
    var f = 1
    while (arg2 > 0){
        if (arg2 % 2 == 0)
            f *= arg2
        arg2--
    }
    println(f)
}

// Напишите функцию, которая используя вложенные
// циклы while, выведет заполненный
// прямоугольник размером 5x3 из символов *.

fun rectangle(){
    var i: Int = 0

    while (i < 3){

        var j: Int = 0

        while (j < 5){
            print("*")
            j++
        }

        println()
        i++
    }
}

// Напишите функцию, которая используя цикл
// for найдёт суммы чётных и нечётных значений
// чисел от 1 до arg.

fun sum(){
    var evenSum: Int = 0
    var oddSum: Int = 0
    val arg: Int = 22

    for (i in 1..arg) {
        if (i % 2 == 0)
            evenSum += i
        else if (i % 2 != 0)
            oddSum += i
    }
    println("Сумма четных чисел: $evenSum")
    println("Сумма нечетных чисел: $oddSum")
}