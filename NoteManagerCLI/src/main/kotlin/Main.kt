import notemanager.library.Note
import notemanager.library.NoteManager
import java.security.Principal

fun main() {
    var choice = 0;
    val noteManager = NoteManager()
    noteManager.loadNotes()  //load notes
    println("Welcome to Note Manager")

    while(true) {
        choice = printMenu()
        manageChoice(choice, noteManager)
        if(choice == 5){
            println("Goodbye!")
            break
        }
    }


}




fun printMenu(): Int {
    var choice: Int = 0;
    println("Choose an option:")
    println("1. Create a new note")
    println("2. View/Edit Notes")
    println("3. Delete a note")
    println("4. Delete all notes")
    println("5. Exit")
    choice = readln().trim().toInt();
    return choice
}


fun manageChoice(choice: Int, noteManager: NoteManager ) {

    when (choice) {
        1 -> {
            println("Enter note name")
            val title = readln()
            println("Enter note:")
            val note = readln()
            noteManager.createNote(title, note)
            println(".Note created!")
        }

        2 -> {
            //check if notes list is empty
            if (noteManager.getNotes().isEmpty()) {
                println("No notes found")
                return
            }

            //Choose to organize list my new or old before it is displayed
            var validChoice = false
            while (!validChoice) {
                println("View notes [Oldest to Newest] or [Newest to Oldest], type oldest or newest")
                val sortChoice = readln()
                if (sortChoice.equals("Newest", ignoreCase = true)) {
                    noteManager.sortNotesNewest()
                    validChoice = true
                } else if (sortChoice.equals("Oldest", ignoreCase = true)) {
                    noteManager.sortNotesOldest()
                    validChoice = true
                } else {

                    println("Sorry that is not an option, try again.")
                }
            }


            //print out note list
                printNotes(noteManager)

            //Edit notes option given
                println("would you like to edit notes y/n")
                val choice = readln()

                if (choice == "y" || choice == "yes") {

                    println("enter note number to edit")
                    val noteNumber = readln().trim().toInt()
                    editNote(noteNumber, noteManager)
                } else {
                    return
                }


        }

        3 -> {
            //check if notes list is empty
            if (noteManager.getNotes().isEmpty()) {
                println("No notes found")
                return
            }
            var toDelete: Int
            printNotes(noteManager)
            println("Enter note number to be deleted:")
            toDelete = readln().trim().toInt()
            noteManager.deleteNote(toDelete)

        }

        4->{
            if (noteManager.getNotes().isEmpty()) {
                println("No notes found")
                return
            }
            println("Type DELETE/delete to delete all notes")
            val choice = readln()
                if(choice.equals("delete", ignoreCase = true)){
                    noteManager.clearAllNotes()
                }else{
                    println("Notes not deleted returning to menu")
                    return
                }
            }


    }

}

fun printNotes(noteManager: NoteManager) {
    var i : Int = 0
    for (note in noteManager.getNotes()) {
        i++
        println("--------[" + i + "]----------")
        println("Title: " + note.title)
        println("Note :" + note.noteBody)
        println("-------------------------------")
    }


}

fun editNote(noteNumber: Int, noteManager: NoteManager ) {
    println("New note title:")
    val title = readln()
    println("New note :")
    val note = readln()
    noteManager.editNote(noteNumber , title, note)  // -1 to adjust to proper index
    println("Note edited!")

}
