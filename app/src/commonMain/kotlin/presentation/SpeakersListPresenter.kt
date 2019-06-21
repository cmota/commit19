package presentation

import domain.GetSpeakers
import domain.defaultDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SpeakersListPresenter(private val speakers: GetSpeakers,
                            private val coroutineContext: CoroutineContext = defaultDispatcher) {

    private var view: ISpeakersListView? = null
    private lateinit var scope: CoroutineScope

    fun attachView(view: ISpeakersListView) {
        this.view = view
        scope = CoroutineScope(coroutineContext)
        fetchSpeakersList()
    }

    private fun fetchSpeakersList() {
        scope.launch {
            speakers(
                onSuccess = { view?.onSpeakersListFetched(it) },
                onFailure = { view?.onSpeakersListFailed(it) }
            )
        }
    }
}