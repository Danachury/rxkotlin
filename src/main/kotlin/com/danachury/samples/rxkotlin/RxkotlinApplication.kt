package com.danachury.samples.rxkotlin

import io.reactivex.rxjava3.kotlin.toObservable
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RxkotlinApplication

fun main(args: Array<String>) {
	runApplication<RxkotlinApplication>(*args)
}
