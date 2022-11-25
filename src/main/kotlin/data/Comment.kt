package data
import java.time.LocalDateTime

data class Comment(
    val idComment: Int = -1,
    val text: String? = null,
    val ownerId: Int = 1,
    val authorName: String = "Mary",
    val data: LocalDateTime = LocalDateTime.now(),
    var isRemoved: Boolean = false
) {
    override fun toString(): String = ("$authorName :  $text")

}

