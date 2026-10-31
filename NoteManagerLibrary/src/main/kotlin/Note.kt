package notemanager.library
import java.time.LocalDateTime
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
 data class Note(
    var title: String,
    var noteBody: String,
    var createDate : String = LocalDateTime.now().toString(),
    val time: Long = System.currentTimeMillis()

    )








