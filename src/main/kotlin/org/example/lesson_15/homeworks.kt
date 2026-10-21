package org.example.lesson_15

fun main(){
    val party = Party("Дома", 2)
    party.details()
    val emotion = Emotion("сметься", 99)
    emotion.express()
    Moon.showPhase()
    val beer = Product("Пиво", 14.50, 16)
    println(beer)
    val event = Event(
        "Коррозия металла",
        "Мухосранск",
        150.00, 99
    )
    event.showInformation()
    event.buyTicket()
    val rack = Rack(3)

    val shelf1 = Shelf(10)
    val shelf2 = Shelf(15)
    val shelf3 = Shelf(8)

    rack.addShelf(shelf1)
    rack.addShelf(shelf2)
    rack.addShelf(shelf3)

    rack.addItem("Книга")
    rack.addItem("Чашка")
    rack.addItem("Телефон")
    rack.addItem("Ключи")

    rack.printContents()

    println("Есть книга: ${rack.containsItem("Книга")}")

    println("Удаление чашки: ${rack.removeItem("Чашка")}")

    val notPlaced = rack.advancedRemoveShelf(0)
    println("Не удалось разместить: $notPlaced")

    rack.printContents()
}

// Событие: вечеринка. Создайте класс Party, который описывает вечеринку.
// У него должны быть свойства location (String) и attendees (Int).
// Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
class Party(val location: String, val attendees: Int) {
    fun details() {
        println("Вечеринка проводится $location, количество участников $attendees")
    }
}

// Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию.
// У него должно быть свойство type (String) и intensity (Int).
// Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.

class Emotion(val type: String, val intensity: Int) {
    fun express(){
        println("Эмоция $type, уровень интенсивности $intensity")
    }
}

//Природное явление: луна. Создайте объект Moon, который будет представлять Луну.
// Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент,
// и phase (String), чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon").
// Добавьте метод showPhase(), который выводит текущую фазу Луны.

object Moon {
    val isVisible = true
    val phase = "Full Moon"

    fun showPhase() {
        if (isVisible) {
            println("Луна светит, фаза $phase")
        } else {
            println("Луна не видна")
        }
    }
}

// Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине.
// У него должны быть свойства “название”, “цена”, “количество”.

data class Product(
    val name: String,
    val price: Double,
    val count: Int)

// Мероприятие: концерт. Создайте класс, который будет представлять концерт.
// У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
// Также приватное поле “проданные билеты”.
// Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.


class Event(
    val band: String,
    val location: String,
    val price: Double,
    val capacity: Int,
    private var soldTickets: Int = 0
) {
    fun showInformation() {
        println("Концерт группы $band, место: $location, цена билета: $price, осталось мест: ${capacity - soldTickets}")
    }

    fun buyTicket() {
        if (soldTickets < capacity) {
            soldTickets++
            println("Билет куплен!")
        } else {
            println("Билетов больше нет.")
        }
    }
}

// Задание 6. Стеллаж и полки.
//
//Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
//
//Класс Shelf (Полка Стеллажа)
//
//Характеристики:
//
//Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
//Список предметов (items): хранит названия предметов на полке.
//Методы:
//
//Добавление Предмета (addItem):
//Принимает название предмета.
//Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
//Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
//Удаление Предмета (removeItem):
//Принимает название предмета.
//Удаляет предмет, если он найден на полке.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
//Проверка Вместимости (canAccommodate):
//Принимает название предмета.
//Определяет, вместится ли предмет на полку.
//Возвращает true, если предмет вместится, и false, если места недостаточно.
//Проверка наличия предмета (containsItem):
//Принимает название предмета
//Возвращает true если такой предмет есть
//Получение списка предметов (getItems):
//Возвращает неизменяемый список предметов

class Shelf(val capacity: Int) {
    private val items = mutableListOf<String>()

    fun addItem(name: String): Boolean {
        if (!canAccommodate(name)) return false
        items.add(name)
        return true
    }

    fun removeItem(name: String): Boolean {
        return items.remove(name)
    }

    fun canAccommodate(name: String): Boolean {
        return items.sumOf { it.length } + name.length <= capacity
    }

    fun containsItem(name: String): Boolean {
        return name in items
    }

    fun getItems(): List<String> {
        return items.toList()
    }

    fun remainingCapacity(): Int {
        return capacity - items.sumOf { it.length }
    }
}

// Класс Rack (Стеллаж)
//
//Характеристики:
//
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.
//Методы:
//
//Добавление Полки (addShelf):
//Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
//Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
//Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
//Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
//Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
//Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
//Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.

class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()


    // Добавление полки, true -> SUCCESS, fail -> нету места
    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.contains(shelf) || shelves.size == maxShelves) return false

        shelves.add(shelf)
        return true
    }

    // Удаление полки
    fun removeShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()

        return shelves.removeAt(index).getItems()
    }

    // Добавляем предмет
    fun addItem(name: String): Boolean {
        for (shelf in shelves) {
            if (shelf.addItem(name)) return true
        }
        return false
    }

    // Удаление предмета
    fun removeItem(name: String): Boolean {
        for (shelf in shelves) {
            if (shelf.removeItem(name)) return true
        }
        return false
    }

    // Проверка наличия предмета на стеллаже
    fun containsItem(name: String): Boolean {
        return shelves.any { it.containsItem(name) }
    }

    // Получение неизменяемого списка полок
    fun getShelves(): List<Shelf> = shelves.toList()

    //Печать Содержимого (printContents) о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
    fun printContents() {
        if (shelves.isEmpty()) {
            println("Стеллаж пуст")
            return
        }

        shelves.forEachIndexed { index, shelf ->
            println("Полка ${index + 1}:")
            println("Вместимость: ${shelf.capacity}")
            println("Свободно: ${shelf.remainingCapacity()}")
            println("Предметы: ${shelf.getItems()}")
        }
    }

    // Сложное удаление полки
    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()

        val removedList = shelves.removeAt(index)
            .getItems()
            .sortedByDescending({it.length})

        val notPlaced = mutableListOf<String>()

        for (item in removedList) {
            var placed = false

            for (shelf in shelves) {
                if (shelf.addItem(item)) {
                    placed = true
                    break
                }
            }

            if (!placed) {
                notPlaced.add(item)
            }
        }

        return notPlaced.toList()
    }
}