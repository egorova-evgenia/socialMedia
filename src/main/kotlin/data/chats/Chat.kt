package chats

import data.chats.Message
import data.chats.MessageType
import data.chats.User
import services.NotEditedException

class Chat(
    val iAm: User = User(name = "Mary", id = 12133),
    val myComrade: User = User(name = "Tom", id = 32),
    var messageList: MutableList<Message> = mutableListOf(),
) {

    fun writeNewMessage(msg: Message): Message {
        messageList += msg
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

    fun editMessageByMsgFun(message: Message, text: String) {
        messageList.find { (it == message) && (it.messageType == MessageType.BOCETO) }
            ?.copy(text = text)
    }

    fun getAllMessage(): List<Message> = messageList

    fun readUnReadMessage() {
        messageList.filter {
            !it.read
        }.forEach {
            it.read = true
        }
    }

    fun getNotSentMessage(): List<Message> = messageList.filter {
        it.messageType == MessageType.BOCETO
    }


    fun isAnyRead(): Boolean =
        messageList.filter { message: Message ->
            !message.read
        }.isNotEmpty()

}


