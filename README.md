# Запуск проекта
Для запуска проекта выполнить
1) gradle clean build
2) gradle dockerClean
3) Запустить приложение в докере командой docker run -d -p 70:8080 alfa-test,
приложение будет запущено на 70 порту, поэтому достучаться можно по следующему адрессу:
http://localhost:70/api/v1/currency-rates/gif?currencyName=EUR.
Контроллер имеет единственный endpoint по адрессу **/api/v1/currency-rates/gif** доступный через GET с обязательным
не пустым параметром запроса currencyName.
Настройки вынесены в application.yml, там можно задать код валюты относительно которой будет считаться курс, а также
ключи доступа к сервисам gif и exchange и их url.




