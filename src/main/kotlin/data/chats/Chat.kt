package chats

import data.chats.Message
import data.chats.MessageType
import data.chats.User
import services.NotEditedException

class Chat(
//    val idChat: Int =-1,
    val iAm: User = User(name = "Mary", id = 12133),
    val myComrade: User = User(name = "Tom", id = 32),
    var messageList: MutableList<Message> = mutableListOf(),
//    val msIndex: Int
) {

    fun writeNewMessage(text: String): Message {
        val nextIndex = messageList.lastOrNull()?.idMessage?.plus(1) ?: 0
        messageList += Message(nextIndex, iAm, myComrade, text)
        return messageList.last()
    }

    fun receiveMessage(message: Message) {
        messageList += message.copy(messageType = MessageType.RECIBIDO)
    }

    fun removeMessageByM(message: Message): Boolean =
        messageList.remove(message)

    fun MutableList<Message>.removeMessage(messageToDelete: Message): List<Message> = messageList.filter {
        it != messageToDelete
    }
//        Функция модифицирует messageList, восстановить невозможно

    fun editMessageByM(message: Message, text: String): Boolean {
        messageList.forEach {
            if ((it == message) && (it.messageType == MessageType.BOCETO)) {
                it.copy(text = text)
                return true
            }
        }
        throw NotEditedException("Редактировать можно только черновики")
    }

    fun editMessageByMsg(message: Message, text: String): Boolean {

        messageList.forEach {
            if ((it == message) && (it.messageType == MessageType.BOCETO)) {
                it.copy(text = text)
                return true
            }
        }
        throw NotEditedException("Редактировать можно только черновики")
    }

    fun getAllMessage(): List<Message> = messageList

    fun readUnReadMessage() {
        messageList.filter {
            !it.read
        }.forEach {
            it.read = true
        }
    }

    fun getNotSentMessage(): List<Message> = messageList.filter { message: Message ->
        message.messageType == MessageType.BOCETO
    }

    fun isAnyRead(): Boolean =
        messageList.filter { message: Message ->
            !message.read
        }.isNotEmpty()

}


