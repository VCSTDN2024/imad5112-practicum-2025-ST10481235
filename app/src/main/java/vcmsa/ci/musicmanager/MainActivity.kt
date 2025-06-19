package vcmsa.ci.musicmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var Songtitle: TextView
    private lateinit var Songtitlespinner: Spinner
    private lateinit var Artist: TextView
    private lateinit var Artistspinner: Spinner
    private lateinit var RatingTV: TextView
    private lateinit var Ratings: Spinner
    private lateinit var Comment: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Declaring the variables
        Songtitle = findViewById(R.id.SongtitletextView)
        Songtitlespinner = findViewById(R.id.Songtitlespinner)
        Artist = findViewById(R.id.ArtisttextView)
        Artistspinner = findViewById(R.id.Artistspinner)
        RatingTV = findViewById(R.id.RatingtextView)
        Ratings = findViewById(R.id.Ratingspinner)
        Comment= findViewById(R.id.CommentseditText)
        val songtitles = arrayOf("Love me not", "Hideaway", "MUTT", "Burning Blue") // names of the songs
        Songtitlespinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, songtitles)

        val artistnames = arrayOf("Ravyn Lenae", "Kiesza", "Leon Thomas", "Mariah the scientist") //artists of the above songs
        Artistspinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, artistnames)

        val ratings = arrayOf("1", "2", "3", "4", "5") // ratings between 1-5
        Ratings.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ratings)


        findViewById<Button>(R.id.Nextbtn).setOnClickListener {
            startActivity(Intent(this, DetailsMainActivity2::class.java)) // moves to the next screen
        }

        findViewById<Button>(R.id.Addbtn).setOnClickListener {
            addEntry() // adds a song to the playlist
        }


        val Nextbtn = findViewById<Button>(R.id.Nextbtn) //Moves on to the next screen

        findViewById<Button>(R.id.Exitbtn).setOnClickListener {
            finishAffinity() //closes the application completely

        }


    }

    private fun addEntry() {
        val title = Songtitle.text.toString()
        val songspin= Songtitlespinner.selectedItem.toString()
        val artist= Artist.text.toString()
        val artistSpin= Artistspinner.selectedItem.toString()
        val ratingText= RatingTV.text.toString()
        var ratingSpin= Ratings.selectedItem.toString().toInt()

        ratingSpin=ratingSpin. toInt()
        if (ratingSpin == null || ratingSpin !in 1..5) {
            Toast.makeText(this, "Invalid input values", Toast.LENGTH_SHORT).show()
        }

        SongPlaylist.title.add(title)
        SongPlaylist.songspin.add(songspin)
        SongPlaylist.artist.add(artist)
        SongPlaylist.artistSpin.add(artistSpin)
        SongPlaylist.ratingText.add(ratingText)
        SongPlaylist.ratingSpin.add(ratingSpin)

        Toast.makeText(this, "Entry added!", Toast.LENGTH_SHORT).show()

    }





}