import data.Comment
import data.Note
import services.NoteService

fun main() {
//    Создадим несколько постов
//    val post1 = Post(
//        author = "Mary", text = "первая запись"
//    )
//
//    val post2 = Post(author = "Mary", text = "вторая запись")
//    val post3 = Post(
//        author = "Sarah",
//        text = "третья запись"
//    )

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
    val note1 = Note(content = "запись", authorName = "Kate")
    val note2 = Note(content = "txt2")
    val note3 = Note(content = "txt2")
    val comm = Comment(text = "not null")
    NoteService.add(note1)
    NoteService.add(note2)
    NoteService.add(note3)
    NoteService.createComment(1, comm)
    NoteService.createComment(1, Comment(text = "like"))
    NoteService.removeById(2)
    NoteService.show()
    NoteService.comeBackById(2)
    NoteService.show()
    println(NoteService.getCommentsById(1).toString())

//    println(NoteWork.shortToString())
//    println(NoteWork.add(note1).id != note1.id)
//    Assert.assertTrue()


}

