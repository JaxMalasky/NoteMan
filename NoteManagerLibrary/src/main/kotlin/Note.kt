package notemanager.library
import java.time.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
 data class Note(
    var title: String,
    var noteBody: String,
    var createDate : String = LocalDateTime.now().toString()
    )








