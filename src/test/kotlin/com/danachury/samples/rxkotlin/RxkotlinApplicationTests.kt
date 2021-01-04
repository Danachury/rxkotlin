package com.danachury.samples.rxkotlin

import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RxkotlinApplicationTests(@Autowired val app: RxkotlinApplication) {

    @Test
    fun contextLoads() {
        assertThat(app).isNotNull
    }

    @Test
    internal fun shouldListToObservable() {
        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        val disposable = list.toObservable()
            .filter { it.length >= 5 }
            .map { it.plus(" length is >= 5") }
            .subscribeBy(
                onNext = { println(it) },
                onError = { it.printStackTrace() },
                onComplete = { println("Done!") }
            )
        assertThat(disposable.isDisposed).isTrue
    }
}
