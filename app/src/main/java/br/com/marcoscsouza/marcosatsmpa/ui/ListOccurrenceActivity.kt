package br.com.marcoscsouza.marcosatsmpa.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.marcoscsouza.marcosatsmpa.R
import br.com.marcoscsouza.marcosatsmpa.databinding.ActivityListOccurrenceBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ListOccurrenceActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListOccurrenceBinding.inflate(layoutInflater)
    }
    lateinit var auth: FirebaseAuth
    private var mUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Lista"
        auth = FirebaseAuth.getInstance()

        btnFab()


    }

    override fun onStart() {
        super.onStart()
        mUser = auth.currentUser

    }




























    private fun btnFab() {
        val fab = binding.fabListOccurrence
        fab.setOnClickListener {
            val intent = Intent(this, CreateOccurrenceActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_user, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.exitMenu -> {
                Toast.makeText(this, "Usuário deslogado.", Toast.LENGTH_SHORT).show()
                auth .signOut()
                mUser = null
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}