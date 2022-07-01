package service

import data.*

interface NoteService<T : TextObject> {
    //    val txtOBj: T
    val txtObjList: MutableList<T>
//    get() = mutableListOf()
//    get() = emptyList<T>() as MutableList<T>

    private fun getNextId(): Int {
        return txtObjList.size
    }

    fun add(txtObj: T): T {
        txtObj.id = getNextId()
        txtObjList += txtObj
        return txtObjList.last()
    }

    fun removeById(id: Int): Boolean {
        txtObjList.forEachIndexed { index, post ->
            if (id == post.id) {
                txtObjList[index].removeTextObject()
                return true
            }
        }
        return false
    }

    fun createComment(id: Int, comment: OneComment): Boolean {
        txtObjList.forEachIndexed { index, obj ->
            if (id == obj.id) {
                return txtObjList[index].addNewComment(comment)
            }
        }
        throw PostNotFoundException("пост с идентификатором $id не найден")
    }

    fun howMuchComments(id: Int): Int {
        txtObjList.forEachIndexed { index, obj ->
            if (id == obj.id) {
                return txtObjList[index].comments.size
            }
        }
        return 0
    }

}

object NoteWork : NoteService<Note> {
    override val txtObjList: MutableList<Note> = mutableListOf()

    fun shortToString(): Boolean {
        txtObjList.forEachIndexed { index, post ->
            if (txtObjList[index].id >= 0) {
                println(txtObjList[index].author + "  " + txtObjList[index].text + "  " + txtObjList[index].id)
            }

        }
        return false
    }
}
