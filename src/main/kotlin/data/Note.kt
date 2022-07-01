package data

data class Note(
    override var id: Int = -1,
    override var text: String = "txt",
    override val noteAutorId: Int = 1,
    override val author: String = "Mary"
) : TextObject() {
    override fun whatIsIt(): String {
        return "Note"
    }

}
