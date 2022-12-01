package data

import java.time.LocalDateTime

data class Post(
    override val id: Int = -1,
    override val authorName: String = "Mary",
    override val content: String = "Wright here",    // Текст записи
    override val data: LocalDateTime = LocalDateTime.now(),
    override var isRemouved: Boolean = false,
    override var comments: Array<Comment> = emptyArray(),
    val likes: Int = 0,
    var attachment: Array<Attachment> = emptyArray()
) : TextObject() {
    override fun copyId(id: Int): TextObject = copy(id = id)

    override fun copyContent(newText: String): TextObject = copy(content = newText)

    override fun whatIsIt(): String = "post"

    fun addAttachment(addAtt: Attachment) {
        addAtt.id = (attachment.lastOrNull()?.id?.plus(1) ?: 0)
        attachment += addAtt
    }

    fun showAttachment() {
        attachment.forEach() { attach ->
            when (attach) {
                // Здесь должны быть способы вывода на экран
                is Attachment.AttachPhoto -> "Фотка"
                is Attachment.AttachVideo -> "видео"
                is Attachment.AttachAudio -> "аудио"
                is Attachment.AttachLink -> "ссылка"
                is Attachment.AttachPoll -> "Опрос"
            }
        }
    }

}
