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
    private val baseUrl = "89.169.182.244:8080"

    suspend fun post(
        path: String,
        params: Map<String, String> = emptyMap(),
        requestBody: Any,
    ): HttpResponse {
        return httpClient.request {
            url {
                method = HttpMethod.Post
                protocol = URLProtocol.HTTP
                host = baseUrl
                encodedPath = path
                params.forEach { (key, value) ->
                    parameters.append(key, value)
                }
            }
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }
    }

    suspend fun patch(
        path: String,
        params: Map<String, String> = emptyMap(),
        requestBody: Any,
    ): HttpResponse {
        return httpClient.request {
            url {
                method = HttpMethod.Patch
                protocol = URLProtocol.HTTP
                host = baseUrl
                encodedPath = path
                params.forEach { (key, value) ->
                    parameters.append(key, value)
                }
            }
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }
    }

    suspend fun delete(
        path: String,
        params: Map<String, String> = emptyMap(),
    ): HttpResponse {
        return httpClient.request {
            url {
                method = HttpMethod.Delete
                protocol = URLProtocol.HTTP
                host = baseUrl
                encodedPath = path
                params.forEach { (key, value) ->
                    parameters.append(key, value)
                }
            }
        }
    }

    suspend fun get(
        path: String,
        params: Map<String, String> = emptyMap(),
    ): HttpResponse {
        return httpClient.request {
            url {
                method = HttpMethod.Get
                protocol = URLProtocol.HTTP
                host = baseUrl
                encodedPath = path
                params.forEach { (key, value) ->
                    parameters.append(key, value)
                }
            }
        }
    }
}