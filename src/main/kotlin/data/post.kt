package data
import service.TextNotFoundException
import java.time.LocalDateTime

data class Post (
    val id: Int=-1,
    val from_id: Int =1, // Идентификатор автора записи
    val ownerId: Int =1, // Идентификатор владельца стены
    val authorName: String = "Mary",
    val content: String = "Wright here",    // Текст записи
    val created: Int =1,  //кто опубликовал запись, для сообществ
    val data: LocalDateTime = LocalDateTime.now(),
    val reply_owner_id: Int =1,
    val reply_post_id: Int =1,
    val friends_only: Boolean=false,
    var comments: Array<OneComment> = emptyArray(),
//    val copyright: Object,
    val likes: Int = 0,
    val views: Int = 0,// ?
    val reposts: Int = 0,
    val post_type: String="post",
    val signed_id: Int = 0,
    val can_pin: Boolean = true,
    val can_delete: Boolean= true,
    val can_edit: Boolean= true,
    val is_pinned: Boolean= true,
    val marked_as_ads: Boolean= true,
    val is_favorite: Boolean= true,
    val donut: Donut=Donut(),
    val postponed_id: LocalDateTime =LocalDateTime.of(2035, 1, 1, 16, 0,0),
    var attachment: Array<Attachments> = emptyArray()
)
{
    private fun getNextAttachId(): Int {
        return attachment.size
    }
    fun addAttachment(addAtt: Attachments): Boolean {
    if (addAtt!=null) {
        addAtt.id=getNextAttachId()
        attachment += addAtt
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

    fun showAttachment() {
        attachment.forEach() {  attach ->
            when (attach) {
                // Здесь должны быть способы вывода на экран
                is Attachments.AttachPhoto -> "Фотка"
                is Attachments.AttachVideo -> "видео"
                is Attachments.AttachAudio -> "аудио"
                is Attachments.AttachLink -> "ссылка"
                is Attachments.AttachPoll -> "Опрос"
            }
        }
    }
}