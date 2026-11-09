package org.example.lesson_19

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

// =====================================================
// ЗАДАЧА 1. Абстрактные классы устройств без методов
// =====================================================

abstract class AbstractRefrigerator :
    Powerable, Openable, TemperatureRegulatable, WaterConnection

abstract class AbstractWashingMachine :
    Powerable, Openable, WaterContainer, WaterConnection,
    TemperatureRegulatable, AutomaticShutdown, Drainable, Timable, Programmable

abstract class AbstractSmartLamp :
    Powerable, LightEmitting, Timable, Programmable

abstract class AbstractElectronicClock :
    Powerable, Timable, SoundEmitting

abstract class AbstractRobotVacuum :
    Powerable, Movable, Cleanable, Rechargeable,
    BatteryOperated, AutomaticShutdown, Programmable

abstract class AbstractMechanicalClock :
    Mechanical

abstract class AbstractFlashlight :
    Powerable, LightEmitting, BatteryOperated

abstract class AbstractCoffeeMachine :
    Powerable, WaterContainer, WaterConnection,
    TemperatureRegulatable, Timable, AutomaticShutdown

abstract class AbstractSmartSpeaker :
    Powerable, SoundEmitting, Programmable, Rechargeable

// =====================================================
// ЗАДАЧА 2. Абстрактный класс включаемого оборудования.
// Реализуем интерфейс Powerable.
// =====================================================

abstract class PoweredEquipment : Powerable {

    // Состояние питания устройства.
    protected var isPowered: Boolean = false

    override fun powerOn() {
        isPowered = true
        println("Устройство включено")
    }

    override fun powerOff() {
        isPowered = false
        println("Устройство выключено")
    }
}


// =====================================================
// ЗАДАЧА 3. Абстрактный класс программируемого оборудования.
// Наследуется от PoweredEquipment.
// =====================================================

abstract class ProgrammableEquipment : PoweredEquipment(), Programmable {

    private var programmedAction: String = ""

    override fun programAction(action: String) {
        if (!isPowered) {
            println("Нельзя задать программу: устройство выключено")
            return
        }

        programmedAction = action
        println("Установлена программа: $programmedAction")
    }

    override fun execute() {
        if (!isPowered) {
            println("Нельзя запустить программу: устройство выключено")
            return
        }

        if (programmedAction.isBlank()) {
            println("Сначала необходимо задать программу")
            return
        }

        println("Выполняется программа: $programmedAction")
    }
}


// =====================================================
// ЗАДАЧА 4. Абстрактный класс оборудования,
// которое можно программировать, открывать и
// настраивать температуру.
// =====================================================

abstract class TemperatureOpenableEquipment :
    ProgrammableEquipment(),
    TemperatureRegulatable,
    Openable {

    // Максимальная температура задаётся в классах-наследниках.
    abstract override val maxTemperature: Int

    protected var currentTemperature: Int = 0

    override fun setTemperature(temp: Int) {
        if (!isPowered) {
            println("Нельзя установить температуру: устройство выключено")
            return
        }

        if (temp < 0 || temp > maxTemperature) {
            println("Недопустимая температура: $temp. Максимум: $maxTemperature")
            return
        }

        currentTemperature = temp
        println("Установлена температура: $currentTemperature °C")
    }

    override fun open() {
        println("Устройство открыто")
    }

    override fun close() {
        println("Устройство закрыто")
    }
}


// =====================================================
// ЗАДАЧА 5. Конкретные устройства.
// =====================================================

// ХОЛОДИЛЬНИК
class Refrigerator : TemperatureOpenableEquipment(),
    AutomaticShutdown,
    Timable {

    override val maxTemperature: Int = 10

    override val sensorType: String = "Датчик температуры"
    override val maxSensoredValue: Int = 10


    override fun getWater(amount: Int) {
        println("Холодильник выдаёт $amount мл воды")
    }

    override fun startMonitoring() {
        println("Холодильник контролирует температуру")
    }

    override fun setTimer(time: Int) {
        println("Таймер холодильника установлен на $time минут")
    }
}


