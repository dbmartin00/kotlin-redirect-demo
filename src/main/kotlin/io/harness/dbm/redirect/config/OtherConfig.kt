package io.harness.dbm.redirect.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OtherConfig {

    @Bean
    fun otherClient(): String {
        println("🔧 [OtherConfig] Creating OtherClient bean...")
        return "https://example.com/from-other-client"
    }
}
