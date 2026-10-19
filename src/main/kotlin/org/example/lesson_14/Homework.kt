package org.example.lesson_14

fun main() {
    // 1. Среднее время выполнения тестов — average()
    val testTimes = mapOf(
        "testLogin" to 2.5,
        "testLogout" to 1.5,
        "testPayment" to 4.0
    )
    println(testTimes.values.average()) // 2.666...

    // 2. Список имён тестовых методов — keys
    val metadata = mapOf(
        "testLogin" to "UI; smoke",
        "testPayment" to "API; regression",
        "testSearch" to "UI; regression"
    )
    println(metadata.keys.toList())

    // 3. Добавить тест и результат — put()
    val testResults = mutableMapOf(
        "testLogin" to "passed",
        "testPayment" to "failed"
    )
    testResults.put("testSearch", "passed")
    println(testResults)

    // 4. Количество успешных тестов — count()
    val results = mapOf(
        "testLogin" to "passed",
        "testPayment" to "failed",
        "testSearch" to "passed",
        "testLogout" to "skipped"
    )
    println(results.count { it.value == "passed" })

    // 5. Удалить исправленный баг — remove()
    val bugs = mutableMapOf(
        "BUG-101" to "fixed",
        "BUG-102" to "open",
        "BUG-103" to "fixed"
    )
    bugs.remove("BUG-101")
    println(bugs)

    // 6. Вывести страницу и статус — forEach()
    val pages = mapOf(
        "https://example.com" to 200,
        "https://example.com/login" to 401,
        "https://example.com/missing" to 404
    )
    pages.forEach { (url, status) ->
        println("Страница: $url, статус: $status")
    }

    // 7. Найти сервисы с долгим временем ответа — filter()
    val responseTimes = mapOf(
        "AuthService" to 120.0,
        "PaymentService" to 450.0,
        "SearchService" to 280.0
    )
    val threshold = 250.0
    println(responseTimes.filter { it.value > threshold })

    // 8. Найти статус endpoint или сообщить, что он не тестировался — get()
    val apiResults = mapOf(
        "/api/users" to "200 OK",
        "/api/orders" to "500 Internal Server Error"
    )
    val endpoint = "/api/products"
    println(apiResults.get(endpoint) ?: "Endpoint не был протестирован")

    // 9. Получить browserType, значение не должно быть null — getValue()
    val environment = mapOf(
        "browserType" to "Chrome",
        "platform" to "Linux"
    )
    println(environment.getValue("browserType"))

    // 10. Создать копию Map с новой версией — +
    val versions = mapOf(
        "stable" to "2.4.0",
        "beta" to "2.5.0-beta"
    )
    val updatedVersions = versions + ("rc" to "2.5.0-rc")
    println(updatedVersions)
}

