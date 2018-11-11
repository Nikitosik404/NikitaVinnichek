Homework #1

*1. Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.

Тесты находятся в директории NikitaVinnichek\src\test\java\appiumHW\hw1. Все тесты работают исправно. В зависимости от метода setUp в классе SimpleTest
может выполняться один из тестов SimpleNativeTest(открывает приложение ContactManager и нажимает на кнопку "Add Contact")
 или simpleWebTest(открывает браузер Chrome и переходит на сайт http://iana.org). Все тесты проводились на реальном мобильном устройстве под 
 управлене Android, в связи с тем, что мой ноутбук не поддерживает аппаратное ускорение и запустить эммулятор Android-устройств не представлятся возможным.
 Во время попытки запуска эммулятора появляется следующее сообщение: 
 "Emulator: Warning: Quick Boot / Snapshots not supported on this machine. A CPU with EPT + UG features is currently needed. We will address this in a future release."
Однако, тесты были единожды (в связи с огринченным доступом) проверены на машине позволяющей сэмулировать Android-устройство. Тесты работают исправно.

*2. For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?

Тесты проеведены с использованием следюещих локаторов:

 By add_btn_by_xpath = By.xpath("//android.widget.Button[@content-desc='Add Contact']");
 By add_btn__by_class_name = By.className("android.widget.Button");

Локаторы отличаются только синтаксисом и стратегией поиска в Appium.

*3.	Modify existing tests to run on a real device. What should be changed?

Как написано выше, все тесты проводились в основном на реальном мобильном устройстве. Разница заключается лишь в разном указании 
"deviceName" в capabilities.

*4.	Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?

Для подключения реального устройство необходимо выполнить сначала несколько действий:
   - Включить режим разработчика и разрешить USB-отладкув настройках устройства
   - Подключить устройство к ПК с помощью драйверов adb для вашего устройства 
   - Запустить сервер Appium, устновить в настройках deviceName имя реального устройства (чтобы его узнатьнеобходимо выполнить команду "adb devices"
     как в конфигурации сеанса Appium, так и в
      capabilities.setCapability("deviceName","71BQFCSK222A2"); 
      в DriverSetup.class нашего проекта ("71BQFCSK222A2" - имя моего устройства).
   - Запустить тесты
   
Кроме подготовки и указании другого имени устройства между эмулятором и реальным устройством нет никакой разницы 
для запуска appium сессии и выполнения тестов.
*5.	What should be improved/changed in existing test code? Why, for what?

- Не стоит использовать абсолютные пути к нашему .apk-файлу - тестовый проект не будет работать на другом ПК, поскольку
 абсолютные пути будут отличаться на каждой машине.

- Thread.sleep - зло!!! Значительно увеличивает время выполнения больших проектов, блокирует наше приложение и останавливает 
поток, работает с бесполезным потреблением компьютерных ресурсов.

- Нужно избегать жестко заданных значений, чтобы обеспечить лучшую гибкость (для возможных будущих изменений) и поддержка кода не 
становилась ночным кошмаром.

- Хорошая практика - отделить тестовую логику от тестовых данных.

- Лучше было бы перенести класс инициализации драйвера из папки сценариев в другой проект за пределами области тестирования.

- Кодовые комментарии должны быть организованы, чтобы предоставить нашим коллегам дополнительную документацию по нашему проекту для улучшения
эффективность совместной работы.

- В теле тестов не содержится никаких проверок или тестировании чего либо, что делает наши тесты бессмысленными.