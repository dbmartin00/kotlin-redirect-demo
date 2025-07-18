package io.harness.dbm.redirect.config

import io.split.client.SplitClient
import io.split.client.SplitFactoryBuilder
import io.split.client.SplitClientConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SplitConfig {

    @Bean
    fun splitClient(): SplitClient {
        println("[SplitConfig] Attempting to create SplitClient...")

        return try {
            val sdkKey = System.getenv("SPLIT_SDK_KEY") ?: "localhost"
            println("[SplitConfig] Using SDK key: $sdkKey")

            val config = SplitClientConfig.builder()
                .setBlockUntilReadyTimeout(10000)
                .build()

            val factory = SplitFactoryBuilder.build(sdkKey, config)
            val client = factory.client()

            println("[SplitConfig] Waiting for Split client to be ready...")
            client.blockUntilReady()
            println("[SplitConfig] SplitClient is ready.")

            client
        } catch (e: Exception) {
            println("[SplitConfig] Failed to create SplitClient: ${e.message}")
            throw e
        }
    }
}
