package data

import data.entities.AllSpeakersEntity
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://gist.githubusercontent.com/cmota/"
private const val URL = "9b911f771f854137e63b73f582bd1e83/raw/149d092dac4d21a4eec84649bcfbf7022826f657/commit-speakers.json"

@Suppress("EXPERIMENTAL_API_USAGE")
class CommitAPI(engine: HttpClientEngine) {

    private val client = HttpClient(engine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun fetchSpeakers(): AllSpeakersEntity {
        val response = client.get<HttpResponse> {
            url ("$BASE_URL$URL")
        }

        val jsonBody = response.readText()
        return Json.parse(AllSpeakersEntity.serializer(), jsonBody)
    }
}