package ru.pyroman.masik.data.common.network

import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.encodedPath

class MasikHttpClient(
    private val httpClient: HttpClient,
) {
    private val baseUrl = "http://89.169.182.244:8080"

    suspend fun post(path: String, requestBody: Any): HttpResponse {
        return httpClient.request {
            url {
                method = HttpMethod.Post
                protocol = URLProtocol.HTTP
                host = baseUrl
                encodedPath = path
            }
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }
    }

    suspend fun get(path: String): HttpResponse {
        return httpClient.request {
            url {
                method = HttpMethod.Get
                protocol = URLProtocol.HTTP
                host = baseUrl
                encodedPath = path
            }
        }
    }
}