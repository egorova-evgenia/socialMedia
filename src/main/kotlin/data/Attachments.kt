package data

interface Attachments {
    val type: String
    var id: Int
    val pieceOfMemoryError: Any?
}

class AttachPhoto(
    override val type: String = "Photo",
    override val pieceOfMemoryError: Any?,
    override var id: Int = -1,
    val album_id: Int = 1,
    val owner_id: Int = 1,
    val user_id: Int = 1
) : Attachments

class AttachVideo(
    override var id: Int = -1,
    override val type: String = "Video",
    override val pieceOfMemoryError: Any?,

    val album_id: Int = 1,
    val owner_id: Int = 1,
    val user_id: Int = 1
) : Attachments

class AttachAudio(
    override var id: Int = -1,
    override val type: String = "Audio",
    override val pieceOfMemoryError: Any?,
    val album_id: Int = 1,
    val owner_id: Int = 1,
    val user_id: Int = 1,
    val title: String? = null,
    val autor: String? = null
) : Attachments

class AttachLink(
    override var id: Int = -1,
    override val type: String = "Link",
    override val pieceOfMemoryError: Any?,
    val url: String = "url",
    val autor: String? = null
) : Attachments

class AttachPoll(
    override var id: Int = -1,
    override val type: String = "Poll",
    override val pieceOfMemoryError: Any?,
    val question: String = "?",
    val anonimus: Boolean = false,
    val votes: Int = 0,
    val answers: Array<Answer> = emptyArray()
) : Attachments


class Answer(
    val id: Int = 0,
    val text: String = "yes",
    val isItRight: Boolean = true
)
