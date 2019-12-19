package fr.purplegiraffe.recyclerdemob2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cell_player.view.*
import io.realm.Realm
import kotlinx.android.synthetic.main.cell_player.*
import kotlinx.android.synthetic.main.cell_player.username
import kotlinx.android.synthetic.main.form_activity.*
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    var gestionAccount = GestionAccount()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // a supprimer
       // Realm.deleteRealm(Realm.getDefaultConfiguration())

        //creeDesPassword()

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = PlayerListAdapter()

    }

    inner class PlayerListAdapter : RecyclerView.Adapter<PlayerListAdapter.PlayerCellHolder>() {


        val accountList = gestionAccount.getAllAccount()

        inner class PlayerCellHolder(view:View) : RecyclerView.ViewHolder(view) {
            val usernameLabel = view.username
            val softwareLabel = view.serviceName
            val updateButton = view.updateAccount

            fun displayerPlayer(account: Account) {
                usernameLabel.text = account.username
                softwareLabel.text = account.serviceName
                updateButton.setOnClickListener{
                    updateAccountForm(account)
               }

            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerCellHolder {
            // 1 creer la vue avec mise en page
            val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_player, parent, false)

            // 2 créer un holder associé à la vue
            val holder = PlayerCellHolder(view)

            // 3 retourner le holder
            return holder
        }

        override fun getItemCount(): Int {
            return accountList.size
        }

        override fun onBindViewHolder(holder: PlayerCellHolder, position: Int) {


            // 1 charger le player 'position'
            val myPlayer = accountList[position]

            // 2 envoyer le player dans le holder
            if (myPlayer != null) {
                holder.displayerPlayer(myPlayer)
            }
        }






    }


    fun createAccountForm(button: View)
    {
        val intent = Intent(this, FormActivity::class.java)
        startActivity(intent)

    }


    fun updateAccountForm(account: Account)
    {
        val intent = Intent(this, FormActivity::class.java)
        intent.putExtra("username", account.username)
        intent.putExtra("serviceName", account.serviceName)
        startActivity(intent)
    }



}