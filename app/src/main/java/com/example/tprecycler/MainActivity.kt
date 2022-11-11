package com.example.tprecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), myAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
     lateinit var btn: Button
    var values= arrayListOf<String>("item1","item2","item3","item4","item5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        manager = LinearLayoutManager(this)
        myAdapter = myAdapter(values,this)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply{
            layoutManager = manager
            adapter = myAdapter
        }
        btn= findViewById(R.id.btn)
        btn.setOnClickListener{
            var n:Int = values.size + 1
            values.add("item$n")
            myAdapter.notifyItemInserted(values.size)
        }


    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Item $position clicked",Toast.LENGTH_LONG).show()
        values[position]="Clicked"
        myAdapter.notifyItemChanged(position)

    }


}
//inner
// .onclickListener