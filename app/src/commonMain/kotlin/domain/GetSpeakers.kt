package domain

import data.CommitAPI
import domain.model.Speaker
import domain.model.toSpeaker
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class GetSpeakers(private val commitAPI: CommitAPI) {

    suspend operator fun invoke(onSuccess: (List<Speaker>) -> Unit, onFailure: (Exception) -> Unit) {
        val result = commitAPI.fetchSpeakers()

        coroutineScope {
            launch(uiDispatcher) {
                try {

                    val speakers = mutableListOf<Speaker>()
                    for (speaker in result.speakers) {
                        speakers += speaker.toSpeaker()
                    }

                    onSuccess(speakers)
                } catch (e: Exception) {
                    onFailure(e)
                }
            }
        }
    }
}
