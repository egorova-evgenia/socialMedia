package data

import services.CommentNotFoundException
import services.TextNotFoundException
import java.time.LocalDateTime

abstract class TextObject(
    open val id: Int = -1,
    open val ownerId: Int = 1, // Идентификатор владельца стены
    open val authorName: String = "Mary",
    open val content: String = "Wright here",    // Текст записи
    open val data: LocalDateTime = LocalDateTime.now(),
    open var isRemouved: Boolean = false,
    open var comments: Array<Comment> = emptyArray()

) {
    abstract fun copyId(id: Int): TextObject
    abstract fun copyContent(newText: String): TextObject
    abstract fun whatIsIt(): String

    private fun nextCommentId() = comments.size

    fun addNewComment(comment: Comment): Boolean {
        if (comment.text != null) {
            comments += comment.copy(idComment = nextCommentId())
            return true
        }
        throw TextNotFoundException("Текст комментария пуст") //если текст пустой
    }

    fun removeComments(idComments: Int): Boolean {
        comments.forEachIndexed() { index, comment ->
            if (idComments > 0 || idComments > comments.size) {
                comments[index].isRemoved = true
                return true
            }
        }
        throw CommentNotFoundException("Нет коментария $idComments")
    }

    fun howMuchComments(): Int = comments.size

    fun removeTextObject(): Boolean {
        if (!isRemouved) {
            isRemouved = true // можно "удалять" только неудаленные объекты, он стал удаленным
            return true
        }
        return false
    }

    fun comeBackTextObject(): Boolean {
        if (isRemouved) {
            isRemouved = false // можно вернуть только удаленные объекты
            return true
        }
        return false
    }

    fun shortToString2(): String {
        return ("  $authorName  $content  $id")
    }

}
