package vcmsa.ci.musicmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsMainActivity2 : AppCompatActivity() {
    private lateinit var TitletextView: TextView
    private lateinit var DetailsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_main2)

        TitletextView= findViewById(R.id.TitletextView)
        DetailsTextView= findViewById(R.id.DetailstextView)

        val processor= Processor (
            SongPlaylist.title,
            SongPlaylist.songspin,
            SongPlaylist.artist,
            SongPlaylist.artistSpin,
            SongPlaylist.ratingText,
            SongPlaylist.ratingSpin
        )

        DetailsTextView.text= processor.getAverageRating().toString()

        findViewById<Button>(R.id.Displaybtn).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java ))
        }

        findViewById<Button>(R.id.Exitbtn2).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))

        }
    }
}