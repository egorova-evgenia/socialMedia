package data.chats

import chats.Chat
import services.PostNotFoundException


object ChatService {
    val chatList: MutableList<Chat> = mutableListOf()

    fun getChatByU(user: User): Chat {
        chatList.forEach {
            if (it.myComrade == user) {
                return it
            }
        }
        throw PostNotFoundException("чат с пользователем ${user.name} не найден")
    }

    fun MutableList<Chat>.receiveMessage(message: Message): String {
        chatList.forEach {
            if (it.myComrade == message.iAm) {
                it.messageList += message.copy(messageType = MessageType.RECIBIDO)
                return "Сообщение добавлено в чат"
            }
        }
        val newChat = Chat(myComrade = message.iAm)
        newChat.messageList += message.copy(messageType = MessageType.RECIBIDO)
        chatList += newChat
        return "Сообщение добавлено в новый чат"
    }

    fun MutableList<Chat>.writeMessage(message: Message, sendNow: Boolean): String {
        chatList.forEach {
            if (it.myComrade == message.myComrade) {
                it.messageList += message.copy(
                    messageType = if (sendNow) {
                        MessageType.ENVIADO
                    } else {
                        MessageType.BOCETO
                    }
                )
                return "Сообщение добавлено в чат"
            }
        }
        val newChat = Chat(myComrade = message.myComrade)
        newChat.messageList += message.copy(messageType = MessageType.RECIBIDO)
        chatList += newChat
        return "Сообщение добавлено в новый чат"
    }

    fun MutableList<Chat>.getMsgByUser(user: User): List<Message> {
        chatList.forEach {
            if (it.myComrade == user) {
                return it.messageList
            }
        }
        throw PostNotFoundException("Чат с пользователем ${user.name} не найден")
    }

    fun MutableList<Chat>.getUnreadByUser(user: User): List<Message> {
        chatList.forEach { it ->
            if (it.myComrade == user) {
                if (it.messageList.filter {
                        !it.read
                    }.isNotEmpty())
                    return it.messageList
            } else {
                throw PostNotFoundException("Все сообщения прочитаны")
            }
        }
        throw PostNotFoundException("Чат не найден")
    }

    fun MutableList<Chat>.read(user: User) {
        if (chatList.getUnreadByUser(user).isNotEmpty()) {
            val chat = chatList.find { it.myComrade == user }
            val ind = chatList.indexOf(chat)
            chatList[ind].readUnReadMessage()
        }
    }

    //    : MutableList<Message>
    fun MutableList<Chat>.createGeneralMsgList() =
        chatList
            .filter { it.isAnyRead() }
            .ifEmpty { throw PostNotFoundException("Все сообщения прочитаны") }
            .map {
                it.messageList.filter { !it.read }
            }
            .reduce { acc, messages -> acc + messages }
            .sortedWith(compareBy { it.time })

    fun distribute(tema: MessageTema): MutableList<Message> =
        chatList.createGeneralMsgList().asSequence()
            .filter { it.tema == tema }
            .ifEmpty { throw PostNotFoundException("нет обращений по этой теме") }
            .take(2)
            .toMutableList()

    fun MutableList<Chat>.getUnreadChats(): List<Chat> =
        chatList.filter {
            it.messageList.filter { message: Message ->
                !message.read
            }.isNotEmpty()
        }

    fun MutableList<Chat>.getUnreadChatsCount(): Int =
        chatList.getUnreadChats().size

    fun MutableList<Chat>.removeMessage(message: Message) {
        chatList.forEach {
            if ((it.myComrade == message.myComrade) || (it.myComrade == message.iAm)) {
                it.messageList.remove(message)
                if (it.messageList.isEmpty()) {
                    chatList.remove(it)
                }
            }
        }
    }

    fun MutableList<Chat>.removeChatByU(user: User) =
        chatList.filter {
            it.myComrade != user
        }
}
