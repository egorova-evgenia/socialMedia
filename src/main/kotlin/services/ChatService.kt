//package services
//
//import chats.Message
//import data.chats.Chat
//import data.chats.Message
//
//object ChatService : TextObjectService<Message> {
//    override val txtObjList: MutableList<Message> = mutableListOf()
//    fun getNewMessage(message: Message) {
//        txtObjList.forEachIndexed { index, obj ->
//            if (message.fromId == obj.fromId) {
//                txtObjList[index].getMessage(message)
//                return
//            }
//        }
//        val newChat = Chat(myComrade = message.myComrade)
//        message.id = 0
//        newChat.getMessage(message)
//        ChatService.add(newChat)
//    }
//
//    fun sendNewMessage(message: Message) {
//        txtObjList.forEachIndexed { index, obj ->
//            if (message.myComrade.id == obj.fromId) {
//                txtObjList[index].sendMessage(message)
//                return
//            }
//        }
//        val newChat = Chat(myComrade = message.myComrade)
//        message.id = 0
//        newChat.sendMessage(message)
//        ChatService.add(newChat)
//
//    }
//
//    fun howMuchMessage(id: Int): Int {
//        txtObjList.forEach {  cht ->
//            if (cht.id == id) {
//                return cht.messageList.size
//            }
//        }
//        throw CommentNotFoundException("Чат не найден")
//    }
//
//
//    fun showChatService() {
//        txtObjList.forEach{ obj ->
//            if (obj.id >= 0) {
//                println("From: " + obj.fromName + " Recived: " + "  " + obj.messageList.size+ "  " + obj.messageList.filter { it.readed==false }.size)
//            }
//        }
//    }
//
//    fun showMessageService(id: Int) {
//        txtObjList.forEach { cht ->
//            if (cht.id == id) {
//                cht.messageList.forEach() { msg -> msg.readed=true}
//                cht.showMessages()
//                return
//            }
//        }
//        throw CommentNotFoundException("Чат не найден")
//    }
//
//    fun howManyUnreaded(id: Int): Int
//    {generalFun(id,(return cht.messageList.filter { it.readed==false }.size),ChatActions.UNREADED)}
//    {
//        txtObjList.forEach { cht ->
//            if (cht.id == id) {
//                return cht.messageList.filter { it.readed==false }.size
//            }
//        }
//        throw CommentNotFoundException("Чат не найден")
//    }

//    fun generalFun(id: Int, lambda: Any, act: ChatActions): Any {
//        txtObjList.forEach { cht ->
//            if (cht.id == id) {
//                lambda
////                when (act) {
////                    ChatActions.UNREADED -> {return cht.messageList.filter { it.readed==false }.size}
////                    ChatActions.HMMessage -> {return cht.messageList.size}
////
////                }
//            }
//        }
//        throw CommentNotFoundException("Чат не найден")
//    }


//        fun generalFun(id: Int, act: ChatActions): Any {
//        txtObjList.forEach { cht ->
//            if (cht.id == id) {
//
//                return cht.messageList.filter { it.readed==false }.size
//            }
//        }
//        throw CommentNotFoundException("Чат не найден")
//    }


//}