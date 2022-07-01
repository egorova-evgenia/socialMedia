package data

import service.CommentNotFoundException
import service.TextNotFoundException

abstract class TextObject(
    open var id: Int = -1,
    open var text: String = "  ",
    open val noteAutorId: Int = 1,
    open val author: String = "Mary",
    open var comments: Array<OneComment> = emptyArray()
) {
    abstract fun whatIsIt(): String
//}
//class textService<T : TextObject>(val txtObj: T) {

    fun updateTextObject(newText: String): Boolean {
        if (id > 0) {
            text = newText
            return true
        }
        return false
    }

    fun showTextObject() {
        println("Автор" + author)
        println("--------------------")
        println(text)
        println("--------------------")
    }

    fun removeTextObject(): Boolean {
        if (id > 0) {
            id = -id // можно "удалять" только неудаленные объекты
            return true
        }
        return false
    }

    fun comeBackTextObject(): Boolean {
        if (id < 0) {
            id = -id // можно вернуть только неудаленные объекты
            return true
        }
        return false
    }

    fun addNewComment(comment: OneComment): Boolean {
        if (comment.text != null) {
            val newId = comments.size
            comments += comment.copy(idComment = newId)
            return true
        }
        throw TextNotFoundException("Текст комментария пуст") //если текст пустой
    }

    fun removeComments(idComments: Int): Boolean {
        comments.forEachIndexed() { index, post ->
            if (idComments > 0 || idComments > comments.size) {
                comments[index].idComment = -comments[index].idComment
                return true
            }
        }
        throw CommentNotFoundException("Нет коментария $idComments") //если текст пустой
    }

    fun backComments(idComments: Int): Boolean {
        comments.forEachIndexed() { index, post ->
            if (idComments < 0) {
                comments[index].idComment = -comments[index].idComment
                return true
            }
        }
        return false
    }
}