package org.example.lesson_16

//Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами.
//
//Для производных классов также добавь специфичные для класса свойства. Детально описывать не нужно, упражнение на то, чтобы усвоить иерархию наследования и развитие функциональности у наследников.
//
//Геометрические Фигуры
//Базовый класс: Геометрическая Фигура
//Производные классы: Многоугольник, Круг
//Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник
//Учебные Заведения
//Базовый класс: Учебное Заведение
//Производные классы: Школа, …
//Дополнительное разветвление для …: …
//Иерархия Мебели
//Базовый класс: Мебель
//Производные классы: …
//Дополнительное разветвление для …: …

open class GeometricFigure(
    val color: String,
    val perimeter: Double,
    val volume: Double
){
    open fun calculateArea(): Double {
        return 0.0
    }
}

open class Polygon(
    color: String,
    perimeter: Double,
    volume: Double,
    val sideCount: Int
): GeometricFigure(color, perimeter, volume){

    fun calculateAngels():Double {
        return 0.0
    }
}

open class Cycle(
    color: String,
    perimeter: Double,
    volume: Double,
    val radius : Double
): GeometricFigure(color, perimeter, volume){

    fun calculateSegment(): Double {
        return 0.0
    }
}

class Tringle(
    color: String,
    perimeter: Double,
    volume: Double,
    val sideA: Double,
    val sideB: Double,
    val sideC: Double
): Polygon(color, perimeter, volume, 3)

class Quadrilateral(
    color: String,
    perimeter: Double,
    volume: Double,
    val weigh: Double,
    val height: Double
): Polygon(color, perimeter, volume, 4)

open class EducationalInstitution(
    val name: String,
    val type: String,
    val address: String,
    val studentsCount: Int
){
    fun getDetails(){
        println("Учебное заведение $name, находится по адресу: $address. Вместимость: $studentsCount")
    }
}

open class School(
    name: String,
    type: String,
    address: String,
    studentsCount: Int,
    val gradesCount: Int
):EducationalInstitution(name, type, address, studentsCount)

class University(
    name: String,
    type: String,
    address: String,
    studentsCount: Int,
    val facultiesCount: Int
):EducationalInstitution((name, type, address, studentsCount) {
    override fun describe() {
        println("$name: факультетов — $facultiesCount")
    }
}

open class Furniture(
    val material: String,
    val color: String,
    val price: Double
){
    open fun describe() {
        println("Тут инфа")
    }
}

open class Chair(
    material: String,
    color: String,
    price: Double,
    val legsCount: Int
) : Furniture(material, color, price)

open class Table(
    material: String,
    color: String,
    price: Double,
    val shape: String
) : Furniture(material, color, price)


//Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземлпяр этого класса, он нужен только для того, чтобы быть основой для подклассов.
//
//Создай подклассы этого контейнера, которые будут добавлять строку material (или коллекции или словари строк) в какое-то определённое место (места).
//
//Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
//Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными, которые уже есть. То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.
//Третий класс при добавлении строки должен отсортировать весь список метиралов в алфавитном порядке включая добавляемый материал.
//Четвёртый класс должен принимать словарь (ключи и значения строки). Каждая пара ключа и значения должна попадать в контейнер следующим образом - ключ в начало, значение в конец. Таким образом в начале должны быть ключи в обратном порядке, потом существующие материалы, потом все значения.
//


abstract class Materials {
    protected val materials = mutableListOf<String>()

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, material ->
            println("[$index]: $material")
        }
    }
}

// 1. Добавляет строку в начало списка (индекс 0)
class AddToBeginning : Materials() {
    fun addMaterial(material: String) {
        materials.add(0, material)
    }
}

// 2. Добавляет строки поочерёдно с существующими
class InterleaveMaterials : Materials() {
    fun addMaterials(newMaterials: List<String>) {
        newMaterials.forEachIndexed { index, material ->
            materials.add(index * 2.coerceAtMost(materials.size), material)
        }
    }
}

// 3. Добавляет строку и сортирует весь список
class SortMaterials : Materials() {
    fun addMaterial(material: String) {
        materials.add(material)
        materials.sort()
    }
}

// 4. Ключи в начало, значения в конец
class MapMaterials : Materials() {
    fun addMaterials(newMaterials: Map<String, String>) {
        newMaterials.forEach { (key, _) ->
            materials.add(0, key)
        }

        newMaterials.values.forEach { value ->
            materials.add(value)
        }
    }
}