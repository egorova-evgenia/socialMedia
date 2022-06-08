package data
import java.time.LocalDateTime

data class OneComment(
    val idComment: Int =-1,
    val text: String?=null,
    val ownerId: Int =1,
    val authorName: String = "Mary",
    val data: LocalDateTime = LocalDateTime.now()
)
