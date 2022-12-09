package data.chats

import chats.Chat
import java.time.LocalDateTime

data class Message(
//    val idMessage: Int = -1,
    val iAm: User = User(name = "Mary", id = 12133),
    val myComrade: User = User(name = "Tom", id = 32),
    val text: String = "txt",
    var read: Boolean = false,
    var messageType: MessageType = MessageType.BOCETO,
    val tema: MessageTema? = null,
    val time: LocalDateTime = LocalDateTime.of(2022, 11, 5, 10, 15),
    val status: MessageStatus? = null
) : Comparable<Message> {
    override fun compareTo(other: Message): Int {
        return this.time.compareTo(other.time)

    }

    override fun toString(): String {
        return time.toString() + tema.toString() + "  " + text.toString()
    }
}