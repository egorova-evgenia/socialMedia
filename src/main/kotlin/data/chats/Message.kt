package data.chats

data class Message(
    val idMessage: Int = -1,
    val iAm: User = User(name = "Mary", id = 12133),
    val myComrade: User = User(name = "Tom", id = 32),
    val text: String = "txt",
    var read: Boolean = false,
    var messageType: MessageType = MessageType.BOCETO,
//    val reSendFrom: User?
)