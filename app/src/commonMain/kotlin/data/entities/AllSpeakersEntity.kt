package data.entities

import kotlinx.serialization.Serializable

@Serializable
data class AllSpeakersEntity(val speakers: List<SpeakerEntity>)