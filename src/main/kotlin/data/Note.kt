package data

import java.time.LocalDateTime

data class Note(
    override val id: Int = -1,
    override val authorName: String = "Mary",
    override val content: String = "Wright here",    // Текст записи
    override val data: LocalDateTime = LocalDateTime.now(),
    override var isRemouved: Boolean = false,
    override var comments: Array<Comment> = emptyArray()
) : TextObject() {

    override fun copyId(id: Int): TextObject = copy(id = id)

    override fun copyContent(newText: String): TextObject = copy(content = newText)

    override fun whatIsIt(): String {
        return "Note"
    }

}
