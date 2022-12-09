import chats.Chat
import data.chats.ChatService
import data.chats.ChatService.getUnreadByUser
import data.chats.ChatService.getUnreadChatsCount
import data.chats.ChatService.read
import data.chats.ChatService.receiveMessage
import data.chats.ChatService.writeMessage
import data.chats.Message
import data.chats.MessageType
import data.chats.User
import org.junit.Test
import org.junit.Assert.*
import services.PostNotFoundException


class MainKtChatTest {


    @Test
    fun addNewMessage1() {
        val msg = Message(iAm = User(55, "Ira"), text = "new message")
        ChatService.chatList.writeMessage(msg, true)
        assertTrue(ChatService.chatList.receiveMessage(msg) == "Сообщение добавлено в новый чат")
    }

    @Test
    fun addNewMessage2() {
        val msg = Message()
        val msg2 = Message(text = "new message")
        ChatService.chatList.receiveMessage(msg)
        assertTrue(ChatService.chatList.receiveMessage(msg2) == "Сообщение добавлено в чат")
    }

    @Test
    fun getUnreadTest() {
        val msg = Message()
        val msg2 = Message(text = "new message")
        ChatService.chatList.receiveMessage(msg)
        ChatService.chatList.receiveMessage(msg2)
        ChatService.chatList.read(User(name = "Mary", id = 12133))
        assertTrue(ChatService.chatList[0].messageList[0].read)
    }

    @Test
    fun getUnreadTestCounter() {
        val msg = Message()
        val msg2 = Message(text = "new message")
        ChatService.chatList.receiveMessage(msg)
        ChatService.chatList.receiveMessage(msg2)
        ChatService.chatList.getUnreadChatsCount()
        assertTrue(ChatService.chatList.getUnreadChatsCount() == 1)
    }

    @Test(expected = PostNotFoundException::class)
    fun getUnreadTest2() {
        val msg = Message()
        val msg2 = Message(text = "new message")
        ChatService.chatList.receiveMessage(msg)
        ChatService.chatList.receiveMessage(msg2)
        val mary = User(name = "Mary", id = 12133)
        ChatService.chatList.read(mary)
        ChatService.chatList.getUnreadByUser(mary)
    }

    @Test
    fun removeMsgTest() {
        val msg = Message()
        val msg2 = Message(text = "new message")
        val chat = Chat()
        chat.receiveMessage(msg)
        chat.receiveMessage(msg2)
        assertTrue(chat.removeMessageByM(msg2.copy(messageType = MessageType.RECIBIDO)))
    }

}