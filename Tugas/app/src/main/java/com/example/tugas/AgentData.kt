package com.example.tugas

object AgentData {
    private val agentNames = arrayOf(
        "Cypher", "Jett", "Killjoy", "Omen", "Phoenix", "Raze", "Reyna", "Sage", "Viper", "Yoru"
    )

    private val agentPhotos = intArrayOf(
        R.drawable.cypher,
        R.drawable.jett,
        R.drawable.killjoy,
        R.drawable.omen,
        R.drawable.phoenix,
        R.drawable.raze,
        R.drawable.reyna,
        R.drawable.sage,
        R.drawable.viper,
        R.drawable.yoru,
    )

    private val agentUlti = arrayOf(
        "Where is everyone hiding?",
        "Watch this!",
        "Initiated!",
        "Watch them run",
        "C'mon, let's go!",
        "Here comes the party!",
        "They will cower!",
        "Your duty is not over!",
        "Don't get in my way!",
        "I'll handle this!"
    )

    val listData: ArrayList<Agent>
        get() {
            val list = arrayListOf<Agent>()
            for (i in agentNames.indices) {
                val agent = Agent()
                agent.nama = agentNames[i]
                agent.gambar = agentPhotos[i]
                agent.ulti = agentUlti[i]
                list.add(agent)
            }
            return list
        }
}