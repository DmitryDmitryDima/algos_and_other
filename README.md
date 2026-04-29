
# Направления подготовки

Структуры данных (имплементации с нуля), классические алгоритмы, упражнения на паттерны



пишу мысли прямо в коде, делаю шпаргалки в anki и тут


# Структуры данных

## Tree

Изучаю обход в глубину (рекурсия, стэк) и в ширину (очередь).

Deque, Queue - интерфейсы, ArrayDeque


## Stack


Заполнение стэка через
обход коллекции по сути дает нам доступ к зеркальному отражению это коллекции

То же самое и с конкретными элементам



# Паттерны решения алгоритмических задач
- Prefix Sum
- Two Pointers
- Sliding Window
- Fast and Slow pointers
- Linked List in-place reversal
- Monotonic Stack
- Top K Elements
- Overlapping intervals
- Modified binary search
- Binary tree traversal
- DFS (tree, graph)
- BFS (tree, graph)
- Matrix traversal
- Backtracking
- Dynamic Programming



## Prefix Sum



Формула вычисление суммы подмассива - sum = sub[right]-sub[left]

SubarraySumEqualsK - используется кеширование prefix суммы через hashmap


## Two pointers

когда два указателя идут с разных концов, проверь, не будет ли логичным условие while (left<right),
чтобы избежать двойной работы

В задаче с обнаружением цикла к связанном списке используется техника,
где быстрый указатель двигается в два раза быстрее, чем медленный (техника флойда)

В задаче с объединением двух отсортированных массивов используется 
параллельный проход указателей по двум массивам

## Sliding window


В задачке на поиск дубликатов используется интересная техника с окном фиксированного размера и hashset


## Fast and slow pointers


## Linked List in place reversal


## Monotonic Stack


## Top K Elements

## Overlapping intervals


## Modified binary search

## Binary tree traversal



## DFS (tree, graph)



## BFS (tree, graph)


## Matrix traversal
## Backtracking
## Dynamic Programming


