import data.Comments
import data.OneComment
import data.Post
import org.junit.Test
import org.junit.Assert.*
import service.PostNotFoundException
import service.TextNotFoundException
import service.WallService

class MainKtTest {

    @Test
    fun addTest() {
//        arrange
        val testPost1 = Post(
            authorName = "Kate",
            content = "запись"
        )

//        act
//        assert
        assertTrue(WallService.add(testPost1).id!=testPost1.id)
    }

    @Test
    fun updateTest2() {
//        arrange
        val testPost1 = Post(
            authorName = "Kate",
            content = "запись"
        )
        val testPost2 = Post(
            id=0,
            authorName = "Mary",
            content = "edited"
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
            authorName = "Kate",
            content = "запись"
        )
        val testPost2 = Post(
            id=5,
            authorName = "Mary",
            content = "edited"
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
            authorName = "Kate",
            content = "запись"
        )
        val testPost2 = Post(
            id=5,
            authorName = "Mary",
            content = "edited"
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
        assert(WallService.createComment(5, OneComment(text="text")))
    }

    @Test(expected = TextNotFoundException::class)
    fun shouldTextThrowTest() {
        //        arrange
        val testPost1 = Post(authorName = "Kate", content = "запись")
//        act
        WallService.add(testPost1)
        assert(WallService.createComment(0, OneComment()))
    }
}