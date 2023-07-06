package com.example.coroutineflow.lessons.lesson1

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

// fun main() = runBlocking { - создает корутину
 suspend fun main(){
    val numbers = listOf(3, 4, 8, 16, 5, 7, 11, 32, 41, 28, 43, 47, 84, 116, 53, 59, 61).asFlow()
    numbers.filter { it.isPrime() }
        .filter { it > 20 }
        .map {
            println("Map")
            "Number: $it"
        }
            //терминальный оператор у Flow делать то же самое что forEach -для каждого элемента из
        // потока будет вызван определенный метод
        .collect { println(it)}
}

suspend fun Int.isPrime(): Boolean {
    if (this <= 1) return false
    for (i in 2..this / 2) {
        //имитруем загрузку данных
        delay(50)
        if (this % i == 0) return false
    }
    return true
}