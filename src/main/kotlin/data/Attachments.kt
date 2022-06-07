package data

sealed class Attachments(
    val type: String,
    var id: Int = -1,
    val pieceOfMemoryError: Any? = null
) {
    class AttachPhoto(
        val photo: Photo = Photo()
    ) : Attachments(type = "Photo")

    class AttachVideo(
        val video: Video = Video()
    ) : Attachments(type = "Video")

    class AttachAudio(
        val link: Audio =Audio(),
    ) : Attachments(type = "Audio")

    class AttachLink(
        val link: Link =Link(),
    ) : Attachments(type = "Link")

    class AttachPoll(
        val poll: Poll = Poll()
    ) : Attachments(type = "Poll")
}

class Link(
    val url: String = "url",
    val autor: String? = null
)

class Poll(
    val question: String = "?",
    val anonimus: Boolean = false,
    val votes: Int = 0,
    val answers: Array<Answer> = emptyArray()
)

class Video(
    val albumId: Int = 1,
    val ownerId: Int = 1,
    val userId: Int = 1
)

class Audio(
    val albumId: Int = 1,
    val ownerId: Int = 1,
    val userId: Int = 1,
    val title: String? = null,
    val autor: String? = null
)

class Answer(
    val id: Int = 0,
    val text: String = "yes",
    val isItRight: Boolean = true
)

class Photo(
    val albumId: Int = 1,
    val ownerId: Int = 1,
    val userId: Int = 1
)