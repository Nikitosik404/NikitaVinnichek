Homework #2 

Тесты находятся в дирректории NikitaVinnichek\src\test\java\appiumHW3

*1. Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?

Готово. Теперь для каждого набора тестов сущетсвует только один! объект драйвера.
Доступ к экземпляру драйвера есть у всех тестов. Легко управлять созданием и изменением экземпляра драйвера.

*2. Suggest improvements for .properties reading. What are the purposes?

Возможно, было бы лучше не наследоваться от TestProperties.class, а делегировать объект этого класса, как поле
 в классе Driver.class, чтобы скрыть ненужные методы и переменные. Ну и по смылу это было бы логичнее.


*3. Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test

- Добавлены проверки некоторых заголовков полей.
- Добавлена ​​проверка некоторых названия экрана.
- Добавлены проверки некоторых полей.

*4. Optional: Add keyboard presence check in “native” test.

- Добавлена проверка присутствия клавиатуры в «native» test.

*5. Which checks would you place in the “web” test?

- Добавлена проверка отображается ли заголовок логотипа.
- Добавлена проверка на наличие всех панелей домашних панелей.