// СТИРАЛЬНАЯ МАШИНА
class WashingMachine : TemperatureOpenableEquipment(),
    WaterContainer,
    WaterConnection,
    Drainable,
    AutomaticShutdown,
    Timable {

    override val maxTemperature: Int = 90
    override val capacity: Int = 60

    override val sensorType: String = "Датчик уровня воды"
    override val maxSensoredValue: Int = capacity

    override fun fillWater(amount: Int) {
        println("Стиральная машина набирает $amount литров воды")
    }

    // Один метод getWater реализует сразу два интерфейса:
    // WaterContainer и WaterConnection.
    override fun getWater(amount: Int) {
        println("Стиральная машина использует $amount литров воды")
    }

    override fun connectToWaterSupply() {
        println("Стиральная машина подключена к водопроводу")
    }

    override fun connectToDrain() {
        println("Стиральная машина подключена к сливу")
    }

    override fun drain() {
        println("Стиральная машина сливает воду")
    }

    override fun startMonitoring() {
        println("Стиральная машина контролирует уровень воды")
    }

    override fun setTimer(time: Int) {
        println("Таймер стирки установлен на $time минут")
    }
}


// ЧАЙНИК
class Kettle : TemperatureOpenableEquipment(),
    WaterContainer,
    AutomaticShutdown {

    override val maxTemperature: Int = 100
    override val capacity: Int = 2

    override val sensorType: String = "Датчик температуры воды"
    override val maxSensoredValue: Int = maxTemperature

    override fun fillWater(amount: Int) {
        println("В чайник налито $amount литров воды")
    }

    override fun getWater(amount: Int) {
        println("Из чайника набрано $amount литров воды")
    }

    override fun startMonitoring() {
        println("Чайник контролирует температуру воды")
    }
}


// ДУХОВКА
class Oven : TemperatureOpenableEquipment(),
    Timable,
    AutomaticShutdown {

    override val maxTemperature: Int = 250

    override val sensorType: String = "Датчик температуры"
    override val maxSensoredValue: Int = maxTemperature

    override fun setTimer(time: Int) {
        println("Таймер духовки установлен на $time минут")
    }

    override fun startMonitoring() {
        println("Духовка контролирует температуру")
    }
}


// =====================================================
// ПРОВЕРКА РАБОТЫ ПРОГРАММЫ
// =====================================================

fun main() {

    // ХОЛОДИЛЬНИК
    println("===== ХОЛОДИЛЬНИК =====")
    val refrigerator = Refrigerator()

    // Проверяем установку температуры при выключенном питании.
    refrigerator.setTemperature(5)
    refrigerator.programAction("Охлаждение")

    refrigerator.powerOn()
    refrigerator.setTemperature(5)
    refrigerator.programAction("Охлаждение продуктов")
    refrigerator.execute()
    refrigerator.open()
    refrigerator.close()
    refrigerator.connectToWaterSupply()
    refrigerator.getWater(200)
    refrigerator.startMonitoring()
    refrigerator.setTimer(30)
    refrigerator.powerOff()


    // СТИРАЛЬНАЯ МАШИНА
    println("\n===== СТИРАЛЬНАЯ МАШИНА =====")
    val washingMachine = WashingMachine()

    washingMachine.programAction("Быстрая стирка")
    washingMachine.setTemperature(40)

    washingMachine.powerOn()
    washingMachine.programAction("Быстрая стирка")
    washingMachine.setTemperature(40)
    washingMachine.execute()
    washingMachine.fillWater(20)
    washingMachine.getWater(20)
    washingMachine.connectToWaterSupply()
    washingMachine.connectToDrain()
    washingMachine.drain()
    washingMachine.startMonitoring()
    washingMachine.setTimer(60)
    washingMachine.open()
    washingMachine.close()
    washingMachine.powerOff()


    // ЧАЙНИК
    println("\n===== ЧАЙНИК =====")
    val kettle = Kettle()

    kettle.powerOn()
    kettle.setTemperature(100)
    kettle.fillWater(2)
    kettle.getWater(1)
    kettle.startMonitoring()
    kettle.open()
    kettle.close()
    kettle.powerOff()


    // ДУХОВКА
    println("\n===== ДУХОВКА =====")
    val oven = Oven()

    oven.powerOn()
    oven.setTemperature(180)
    oven.programAction("Выпечка")
    oven.execute()
    oven.setTimer(45)
    oven.startMonitoring()
    oven.open()
    oven.close()
    oven.powerOff()
}