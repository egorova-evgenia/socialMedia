package data

import kotlin.String as String

interface Attachments {
    val type: String
    var id: Int
//    val pieceOfMemoryError: Any?
}

data class VideoAttachment(
    override val type: String ="video",
    override var id: Int=-1,
    val video: Video=Video()) : Attachments

data class AudioAttachment(
    override val type: String ="audio",
    override var id: Int=-1,
    val audio: Audio=Audio()) : Attachments

data class LinkAttachment(
    override val type: String ="link",
    override var id: Int=-1,
    val link: Link=Link()) : Attachments

data class PollAttachment(
    override val type: String ="poll",
    override var id: Int=-1,
    val poll: Poll=Poll()) : Attachments

data class PhotoAttachment(
    override val type: String ="audio",
    override var id: Int=-1,
    val photo: Photo=Photo()) : Attachments

class Link(
    val url: String = "url",
    val autor: String? = null
)
class Video (
    val albumId: Int = 1,
    val ownerId: Int = 1,
    val userId: Int = 1
)
class Audio (
    val albumId: Int = 1,
    val ownerId: Int = 1,
    val userId: Int = 1,
    val title: String? = null,
    val autor: String? = null
)
class Poll(
    val question: String = "?",
    val anonimus: Boolean = false,
    val votes: Int = 0,
    val answers: Array<Answer> = emptyArray()
)
class Answer(
    val id: Int =0,
    val text: String ="yes",
    val isItRight: Boolean = true
)
class Photo(
    val album_id: Int = 1,
    val owner_id: Int = 1,
    val user_id: Int = 1
)

