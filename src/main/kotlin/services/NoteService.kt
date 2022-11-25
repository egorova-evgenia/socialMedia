package services

import data.Note

object NoteService : TextObjectService<Note> {

    override val txtObjList: MutableList<Note> = mutableListOf()

    fun shortToString(): Boolean {
        txtObjList.forEachIndexed { index, post ->
            if (txtObjList[index].id >= 0) {
                println(txtObjList[index].authorName + "  " + txtObjList[index].content + "  " + txtObjList[index].id)
            }
        }
        return false
    }

}
