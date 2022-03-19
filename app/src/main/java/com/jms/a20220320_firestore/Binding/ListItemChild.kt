package com.jms.a20220320_firestore.Binding

import android.view.View
import com.jms.a20220320_firestore.R
import com.jms.a20220320_firestore.databinding.ListItemChildBinding
import com.jms.a20220320_firestore.databinding.ListItemParentBinding
import com.xwray.groupie.viewbinding.BindableItem

class ListItemChild(val title:String="소제목", val listener : (View?)-> Unit ={}) : BindableItem<ListItemChildBinding>() {
    override fun bind(viewBinding: ListItemChildBinding, position: Int) {
        viewBinding.textViewItemChild.text = title
        viewBinding.textViewItemChild.setOnClickListener(listener)


    }

    override fun getLayout(): Int {
        return R.layout.list_item_child
    }

    override fun initializeViewBinding(view: View): ListItemChildBinding {
        return ListItemChildBinding.bind(view)
    }

}