fun main2() {
    // 11. Настройки устройства или значение по умолчанию — getOrDefault()
    val deviceSettings = mapOf(
        "Pixel 9" to "Android 16; API 36",
        "iPhone 17" to "iOS; Safari"
    )
    println(deviceSettings.getOrDefault("Galaxy S25", "Настройки по умолчанию"))

    // 12. Проверить наличие кода ошибки — containsKey()
    val errors = mapOf(
        "E001" to "Timeout",
        "E002" to "Connection refused",
        "E003" to "Invalid response"
    )
    println(errors.containsKey("E002"))

    // 13. Оставить сценарии нужной версии — filterKeys()
    val scenarios = mapOf(
        "Test01_V1" to "Passed",
        "Test02_V2" to "Failed",
        "Test03_V2" to "Skipped",
        "Test04_V1" to "Passed"
    )
    val requiredVersion = "V2"
    println(scenarios.filterKeys { requiredVersion in it })

    // 14. Проверить наличие проваленных модулей — any()
    val moduleResults = mapOf(
        "Authentication" to "passed",
        "Payments" to "failed",
        "Search" to "passed"
    )
    println(moduleResults.any { it.value == "failed" })

    // 15. Добавить настройки из другого словаря — putAll()
    val testEnvironment = mutableMapOf(
        "browser" to "Chrome",
        "timeout" to "30"
    )
    val additionalSettings = mapOf(
        "platform" to "Linux",
        "headless" to "true"
    )
    testEnvironment.putAll(additionalSettings)
    println(testEnvironment)

    // 16. Объединить два неизменяемых словаря — plus()
    val bugsA = mapOf(
        "BUG-101" to "open",
        "BUG-102" to "fixed"
    )
    val bugsB = mapOf(
        "BUG-103" to "open",
        "BUG-104" to "in progress"
    )
    val allBugs = bugsA.plus(bugsB)
    println(allBugs)

    // 17. Очистить временные данные — clear()
    val temporaryResults = mutableMapOf(
        "testA" to "passed",
        "testB" to "failed"
    )
    temporaryResults.clear()
    println(temporaryResults)

    // 18. Исключить пропущенные тесты — filterValues()
    val report = mapOf(
        "testLogin" to "passed",
        "testPayment" to "skipped",
        "testSearch" to "failed",
        "testLogout" to "skipped"
    )
    println(report.filterValues { it != "skipped" })

    // 19. Создать копию словаря без нескольких конфигураций — minus()
    val configs = mapOf(
        "Chrome" to "Desktop",
        "Firefox" to "Desktop",
        "Safari" to "Mobile",
        "Edge" to "Desktop"
    )
    val reducedConfigs = configs - listOf("Firefox", "Edge")
    println(reducedConfigs)

    // 20. Преобразовать результаты в список строк — map()
    val testReport = mapOf(
        "TC-001" to "Passed",
        "TC-002" to "Failed",
        "TC-003" to "Skipped"
    )
    val reportLines = testReport.map { (id, result) ->
        "Test ID: $id — $result"
    }
    println(reportLines)
}

fun main3() {
    // 21. Преобразовать MutableMap в неизменяемый Map — toMap()
    val mutableResults = mutableMapOf(
        "testLogin" to "passed",
        "testPayment" to "failed"
    )
    val archivedResults: Map<String, String> = mutableResults.toMap()
    println(archivedResults)

    // 22. Заменить числовые ключи строковыми — mapKeys()
    val numericTestTimes = mapOf(
        101 to 2.5,
        102 to 3.8,
        103 to 1.7
    )
    val stringKeyTimes = numericTestTimes.mapKeys { it.key.toString() }
    println(stringKeyTimes)

    // 23. Увеличить время ответа на 10% — mapValues()
    val performance = mapOf(
        "1.0" to 120.0,
        "2.0" to 150.0,
        "3.0" to 180.0
    )
    val adjustedPerformance = performance.mapValues { it.value * 1.10 }
    println(adjustedPerformance)

    // 24. Проверить, пуст ли словарь — isEmpty()
    val compilationErrors = emptyMap<String, String>()
    println(compilationErrors.isEmpty())

    // 25. Убедиться, что результаты нагрузочного тестирования не пусты — isNotEmpty()
    val loadResults = mapOf(
        "GET /users" to "passed",
        "POST /orders" to "passed"
    )
    println(loadResults.isNotEmpty())

    // 26. Проверить, прошли ли все тесты — all()
    val automatedResults = mapOf(
        "testLogin" to "passed",
        "testSearch" to "passed",
        "testPayment" to "passed"
    )
    println(automatedResults.all { it.value == "passed" })

    // 27. Проверить, есть ли хотя бы один тест с ошибкой — any()
    val executionResults = mapOf(
        "testLogin" to "passed",
        "testPayment" to "failed",
        "testSearch" to "passed"
    )
    println(executionResults.any { it.value == "failed" })

    // 28. Оставить неуспешные тесты, в названии которых есть optional — filter()
    val serviceResults = mapOf(
        "testOptionalAuth" to "failed",
        "testOptionalCache" to "passed",
        "testRequiredPayment" to "failed",
        "testOptionalSearch" to "failed"
    )
    val optionalFailures = serviceResults.filter { (name, status) ->
        "optional" in name.lowercase() && status != "passed"
    }
    println(optionalFailures)
}