import data.Comments
import data.Note
import data.OneComment
import data.Post
import org.junit.Test
import org.junit.Assert.*
import service.NoteWork
import service.PostNotFoundException
import service.TextNotFoundException
import service.WallService
import service.WallService.add

class MainKtTest {

    @Test
    fun addTest() {
        val testPost1 = Post(
//            author = "Kate",
            text = "запись"
        )
        assertTrue(testPost1.id < 0)
//        assertTrue(WallService.add(testPost1).id!=testPost1.id)
    }

    @Test
    fun updateTest2() {
//        arrange
        val testPost1 = Post(
            author = "Kate",
            text = "запись"
        )
        val testPost2 = Post(
            id = 0,
            author = "Mary",
            text = "edited"
        )
//        act
        WallService.add(testPost1)
        val result = WallService.update(testPost2)
//        assert
        assertTrue(result)
    }

    @Test
    fun updateTest() {
//        arrange
        val testPost1 = Post(
            author = "Kate",
            text = "запись"
        )
        val testPost2 = Post(
            id = 5,
            author = "Mary",
            text = "edited"
        )
//        act
        WallService.add(testPost1)
        val result = WallService.update(testPost2)
//        assert
        assertFalse(result)
    }


    @Test
    fun commentTest() {
//        arrange
        val testPost1 = Post(
            author = "Kate",
            text = "запись"
        )
        val testPost2 = Post(
            id = 5,
            author = "Mary",
            text = "edited"
        )
//        act
        WallService.add(testPost1)
        WallService.add(testPost2)

        val result = WallService.createComment(id = 1, OneComment(text="comment"))
//        assert
        assertTrue(result)
    }

    @Test (expected = PostNotFoundException::class)
    fun shouldThrowTest() {
        WallService.createComment(5, OneComment(text = "text"))
    }

    @Test(expected = TextNotFoundException::class)
    fun shouldTextThrowTest() {
        //        arrange
        val testPost1 = Post(author = "Kate", text = "запись")
        WallService.add(testPost1)
        WallService.createComment(0, OneComment())
    }

    @Test
    fun addNote() {
//        arrange
        val testNote1 = Note(text = "запись", author = "Kate")
        assertTrue(testNote1.id < 0)

//        assertTrue(NoteWork.add(testNote1).id!=testNote1.id)
    }


}