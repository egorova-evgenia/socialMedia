package services

import data.Attachment
import data.Post

object WallService : TextObjectService<Post> {

    override val txtObjList: MutableList<Post> = mutableListOf()

    fun attachById(id: Int, attachment: Attachment): Boolean {
        txtObjList.forEachIndexed { index, post ->
            if (id == post.id) {
                txtObjList[index].addAttachment(attachment)
                return true
            }
        }
        throw PostNotFoundException("пост с идентификатором $id не найден")
    }

}