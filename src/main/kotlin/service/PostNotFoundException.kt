package service

import java.lang.RuntimeException
class PostNotFoundException(message: String) :RuntimeException(message)

class TextNotFoundException(message: String) :RuntimeException(message)