# Overview
Note Manager Kotlin Library and CLI Interface

This projects demonstrates my learning of the Kotlin language in the areas of encapsulation by way of a packaged library


The software created includes a NotesManager.jar file and a CLI interface used demonstrates its functionality. 
The program allows the user to create, edit, and organize notes through the CLI. The users notes will also persist when the program is closed.

The NoteManager code includes two classes.
- Note.kt :  a Serializable data class whose contents can be written in a JSON format and stored by the NotesManager.kt. 
- NoteManager.Kt: Contains the API functions for the creation, storage, and manipulation of the notes. The notes are stored in a mutable list while the program is running and later
into JSON file to persist when the program is closed. 

The software was developed as an intro to the Kotlin language but to also explore the
process of creating and packaging an API library to be usable
with different interfaces. So far I have only implemented a 
CLI interface. For certain work would probably need to be 
done on the API side of things to have it be fully functional with 
something like a mobile application but the groundwork is laid. 





[Software Demo Video](https://youtu.be/uOzPcyXUGts)


# Development Environment
*IDE* 
- IntellIJ


*Language and Libraries used*
- Kotlin (programming language)
- kotlinx.serialization (Library)
- kotlinx.serialization.json (Library)
- java.time (Library)
# Useful Websites

{Make a list of websites that you found helpful in this project}

- [Intellij IDEA](https://www.jetbrains.com/idea/)
- [Welcome Tour of Kotlin](https://kotlinlang.org/docs/kotlin-tour-welcome.html)

# Future Work



- Error Handling in both API and CLI, I have note tested it for errors very throughly and you could probably break it easily
- There are functions that are unimplemented or unfinished and commented out in NoteManager.kt. I wrote them thinking they might useful later and on some did not finish building them. 
- The process of organizing notes is kind of restricting in the CLI. You can only organize by old or new and you also HAVE to choose one of them to view the notes. It would be better to have implemented a skip.
- It would be best to develop another piece of software to use the NoteManger library to fully demonstrate its versitility(in a beginner level context) 
