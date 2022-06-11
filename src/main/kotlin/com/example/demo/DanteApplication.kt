package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DanteApplication

fun main(args: Array<String>) {
	val hello = Hello( "hello")
	print(hello.data)

	runApplication<DanteApplication>(*args)
}
