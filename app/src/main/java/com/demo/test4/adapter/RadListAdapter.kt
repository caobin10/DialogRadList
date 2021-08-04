package com.demo.test4.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.demo.test4.Dict
import kotlinx.android.synthetic.main.item_dialog_rad_default.view.*
import com.demo.test4.R

class RadListAdapter(var selValue: String?, layoutResId: Int = R.layout.item_dialog_rad_default) :
    BaseQuickAdapter<Dict, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: Dict) {
        helper.itemView.run {

            chk_dialog_rad_item.apply {
                text = item?.dataName
                isChecked = item?.dataValue.equals(selValue)
            }
        }
    }

    fun  setCheckSelValue(selValue: String?){
        this.selValue = selValue
        notifyDataSetChanged()
    }

    fun getSelectIndex(): Int {
        var index = 0
        data.forEachIndexed { i, dict ->
            if(dict.dataValue == selValue){
                index = i
                return@forEachIndexed
            }
        }
        return index
    }

}