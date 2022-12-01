package data

sealed class Attachment(
    val type: String,
    var id: Int = -1,
    val pieceOfMemoryError: Any? = null
) {
    class AttachPhoto(
        val album_id: Int = 1,
        val owner_id: Int = 1,
        val user_id: Int = 1
    ) : Attachment(type = "Photo")

    class AttachVideo(
        val album_id: Int = 1,
        val owner_id: Int = 1,
        val user_id: Int = 1
    ) : Attachment(type = "Video")

    class AttachAudio(
        val album_id: Int = 1,
        val owner_id: Int = 1,
        val user_id: Int = 1,
        val title: String? = null,
        val autor: String? = null
    ) : Attachment(type = "Audio")

    class AttachLink(
        val url: String = "url",
        val autor: String? = null
    ) : Attachment(type = "Link")

    class AttachPoll(
        val question: String = "?",
        val anonimus: Boolean = false,
        val votes: Int = 0,
        val answers: Array<Answer> = emptyArray()
    ) : Attachment(type = "Poll")
}

class Answer(
    val id: Int =0,
    val text: String ="yes",
    val isItRight: Boolean = true
)
