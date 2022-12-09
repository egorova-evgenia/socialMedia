package services

import data.Comment
import data.TextObject

interface TextObjectService<T : TextObject> {
    val txtObjList: MutableList<T>

    fun add(txtObj: T): T {
        txtObjList += txtObj.copyId(txtObjList.lastOrNull()?.id?.plus(1) ?: 0) as T
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

    fun comeBackById(id: Int): Boolean {
        txtObjList.forEachIndexed { index, post ->
            if (id == post.id) {
                txtObjList[index].comeBackTextObject()
                return true
            }
        }
        return false
    }

    fun updateById(id: Int, newContent: String): Boolean {
        txtObjList.forEachIndexed { index, obj ->
            if (id == obj.id) {
                obj.copyContent(newContent)
                return true
            }
        }

        throw PostNotFoundException("запись с идентификатором $id не найдена")
    }

    fun createComment(id: Int, comment: Comment): Boolean {
        txtObjList.forEachIndexed { index, obj ->
            if ((id == obj.id) && !obj.isRemouved) {
                txtObjList[index].addNewComment(comment)
                return true
            }
        }
        throw PostNotFoundException("запись с идентификатором $id не найдена")
    }

    fun howMuchComments(id: Int): Int {
        txtObjList.forEachIndexed { index, obj ->
            if ((id == obj.id) && !obj.isRemouved) {
                return txtObjList[index].howMuchComments()
            }
        }
        throw PostNotFoundException("запись с идентификатором $id не найдена")
    }

    fun getTextObjectById(id: Int): T {
        txtObjList.forEach { obj ->
            if ((id == obj.id) && !obj.isRemouved) {
                return obj
            }
        }
        throw PostNotFoundException("запись с идентификатором $id не найдена")
    }

    fun getCommentsById(id: Int): Array<Comment> {
        txtObjList.forEach { obj ->
            if ((id == obj.id) && !obj.isRemouved) {
                return obj.comments
            }
        }
        throw PostNotFoundException("запись с идентификатором $id не найдена")
    }

    fun show() {
        txtObjList.forEach { obj ->
            if (!obj.isRemouved) {
                println(obj.shortToString2())
            }
        }
    }


}
