package br.com.marcoscsouza.marcosatsmpa.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.marcoscsouza.marcosatsmpa.R
import br.com.marcoscsouza.marcosatsmpa.databinding.ActivityCreateOccurrenceBinding
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateOccurrenceActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCreateOccurrenceBinding.inflate(layoutInflater)
    }
    private val firebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "criar ocorrencia"


    }

















    override fun onResume() {
        super.onResume()
        if (!estaLogado()) {
            val i = Intent(this, UserLoginActivity::class.java)
            startActivity(i)
        }
    }
    fun estaLogado(): Boolean {
        val userFire: FirebaseUser? = firebaseAuth.currentUser
        return if (userFire != null) {
            true
        } else {
            Toast.makeText(this, "Usuário não está logado!", Toast.LENGTH_SHORT).show()
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_occurrence, menu)
        menuInflater.inflate(R.menu.menu_user, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.exitMenu -> {
                Toast.makeText(this, "Usuário deslogado.", Toast.LENGTH_SHORT).show()
                firebaseAuth.signOut()
                val i = Intent(this, UserLoginActivity::class.java)
                startActivity(i)
            }
            R.id.back_activity_menu -> {
                startActivity(Intent(this, ListOccurrenceActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}