package io.harness.dbm.redirect

import io.split.client.SplitClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RedirectController(
    private val splitClient: SplitClient
    // private val otherClient : String
) {
    @GetMapping("/redirect")
    fun getRedirectUrl(): Map<String, String> {
        // return mapOf("url" to otherClient)
        val treatment = splitClient.getTreatment("dmartin", "new_url_enabled")

        val url = if (treatment == "on") {
            "https://new.example.com"
        } else {
            "https://old.example.com"
        }

        return mapOf("url" to url)
    }
}
