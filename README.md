
## Направления подготовки

Структуры данных (имплементации с нуля), классические алгоритмы, упражнения на паттерны


## Паттерны решения алгоритмических задач
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

Думаю, что разумно будет пройтись по паттернам, при этом параллельно повторяя те структуры данных, которые используются в той или иной задаче.
Параллельно нужно изучать классические алгоритмы.

Ниже буду конспектировать некотоыре моменты, работать буду с новой директорией - exercises2



## Prefix Sum

### RangeSumQueryImmutable

Классическая задача на сумму подмассивов.
Основной сложностью было вспомнить,
как вычислять подмассивы.
Загвоздка была в том, что мы вычитаем
prefixSum[right]-prefix[left-1], так как значение left не входит в то,
что нужно убрать из диапазона для ответа.

Сам prefixSum вычислялся с использованием массива, равного по размеру входящему массиву. В таком случае nums[0] = prefixSum[0], а расчет начинается с индекса 1.
