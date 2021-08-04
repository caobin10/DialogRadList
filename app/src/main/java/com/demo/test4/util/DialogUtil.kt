package com.demo.test3.util

import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import com.demo.test4.Dict
import com.demo.test4.MyApplication
import com.demo.test4.R
import com.demo.test4.adapter.RadListAdapter
import com.demo.test4.view.MaxHeightRecyclerView
import com.demo.test4.view.region.PhoneU
import per.goweii.anylayer.AnyLayer
import per.goweii.anylayer.DialogLayer

/**
 * 底部弹出的列表对话框（单选）
 */
fun showBottomRadListDialog(title:String?,selValue:String?,dictList:List<Dict>, callback: OnResultCallback<String>, defaultBackground:Boolean = true){

    var dialog = AnyLayer.dialog()
        .contentView(R.layout.dialog_list)
        .gravity(Gravity.BOTTOM)
        .animStyle(DialogLayer.AnimStyle.BOTTOM)

    //使用默认的背景
    if(defaultBackground){
        dialog.backgroundDimDefault()
    }

    dialog.show()

    dialog.getView<TextView>(R.id.tv_dialog_title).text = title?:""

    var rv = dialog.getView<MaxHeightRecyclerView>(R.id.mRecyclerView)
    rv.setMaxHeight(PhoneU.getScreenPix(MyApplication.context)!!.heightPixels * 3 / 5 )

    var selValue: String?= selValue

    var mAdapter = RadListAdapter(selValue).apply{
        setOnItemClickListener { _, _, position ->
            var dict = getItem(position)

            dict?.let {
                var mValue = it.dataValue

                if(mValue.equals(selValue)){
                    selValue = ""
                }else{
                    selValue = mValue
                }

                setCheckSelValue(selValue)
            }
        }
    }

    rv.adapter = mAdapter
    mAdapter.setList(dictList)

    rv.scrollToPosition(mAdapter.getSelectIndex())

    var fl = dialog.getView<FrameLayout>(R.id.fl_dialog_confirm)
    fl.setOnClickListener {
        dialog.dismiss()
        selValue?.let { it1 -> callback.onResult(it1) }
    }

}

interface OnResultCallback<T> {
    fun onResult(t: Any)
}