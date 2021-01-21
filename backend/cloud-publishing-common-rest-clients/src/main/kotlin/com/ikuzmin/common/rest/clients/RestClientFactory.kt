package com.ikuzmin.common.rest.clients

import org.springframework.web.client.RestTemplate
import java.util.function.Supplier

class RestClientFactory(private val restTemplate: RestTemplate) {

    fun <T : AbstractRestClient> createRestClient(
        constructor: Supplier<T>, url: String
    ): T {
        val restClient = constructor.get()
        restClient.restTemplate = restTemplate
        restClient.url = url
        restClient.setServiceUrls()
        return restClient
    }

}