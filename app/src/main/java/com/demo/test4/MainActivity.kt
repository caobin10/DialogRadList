package com.demo.test4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.test3.util.OnResultCallback
import com.demo.test3.util.showBottomRadListDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: MutableList<Dict> = ArrayList()
    private var x :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1.text = "宿舍";tv2.text = "小红"
        initDatas()
        ll.setOnClickListener {
            for (i in 0 until list.size) {
                if (tv2.text == list[i].dataName){
                    x = i;
                    break
                }
            }
            showBottomRadListDialog(tv1.text.toString(), list[x].dataValue, list as List<Dict>, object : OnResultCallback<String> {
                override fun onResult(t: Any) {
                    var dataValue :String = t.toString()
                    for (i in 0 until list.size){
                        if (dataValue == list[i].dataValue){
                            tv2.text = list[i].dataName
                            break
                        }
                    }
                }
            })
        }
    }

    private fun initDatas() {
        var sc = Dict("1", "4", "宿舍", "小红", "1");list.add(sc)
        sc = Dict("2", "4", "宿舍", "小彬", "2");list.add(sc)
        sc = Dict("3", "4", "宿舍", "小强", "3");list.add(sc)
        sc = Dict("4", "4", "宿舍", "小华", "4");list.add(sc)
        sc = Dict("5", "4", "宿舍", "小军", "5");list.add(sc)
        sc = Dict("6", "4", "宿舍", "小文", "6");list.add(sc)
        sc = Dict("7", "4", "宿舍", "小可", "7");list.add(sc)
        sc = Dict("8", "4", "宿舍", "小进", "8");list.add(sc)
        sc = Dict("9", "4", "宿舍", "小明", "9");list.add(sc)
        sc = Dict("10", "4", "宿舍", "小一", "10");list.add(sc)
        sc = Dict("11", "4", "宿舍", "小乐", "11");list.add(sc)

    }
}