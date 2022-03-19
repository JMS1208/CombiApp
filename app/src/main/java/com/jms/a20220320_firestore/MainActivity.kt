package com.jms.a20220320_firestore

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jms.a20220320_firestore.Binding.ListItemChild
import com.jms.a20220320_firestore.Binding.ListItemParent
import com.jms.a20220320_firestore.databinding.ActivityMainBinding
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "통합 어플"



        val groupAdapter = GroupAdapter<GroupieViewHolder>()


        val parentItem = ListItemParent("이미지 관련")
        groupAdapter.add(ExpandableGroup(parentItem))
        val groupItem0 = groupAdapter.getGroupAtAdapterPosition(0) as ExpandableGroup
        groupItem0.add(ListItemChild("스토리지에 저장") {
            val intent = Intent(applicationContext, ImageStorageActivity::class.java)
            startActivity(intent)
        })
        groupItem0.add(ListItemChild("소 카테고리2") {
            //람다함수 구현
        })

        groupAdapter.add(ExpandableGroup(ListItemParent("카테고리2")))
        val groupItem1 = groupAdapter.getGroupAtAdapterPosition(1) as ExpandableGroup
        groupItem1.add(ListItemChild("소 카테고리1") {

        })
        groupItem1.add(ListItemChild("소 카테고리2") {

        })
        groupItem1.add(ListItemChild("소 카테고리3") {

        })





        binding.recyclerView.adapter = groupAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }




    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.menu_main,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.changeBGC_RED -> {
                binding.root.setBackgroundColor(resources.getColor(R.color.darkgreen))
                true
            }
            R.id.changeBGC_BLACK -> {
                binding.root.setBackgroundColor(resources.getColor(R.color.bluegreen))
                true
            }
            R.id.beforeSetting -> {
                binding.root.setBackgroundColor(Color.WHITE)
                true
            }
            else-> super.onOptionsItemSelected(item)
        }
    }

}