package net.devonmobile.kmmovies

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TestApi {
    private val apiUrl = "https://api.coindesk.com/v1/bpi/currentprice.json"

    fun getResponse(
        success: (String) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(AppDispatcher) {
            try {
                val url = apiUrl
                val json = HttpClient().get(url)
                success(json.bodyAsText())
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }
}