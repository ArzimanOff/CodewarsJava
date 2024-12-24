package com.other_tasks.tinkoff_task_2

/*
На планете началась вечная зима, теперь выпавший снег совсем перестал таять. Каждый день выпадает несколько миллиметров снега, после чего метеостанция замеряет глубину снега в одном месте и записывает её на отдельный лист в журнал. Достоверно известно, что перед первым днем замеров снега не было вовсе, а далее на протяжении всего периода замеров за день выпадало положительное целое число миллиметров снега.

Вы получили в распоряжение журнал, чтобы проверить, не допустили ли ошибку на метеостанции при заполнении по случайности или из злого умысла. Но перед его изучением решили выпить чашечку кофе (вечная зима на дворе!) и случайно разлили его на журнал. В результате чего на некоторых его листах оказались неразличимые кляксы.

Теперь вы просто хотите найти количество снега в миллиметрах, которое могло выпасть в каждый день замера или обличить метеостанцию в подтасовке, если по испорченному журналу можно достоверно сказать, что данные фальсифицированы.

Среди всех вариантов ответа вас устроит любой, главное, чтобы он согласовывался с сохранившимися данными из испорченного журнала.

Формат входных данных

В первой строке входных данных содержится число n (1≤n≤10^5) — количество дней, на протяжении которых проводились замеры.

Во второй строке содержатся n целых чисел ai, разделенных пробелом. ai равно −1, если соответствующий лист нечитаемый, а иначе это число, записанное на i-м листе, в этом случае ai не превосходит 10^9
Формат выходных данных
Если в журнале была допущена ошибка, выведите «NO» (без кавычек). В противном случае, в первой строке выведите «YES», а во второй строке выведите n натуральных чисел от 1 до 10^9, i-е из которых равняется количеству выпавшего снега в i-й день.

Примеры данных
Пример 1
Ввод:
5
1 3 -1 10 -1
Вывод:
YES
1 2 3 4 5
Пример 2
Ввод:
3
10 -1 4
Вывод:
NO
 */

fun main() {
    val input = readln().split(",")
    val ans = mutableListOf<Int>()
    for (s in input) {
        if (s.contains('-')) {
            val (a, b) = s.split("-").map { it.toInt() }
            for (i in a..b) {
                ans.add(i)
            }
        } else {
            ans.add(s.toInt())
        }
    }
    println(ans.joinToString(separator = " "))
}