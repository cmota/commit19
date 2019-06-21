package presentation

import domain.model.Speaker

interface ISpeakersListView {

    fun onSpeakersListFetched(speakers: List<Speaker>)

    fun onSpeakersListFailed(e: Exception)
}