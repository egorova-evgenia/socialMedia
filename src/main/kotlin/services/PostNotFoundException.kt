package services

import java.lang.RuntimeException

class PostNotFoundException(message: String) : RuntimeException(message)

class TextNotFoundException(message: String) : RuntimeException(message)

class CommentNotFoundException(message: String) : RuntimeException(message)
class NotEditedException(message: String) : RuntimeException(message)



