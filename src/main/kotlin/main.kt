import data.Post
import data.Attachments
import data.Note
import data.OneComment
import org.junit.Assert
import service.NoteWork
import service.WallService
import service.*

fun main() {
//    Создадим несколько постов
    val post1 = Post(
        author = "Mary", text = "первая запись"
    )

    val post2 = Post(author = "Mary", text = "вторая запись")
    val post3 = Post(
        author = "Sarah",
        text = "третья запись"
    )

//    var link1 = Attachments.AttachLink(url = "Ссылка")
//    post2.addAttachment(link1)
////    println(post2)
//
//    WallService.add(post1)
//    WallService.add(post2)
//    WallService.add(post3)
//
//    WallService.shortToString()
//    val postNew3 = post3.copy(author = "Mary", id = 5, text = "edited")
////    WallService.add(postNew3)
////    WallService.shortToString()
//
//
//
////    WallService.removeById(1)
////    println(WallService.createComment(1, OneComment()))
//    println(WallService.createComment(2, OneComment(text = "text")))
//    println(WallService.createComment(2, OneComment(text = "text2")))
////    WallService.add(post1)
//    println(WallService.howMuchComments(2))
////    println(WallService.update(postNew3))
////    WallService.shortToString2()

    //        arrange
    val note1 = Note(text = "запись", author = "Kate")
    val note2 = Note(text = "txt2")
    val note3 = Note(text = "txt2")
    println(NoteWork.add(note1))
    println(NoteWork.add(note2))
    println(NoteWork.add(note3))
    println(NoteWork.shortToString())
    println(NoteWork.add(note1).id != note1.id)
//    Assert.assertTrue()


}
