import data.Note
import data.Comment
import data.Post
import org.junit.Test
import org.junit.Assert.*
import services.NoteService
import services.PostNotFoundException
import services.TextNotFoundException
import services.WallService

class MainKtTest {

    @Test
    fun addTest() {
        val testPost1 = Post()
        assertTrue(WallService.add(testPost1).id != testPost1.id)
    }

    @Test
    fun updateTest2() {
//        arrange
        val testPost1 = Post(authorName = "Kate", content = "запись")
//        act
        WallService.add(testPost1)
        val result = WallService.updateById(0, "newText")
//        assert
        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun updateTest() {
        val testPost1 = Post(authorName = "Kate", content = "запись")
        WallService.add(testPost1)
        WallService.updateById(10, "txt")
    }


    @Test
    fun commentTest() {
//        arrange
        val testPost1 = Post(authorName = "Kate", content = "запись")
        val testPost2 = Post(id = 5, authorName = "Mary", content = "edited")
//        act
        WallService.add(testPost1)
        WallService.add(testPost2)
        val result = WallService.createComment(id = 1, Comment(text = "comment"))
//        assert
        assertTrue(result)
    }

    @Test (expected = PostNotFoundException::class)
    fun shouldThrowTest() {
        WallService.add(Post())
        WallService.createComment(10, Comment(text = "text"))
    }

    @Test(expected = TextNotFoundException::class)
    fun shouldTextThrowTest() {
        //        arrange
        val testPost1 = Post(authorName = "Kate", content = "запись")
        WallService.add(testPost1)
        WallService.createComment(0, Comment())
    }

    @Test
    fun addNote() {
        val testNote1 = Note(content = "запись", authorName = "Kate")
        assertTrue(NoteService.add(testNote1).id != testNote1.id)
    }

    @Test
    fun updateNote() {
        val testNote1 = Note(content = "запись", authorName = "Kate")
        val testNote2 = Note(content = "запись2", authorName = "Kate")
        NoteService.add(testNote1)
        NoteService.add(testNote2)
        assertTrue(NoteService.updateById(1, "newText"))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowTestNote() {
        NoteService.createComment(5, Comment(text = "text"))
    }

    @Test(expected = PostNotFoundException::class)
    fun updateNoteExc() {
        val testNote1 = Note(content = "запись", authorName = "Kate")
        val testNote2 = Note(content = "запись2", authorName = "Kate")
        NoteService.add(testNote1)
        NoteService.add(testNote2)
        NoteService.updateById(5, "newText")
    }

    @Test
    fun hmCommentTest() {
        val testPost1 = Post(authorName = "Kate", content = "запись")
        val testPost2 = Post(id = 5, authorName = "Mary", content = "edited")
        WallService.add(testPost1)
        WallService.add(testPost2)
        WallService.createComment(id = 1, Comment(text = "comment1"))
        WallService.createComment(id = 1, Comment(text = "comment2"))
        assertTrue(WallService.howMuchComments(1) == 2)
    }

}