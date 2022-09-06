package com.example.kotlinpractice

import java.util.*

class Problem1009

    fun main(args: Array<String>) {
        val input = Scanner(System.`in`)
        val tc = input.nextInt();
        for (i in 0 until  tc) {

            val a = input.nextInt();
            val b = input.nextInt();

            var result = a;
            for (j in 1 until b) {
                result = (result * a) % 10;
            }

            val aa = result.rem(10);

            if (aa == 0)
                println(10)
            else
                println(aa);
        }
    }