package com.ikuzmin.common.rest.clients

import org.springframework.web.client.RestTemplate

abstract class AbstractRestClient {

    var url: String? = null

    var restTemplate: RestTemplate? = null

    abstract fun setServiceUrls()
}