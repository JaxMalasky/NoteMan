package notemanager.library
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import java.io.File


 class NoteManager {
    private val notes = mutableListOf<Note>()
     private var notesFile = File("notes.json")

     //used to create note and add it to the array
    fun createNote(title: String, noteBody: String){
       val note  = Note(title,noteBody)
        notes.add(note)
        saveNotes()
    }
    //returns the note list
    fun getNotes(): List<Note>{
        if(notes.isEmpty()){
            println("No notes founds")
        }
        return notes
    }
    //expects a int to delete a note with
    fun deleteNote(i: Int){
        val index = i - 1 // calculate the index for the mutable list.
        notes.removeAt(index)
        saveNotes() //update file after deleting a note
    }
// to be implemented Delete by note function, may be useful
//     fun deleteNote(note: Note){
//         for(notes in notes){
//
//             if(notes.title == note.title){
//
//             }
//
//         }
//         saveNotes() //update file after deleting a note
//     }

     //sorts list by oldest first
     fun sortNotesOldest(){
         notes.sortBy{it.time}
     }
     //sorts list by newest first
     fun sortNotesNewest(){
         notes.sortByDescending {it.time}
     }



     fun clearAllNotes(){
         notes.clear()
         notesFile.writeText("[]")

     }

    //Overloading edit functions.

    fun editNote(note: Note, title: String, body: String){
        note.title = title
        note.noteBody = body
    }

    //used to edit note by int value
    fun editNote(i: Int, title: String, body: String){
       if(notes.isEmpty()){

           return
       }
        val index = i - 1 // calculate the index for the mutable list.
        notes[index].title = title
        notes[index].noteBody = body
    }

     fun loadNotes(){

         if(!notesFile.exists()){
             notesFile.writeText("[]")
             return
         }

         val notesJson = notesFile.readText()
         notes.clear() // clear notes mutable list
         notes.addAll(Json.decodeFromString(notesJson)) //decode json and add to string

     }

    //saves notes list in JSON format
     fun saveNotes(){
         val json = Json
         val notesJson = json.encodeToString(notes)
         File("notes.json").writeText(notesJson)
     }


}
