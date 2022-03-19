package com.jms.a20220320_firestore.Binding

import android.view.View
import com.jms.a20220320_firestore.R
import com.jms.a20220320_firestore.databinding.ListItemParentBinding
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.viewbinding.BindableItem

class ListItemParent(val title : String ="리스트") : BindableItem<ListItemParentBinding>(),ExpandableItem {
    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewBinding: ListItemParentBinding, position: Int) {
        viewBinding.textViewItemParent.text=title
        viewBinding.root.setOnClickListener{
            expandableGroup.onToggleExpanded()
        }

    }

    override fun getLayout(): Int {
        return R.layout.list_item_parent
    }

    override fun initializeViewBinding(view: View): ListItemParentBinding {
        return ListItemParentBinding.bind(view)
    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        this.expandableGroup = onToggleListener
    }

}