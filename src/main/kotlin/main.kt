import data.Post
import data.Attachments
import service.WallService

fun main() {

//    Создадим несколько постов
    val post1 = Post(
    authorName = "Mary",
    content = "первая запись"
    )

    val post2 = Post(
        authorName = "Mary",
        content = "вторая запись"
    )
    val post3 = Post(
        authorName = "Sarah",
        content = "третья запись"
    )

    var link1= Attachments.AttachLink (url="Ссылка")
    post2.addAttachment(link1)
//    println(post2)

    WallService.add(post1)
    WallService.add(post2)
    WallService.add(post3)

//    WallService.shortToString()
    val postNew3 = post3.copy(authorName = "Mary",id=5,content = "edited")


    WallService.removeById(1)

//    println(postNew3.id)
    println(WallService.update(postNew3))
//    WallService.shortToString2()

}
