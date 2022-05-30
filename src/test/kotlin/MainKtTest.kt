import data.Post
import org.junit.Test
import org.junit.Assert.*
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

}