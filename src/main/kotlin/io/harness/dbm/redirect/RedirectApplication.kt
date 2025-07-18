package io.harness.dbm.redirect

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication(scanBasePackages = ["io.harness.dbm.redirect", "io.harness.dbm.redirect.config"])
class RedirectApplication

fun main(args: Array<String>) {
    println("🚀 [App] Starting RedirectApplication...")
	runApplication<RedirectApplication>(*args)
}
