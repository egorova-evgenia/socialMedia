package service

import data.OneComment
import data.Post

object WallService {
    private var posts = emptyArray<Post>()

    private fun getNextId(): Int {
        return posts.size
    }

    fun add(post: Post): Post {
//        post
        posts += post.copy(id = getNextId())
        return posts.last()
    }

    fun update(postNew: Post): Boolean {
        posts.forEachIndexed { index, post ->
            if (postNew.id == post.id) {
                posts[index] = postNew.copy(authorName=post.authorName, data =post.data )
                return true
            }
        }
        return false
    }

    fun removeById(id: Int): Boolean {
        posts.forEachIndexed { index, post ->
            if (id == post.id) {
                posts[index] = posts[index].copy(id = -id)
                return true
            }
        }
        return false
    }

    fun shortToString(): Boolean {
        posts.forEachIndexed { index, post ->
            if (posts[index].id >= 0) {
                println(posts[index].authorName + "  " + posts[index].content + "  " + posts[index].id)
            }

        }
        return false
    }

    fun shortToString2(): Boolean {
        posts.forEachIndexed { index, post ->
            println(posts[index].authorName + "  " + posts[index].content + "  " + posts[index].id+"  "+ posts[index].attachment)
        }
        return false
    }

    

    fun createComment(id: Int, comment: OneComment){
        posts.forEachIndexed { index, post ->
            if (id == post.id) {
                var comments: Array<OneComment> = emptyArray(),
                posts[index] = posts[index].copy(id = -id)
                return true
            }
        }
        return false
    }


}