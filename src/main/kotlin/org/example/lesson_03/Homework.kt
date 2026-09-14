package org.example.lesson_03



// Название мероприятия
val name: String = "Monster Hackaton"

// Дата проведения
val date: String = "10 ноября 2025"

// Место проведения
val place: String = "Minsk"

// Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.
private val budget: String = "подробная информация с перечислением поставщиков и сумм для внутреннего пользования"

// Количество участников
var participants_count: Int = 0

// Длительность хакатона
val length_in_min: Int = 90

// Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.
private val supplier: List<String> = listOf("supplier 1", "supplier 2")

// Текущее состояние хакатона (статус)
var is_active: Boolean = true

// Список спонсоров
val sponsors: List<String> = listOf("sponsor 1", "sponsor 2")

// Бюджет мероприятия
val budget_in_dollars: Int = 10000

// Текущий уровень доступа к интернету
var level_of_internet: String = "low"

// Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами поддержки.
private val resources: MutableList<String> = mutableListOf("resource 1", "resource 2")

// Количество команд
var count_of_teams: Int = 2

// Перечень задач
private var list_of_tasks: List<String> = listOf("task 1", "task 2")

// План эвакуации
val evacuation_plan: String = "plan"

// Список доступного оборудования (всё, что выделено для использования на мероприятии)
val all_equipment: List<String> = listOf("equipment 1", "equipment 2")

// Список свободного оборудования (всё, что можно взять прямо сейчас и что не занято другими участниками)
val available_equipment: MutableList<String> = mutableListOf("equipment 1")

// График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
lateinit var meal_schedule: String

// План мероприятий на случай сбоев
val plan_b: String = "plan B"

// Список экспертов и жюри
val experts: List<String> = listOf("expert 1", "expert 2")

// Политика конфиденциальности
const val policy_of_event = "Policy of event"

// Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.
val list_of_feedbacks: MutableList<String> = mutableListOf()

// Текущая температура в помещении
var temperature_in_celsius: Double = 25.4

// Данные мониторинга и анализ производительности сетевого оборудования и интернет-соединения для целей отладки своих приложений командами
private var list_of_apps_logs: List<String> = listOf("app 1", "app 2")

// Скорости интернета (понижающий коэффициент, например 0.5)
var internet_speed_factor: Double = 0.5

// Уровень освещения
var level_of_light: String = "medium"

// Лог событий мероприятия
val list_of_event_logs: MutableList<String> = mutableListOf()

// Возможность получения медицинской помощи прямо на мероприятии (да/нет)
val is_medical_help_available: Boolean = true

// Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.
private var list_of_safety_plans: List<String> = listOf("plan 1", "plan 2")

// Регистрационный номер мероприятия
const val registered_event_number: String = "hfdjka3389djj3"

// Максимально допустимый уровень шума в помещении хакатона.
const val max_noise_in_dbc: Int = 125

// Индикатор превышения уровня шума в помещениях (превышен или не превышен в данный момент)
var is_noise_exceeded: Boolean = false

// План взаимодействия с прессой
private val press_plan: String = "press plan"

// Детальная публичная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона автоматизированных проверок.
var team_projects_public: String = "teams plan"

// Статус получения всех необходимых разрешений для проведения мероприятия
var is_permission by Delegates.notNull<Boolean>()

// Индикатор доступности специализированного оборудования в данный момент
var is_equipment_available: Boolean = true

// Список партнеров мероприятия
val list_of_event_partners: MutableList<String> = mutableListOf("partner 1", "partner 2")

// Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.
lateinit var hackathon_report: String

// Внутренние правила распределения призов
private val prize_plan: String = "prize plan"

// Список разыгрываемых призов
var list_of_event_prizes: List<String> = listOf("prize 1", "prize 2")

// Контактная информация экстренных служб, медицинского персонала и других важных служб, для внутреннего пользования.
private val list_of_extra: List<String> = listOf("info 1", "info 2")

// Особые условия для участников с ограниченными возможностями
val accessibility_conditions: String = "..."

// Общее настроение участников (определяется опросами)
lateinit var participants_mood: String

// Подробный план хакатона
lateinit var detailed_plan: String

// Имя знаменитого специального гостя
lateinit var special_guest: String

// Максимальное количество людей, которое может вместить место проведения.
const val max_of_participants = 1000

// Количество часов, отведенное каждой команде для работы над проектом.
const val max_of_time_for_work_in_min = 100