package com.hermawan.valorantagent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAgents: RecyclerView
    private var list:ArrayList<Agents> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Valorant Agents"

        rvAgents = findViewById(R.id.rv_agents)
        rvAgents.setHasFixedSize(true)

        list.addAll(AgentsData.listData)
        showRecyclerView()
    }
    private fun showRecyclerView(){
        rvAgents.layoutManager = LinearLayoutManager(this)
        val agentAdapter = AgentAdapter(list)
        rvAgents.adapter = agentAdapter

        agentAdapter.setOnItemClickCallback(object : AgentAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Agents) {
                showDetail(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val aboutIntent = Intent(this, About::class.java)
        startActivity(aboutIntent)
        return super.onOptionsItemSelected(item)
    }

    private fun showDetail(agents: Agents) {
        val detailIntent = Intent(this, Detail::class.java)
        detailIntent.putExtra(Detail.EXTRA_NAME, agents.name)
        detailIntent.putExtra(Detail.EXTRA_ROLE, agents.role)
        detailIntent.putExtra(Detail.EXTRA_BIO, agents.bio)
        detailIntent.putExtra(Detail.EXTRA_PHOTO, agents.photo)
        detailIntent.putExtra(Detail.EXTRA_SKILL1, agents.skill[0])
        detailIntent.putExtra(Detail.EXTRA_SKILL2, agents.skill[1])
        detailIntent.putExtra(Detail.EXTRA_SKILL3, agents.skill[2])
        detailIntent.putExtra(Detail.EXTRA_SKILL4, agents.skill[3])
        startActivity(detailIntent)
    }
}