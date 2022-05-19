package data

data class Comments(
    val count: Int = 0, // количество комментариев
    val can_post: Boolean = true,//информация о том, может ли текущий пользователь комментировать запись
    val groups_can_post: Boolean = true,//могут ли сообщества комментировать запись
    val can_close: Boolean = true,//может ли текущий пользователь закрыть комментарии к записи
    val can_open: Boolean = true,//может ли текущий пользователь открыть комментарии к записи.
)
