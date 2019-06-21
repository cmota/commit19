package domain.model

import data.entities.SpeakerEntity

data class Speaker (val speaker: String,
                    val company: String,
                    val title: String,
                    val bio: String,
                    val talkTitle: String,
                    val talkDescription: String,
                    val talkSchedule: String,
                    val img: String)

fun SpeakerEntity.toSpeaker() = Speaker(
    speaker = speaker,
    company = company,
    title = title,
    bio = bio,
    talkTitle = talkTitle,
    talkDescription =  talkDescription,
    talkSchedule = talkSchedule,
    img = img
)