package org.example.lesson_07

import org.example.lesson_04.i


//Напишите цикл for, который выводит числа от 1 до 5.
fun main() {
    for (i in 1..5) {
        println(i)
    }

    // Четные числа от 1 до 10
    for (i in 1..10) {
        if (i % 2 == 0) {
            println(i)
        }
    }
    // Числа от 5 до 1
    for (i in 5 downTo 1) {
        println(i)
    }

    // Числа от 10 до 1, уменьшая на 2
    for (i in 10 downTo 1 step 2) {
        println(i)
    }

    // Числа от 1 до 9 с шагом 2
    for (i in 1..9 step 2) {
        println(i)
    }

    // Каждое третье число от 1 до 20
    for (i in 1..20 step 3) {
        println(i)
    }
    // Создайте числовую переменную 'size'.
    // Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size: Int = 30
    for (i in 1 until size step 2) {
        print(i)
    }
    // Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var start: Int = 1
    while (start <= 5) {
        println(start * start)
        start += 1
    }
    // Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var start_down: Int = 10
    while (start => 5){
        print(start)
        start -= 1
    }
    // Цикл do while
    // Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var do_while_five_to_one: Int = 5
    do {
        println(do_while_five_to_one)
        do_while_five_to_one--
    } while (do_while_five_to_one >= 1)
    // Создайте цикл do while, который повторяется,
    // пока счетчик меньше 10, начиная с 5.
    var cnter: Int = 5
    do {
        println(cnter)
        cnter++
    } while (cnter < 10)
    // Задания для прерывания и пропуска итерации
    // Использование break
    // Напишите цикл for от 1 до 10
    // и используйте break,
    // чтобы выйти из цикла
    // при достижении 6.
    for (i in 1..10) {
        if (i == 6) {
            break
        }
        println(i)
    }
    // Создайте цикл while,
    // который бесконечно выводит числа,
    // начиная с 1, но прерывается
    // при достижении 10.
    var Inf: Int = 1

    while (Inf > 0) {
        if (Inf == 10) {
            break
        }
        println(Inf)
        Inf++
    }
    // Использование continue
    // В цикле for от 1 до 10
    // используйте continue,
    // чтобы пропустить четные числа.
    for (i in 1..10) {
        if (i % 2 == 0) {
            continue
        }
        println(i)
    }
    // Напишите цикл while,
    // который выводит числа от 1 до 10,
    // но пропускает числа, кратные 3.
    var startCounter: Int = 1
    while (startCounter <= 10) {
        if (startCounter % 3 != 0)
            println(startCounter)
        startCounter++
    }
}