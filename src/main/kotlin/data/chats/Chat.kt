package chats

import data.TextObject
import data.chats.MessageType
import data.chats.User
import services.CommentNotFoundException

data class Message(
    val idMessage: Int = -1,
    val iAm: User = User(name = "Mary", id = 12133),
    val myComrade: User = User(name = "Tom", id = 32),
    val text: String = "txt",
    var readed: Boolean = false,
    var messageType: MessageType = MessageType.BOCETO
)

//): TextObject(){
//
//    val fromId: Int = myComrade.id
//    val fromName: String = myComrade.name
//
//    override fun whatIsIt(): String {
//        return "Message"
//    }
//}
//
data class Chat(
//    override var id: Int =-1,
    val iAm: User = User(name = "Mary", id = 12133),
    val myComrade: User = User(name = "Tom", id = 32),
//    val messageList: MutableList<Message> = mutableListOf(),
//
) : TextObject() {
    override fun copyId(id: Int): TextObject {
        TODO("Not yet implemented")
    }

    override fun copyContent(newText: String): TextObject {
        TODO("Not yet implemented")
    }

    override fun whatIsIt(): String {
        TODO("Not yet implemented")
    }
}
//
//    {
//
//    val fromId: Int = myComrade.id
//    val fromName: String = myComrade.name
//    val ownerId: Int = iAm.id
//    override val author: String = iAm.name
//
//    override fun whatIsIt(): String {
//        return "Chat"
//    }
//
//    fun getMessage(message: Message): Boolean {
//        if (message.text != null) {
//            message.id=messageList.size
//            message.messageType=MessageType.RECIBIDO
//            messageList += message
//            return true
//        }
//        throw CommentNotFoundException("Пустое сообщение")
//    }
//
//    fun sendMessage(message: Message): Boolean {
//        if (message.text != null) {
//            message.id=messageList.size
//            message.messageType=MessageType.ENVIADO
//            messageList += message
//
//            return true
//        }
//        throw CommentNotFoundException("Пустое сообщение")
//    }
//
//    fun showMessages() {
//        messageList.forEach { message ->
//            if (message.id >= 0) {
//                println(message.fromName + "  " + message.text + "  " + message.id+"  "+message.messageType)
//            }
//        }
//        println()
//    }
//}