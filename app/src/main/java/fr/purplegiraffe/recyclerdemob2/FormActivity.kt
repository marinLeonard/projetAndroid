package fr.purplegiraffe.recyclerdemob2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.cell_player.serviceName
import kotlinx.android.synthetic.main.cell_player.username
import kotlinx.android.synthetic.main.form_activity.*

class FormActivity: AppCompatActivity() {

    var gestionAccount = GestionAccount();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_activity)

        if (existAccount())
        existingAccountForm()
        else
            createAccountForm()

    }



    fun existAccount(): Boolean
    {
        return (intent.getStringExtra("username") != null && intent.getStringExtra("serviceName") != null)
    }

    fun existingAccountForm()
    {

           val account = gestionAccount.getAccount(intent.getStringExtra("username"), intent.getStringExtra("serviceName"))
            if(account != null)
                {
                    serviceName.text = account.serviceName
                    username.text = account.username
                    password.setText(account.password)
                    mail.setText(account.email)

                    actionButton.text = getString(R.string.update)
                    actionButton.setOnClickListener{
                        updateAccount(account);
                    }
                }
    }

    fun createAccountForm()
    {
        actionButton.text = getString(R.string.createAccount)
        actionButton.setOnClickListener{
            createNewAccount();
        }

        deleteButton.visibility = View.GONE
    }


    fun updateAccount(account: Account)
    {
        val updatedAccount = Account()
        updatedAccount.email = mail.text.toString()
        updatedAccount.username = username.text.toString()
        updatedAccount.password = password.text.toString()
        updatedAccount.serviceName = serviceName.text.toString()


        gestionAccount.UpdateAccount(account.username,account.serviceName, updatedAccount)



        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    fun createNewAccount(){
        val account = Account()


        if (serviceName.text !== null)
            account.serviceName = serviceName.text.toString()
        if (username.text !== null)
            account.username = username.text.toString()
        if (password.text !== null)
            account.password = password.text.toString()



        gestionAccount.createAccount(account)


        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }


    fun delete(button: View)
    {
        val serviceName = serviceName.text.toString();
        val username = username.text.toString();

        val account = gestionAccount.getAccount(username, serviceName);

        if (account != null)
        gestionAccount.deleteAccount(account);

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



}