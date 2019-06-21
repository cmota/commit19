package data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpeakerEntity (val speaker: String,
                          val company: String,
                          val title: String,
                          val bio: String,
                          @SerialName("talk_title") val talkTitle: String,
                          @SerialName("talk_description") val talkDescription: String,
                          @SerialName("talk_time") val talkSchedule: String,
                          val img: String)