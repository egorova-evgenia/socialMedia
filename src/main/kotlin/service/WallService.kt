package service

import data.OneComment
import data.Post

object WallService : NoteService<Post> {

    override val txtObjList: MutableList<Post> = mutableListOf()
//    ListOf() as MutableList<Post>


//    private fun getNextId(): Int {
//        return posts.size
//    }

//    fun add(post: Post): Post {
////        post
//        posts += post.copy(id = getNextId())
//        return posts.last()
//    }

    fun update(postNew: Post): Boolean {
        txtObjList.forEachIndexed { index, post ->
            if (postNew.id == post.id) {
                txtObjList[index] = postNew.copy(author = post.author, data = post.data)
                return true
            }
        }
        return false
    }

//    fun removeById(id: Int): Boolean {
//        posts.forEachIndexed { index, post ->
//            if (id == post.id) {
//                posts[index] = posts[index].copy(id = -id)
//                return true
//            }
//        }
//        return false
//    }

    fun shortToString(): Boolean {
        txtObjList.forEachIndexed { index, post ->
            if (txtObjList[index].id >= 0) {
                println(txtObjList[index].author + "  " + txtObjList[index].text + "  " + txtObjList[index].id)
            }

        }
        return false
    }

//    fun shortToString2(): Boolean {
//        txtObjList.forEachIndexed { index, post ->
//            println(txtObjList[index].author + "  " + txtObjList[index].text + "  " + txtObjList[index].id + "  " + txtObjList[index].attachment + txtObjList[index].comments)
//        }
//        return false
//    }


//    fun createComment(id: Int, comment: OneComment): Boolean {
//        posts.forEachIndexed { index, post ->
//            if (id == post.id) {
//                return posts[index].addNewComment(comment)
//            }
//        }
//        throw PostNotFoundException("пост с идентификатором $id не найден")
//    }

    //    fun howMuchComments(id: Int): Int {
//        posts.forEachIndexed { index, post ->
//            if (id == post.id) {
//                return posts[index].comments.size
//            }
//        }
//        return 0
//    }


}