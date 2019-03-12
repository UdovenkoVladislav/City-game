#City-game
Это программа, которая реализует игру в "города" между двумя потоками.
#Задачи:
1) Создать два потока, которые пользуются списком городов, который расположен в текстовом файле;
2) Сделать игроков (потоки) "честными в игре":
- потоки случайно выбирают города из списка;
3) Реализовать у одного игрока (потока) "забывание" некоторой части списка городов:
- поток выбирает города только из определенной части списка;
- "Забывание" задается в процентном соотношении;
4) Реализовать "умного" игрока, который выбирает города, заканчивающиеся на такую букву, на которую начинаются меньшинство городов.