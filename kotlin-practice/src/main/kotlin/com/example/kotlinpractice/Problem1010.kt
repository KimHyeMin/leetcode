package com.example.kotlinpractice

import java.util.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class Problem1010

//    fun main(args: Array<String>) {
//        val input = Scanner(System.`in`)
//        val a = input.nextInt();
//        val b = input.nextInt();
//        println("${a+b}\n${a-b}\n${a*b}\n${a/b}\n${a%b}")
//  }

//    fun main(args: Array<String>) {
//        val input = Scanner(System.`in`)
//        when (input.nextInt()) {
//            in 90..100 -> println("A")
//            in 80..89 -> println("B")
//            in 70..79 -> println("C")
//            in 60..69 -> println("D")
//            else -> println("F")
//        }
//    }

//fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    val n:Int = input.nextInt()
//
//    for (i in 1 until  10) {
//        println("$n * $i = ${n*i}")
//    }
//}

//fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    val a:Int = input.nextInt()
//    val b:Int = input.nextInt()
//    val c:Int = input.nextInt()
//    println("${(a+b)%c}")
//    println("${((a%c) + (b%c))%c}")
//    println("${(a*b)%c}")
//    println("${((a%c) * (b%c))%c}")
//}
//fun main(args: Array<String>) {
//    println("\\    /\\")
//    println(" )  ( ')")
//    println("(  /  )")
//    println(" \\(__)|")
//}
fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    val n:Int = input.nextInt()
//    var line=""
//    for (i in 1 until n+1) {
//        line += "*"
//        println(line)
//    }

//    val input = Scanner(System.`in`)
//    val n:Int = input.nextInt()
//    val array = arrayOfNulls<Int>(n);
//    var max:Int = -1;
//    for (i in 0 until n) {
//        val num:Int = input.nextInt()
//        array[i] = num;
//        max = max(max, num);
//    }
//
//    var sum:Double = 0.0;
//    for (item in array) {
//        val a = (item?.toDouble()?.div(max))?.times(100)
//        sum += a!!;
//    }
//    println(sum/n)


    val input = Scanner(System.`in`)
    val tc:Int = input.nextInt()
    for (t in 0 until tc) {
        val N:Int = input.nextInt()
        val array = arrayOfNulls<Int>(N);
        var sum:Double = 0.0;
        var avg:Double;
        for (i in 0 until N) {
            val score:Int = input.nextInt()
            array[i] = score;
            sum += score;
        }
        avg = sum/N;
        var answer = 0;
        for (item in array) {
            if (item!! > avg) {
                answer += 1;
            }
        }
        var answer2 = answer.toDouble()/N * 100
        var answer3 =  (answer2*1000).roundToInt().toDouble() / 1000
        println("${"%.3f".format(answer3)}%")
    }
}