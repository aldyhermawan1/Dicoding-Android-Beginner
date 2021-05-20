package com.hermawan.valorantagent

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Detail : AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ROLE = "extra_role"
        const val EXTRA_BIO = "extra_bio"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_SKILL1 = "extra_skill1"
        const val EXTRA_SKILL2 = "extra_skill2"
        const val EXTRA_SKILL3 = "extra_skill3"
        const val EXTRA_SKILL4 = "extra_skill4"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_name_detail)
        val tvRole: TextView = findViewById(R.id.tv_role_detail)
        val tvBio: TextView = findViewById(R.id.tv_bio_detail)
        val tvSkillField1: TextView = findViewById(R.id.tv_field1)
        val tvSkillField2: TextView = findViewById(R.id.tv_field2)
        val tvSkillField3: TextView = findViewById(R.id.tv_field3)
        val tvSkillField4: TextView = findViewById(R.id.tv_field4)
        val tvSkillValue1: TextView = findViewById(R.id.tv_value1)
        val tvSkillValue2: TextView = findViewById(R.id.tv_value2)
        val tvSkillValue3: TextView = findViewById(R.id.tv_value3)
        val tvSkillValue4: TextView = findViewById(R.id.tv_value4)
        val imgAgent: ImageView = findViewById(R.id.img_agent_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        val role = intent.getStringExtra(EXTRA_ROLE)
        val bio = intent.getStringExtra(EXTRA_BIO)
        val skill1 = intent.getStringArrayListExtra(EXTRA_SKILL1)
        val skill2 = intent.getStringArrayListExtra(EXTRA_SKILL2)
        val skill3 = intent.getStringArrayListExtra(EXTRA_SKILL3)
        val skill4 = intent.getStringArrayListExtra(EXTRA_SKILL4)
        val photo = intent.getIntExtra(EXTRA_PHOTO,0)

        tvName.text = name
        tvRole.text = role
        tvBio.text = bio
        imgAgent.setImageURI(Uri.parse("android.resource://com.hermawan.valorantagent/drawable/$photo"))
        tvSkillField1.text = skill1?.get(0).toString()
        tvSkillField2.text = skill2?.get(0).toString()
        tvSkillField3.text = skill3?.get(0).toString()
        tvSkillField4.text = skill4?.get(0).toString()
        tvSkillValue1.text = skill1?.get(1).toString()
        tvSkillValue2.text = skill2?.get(1).toString()
        tvSkillValue3.text = skill3?.get(1).toString()
        tvSkillValue4.text = skill4?.get(1).toString()

        supportActionBar?.title = "Agent's Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            return true
        }
}