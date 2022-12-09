import chats.Chat
import data.Comment
import data.Note
import data.chats.*
import data.chats.ChatService.chatList
import data.chats.ChatService.createGeneralMsgList
import data.chats.ChatService.getUnreadByUser
import data.chats.ChatService.receiveMessage
import org.junit.Assert
import services.NoteService
import java.time.LocalDateTime

fun main() {
    val msg1 = Message(
        iAm = User(4, "Kate"),
        text = "new message 3",
        tema = MessageTema.EMPLOYMENT,
        time = LocalDateTime.of(2022, 11, 5, 10, 2)
    )
    val msg3 =
        Message(iAm = User(4, "Kate"), tema = MessageTema.CITY_SERVICES, time = LocalDateTime.of(2022, 11, 7, 10, 15))
    val msg2 =
        Message(text = "new message", tema = MessageTema.CITY_SERVICES, time = LocalDateTime.of(2022, 11, 4, 10, 15))
    val msg4 =
        Message(text = "new message 4", tema = MessageTema.CITY_SERVICES, time = LocalDateTime.of(2022, 11, 9, 12, 15))
    val msg5 = Message(text = "new 5", tema = MessageTema.OTHER, time = LocalDateTime.of(2022, 11, 8, 10, 15))
    val msg6 = Message(text = "new 6", tema = MessageTema.OTHER, time = LocalDateTime.of(2022, 11, 9, 10, 15))
    val msg7 = Message(text = "new 7", tema = MessageTema.EMPLOYMENT, time = LocalDateTime.of(2022, 11, 9, 11, 15))
    val msg8 = Message(text = "new 8", tema = MessageTema.CITY_SERVICES, time = LocalDateTime.of(2022, 11, 9, 13, 15))


    ChatService.chatList.receiveMessage(msg1)
    ChatService.chatList.receiveMessage(msg2)
    ChatService.chatList.receiveMessage(msg3)
    ChatService.chatList.receiveMessage(msg4)
    ChatService.chatList.receiveMessage(msg5)
    ChatService.chatList.receiveMessage(msg6)
    ChatService.chatList.receiveMessage(msg7)
    ChatService.chatList.receiveMessage(msg8)



    println(ChatService.chatList.createGeneralMsgList())
    println("    =======")

    println(ChatService.chatList[0].messageList + ChatService.chatList[1].messageList)
    println("    =======")

    println(ChatService.distribute(MessageTema.CITY_SERVICES))


}

