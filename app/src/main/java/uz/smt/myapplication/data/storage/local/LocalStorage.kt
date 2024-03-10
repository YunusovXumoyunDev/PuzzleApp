package uz.smt.myapplication.data.storage.local

import android.content.Context
import android.content.SharedPreferences
import uz.smt.myapplication.data.model.RecordData
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *  This file is created by Saidmurod Turdiyev SMT for My Contact app
 *  3/9/2024  8:09 PM  Asus Rog
 */
class LocalStorage(private val context: Context) {
    val pref=context.getSharedPreferences("local-storage",Context.MODE_PRIVATE)
    var record1 by RecordDataDelegation(pref)
    var record2 by RecordDataDelegation(pref)
    var record3 by RecordDataDelegation(pref)
    var record4 by RecordDataDelegation(pref)
}
//fun check(context: Context,data: RecordData){
//    var obj=LocalStorage(context)
//    if (obj.record1.time>data.time){
//        obj.record1=RecordData("User 1",100L,13)
//    }
//}
class RecordDataDelegation(private val pref:SharedPreferences):ReadWriteProperty<Any, RecordData>{
    override fun getValue(thisRef: Any, property: KProperty<*>): RecordData {
        val userName=pref.getString("${property.name} username","")?:""
        val recordCount= pref.getInt("${property.name} count",-1)
        val recordTime=pref.getLong("${property.name} time",-1)
        return RecordData(user = userName, time = recordTime, count = recordCount)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: RecordData) {
        pref.edit().apply {
            putString("${property.name} username",value.user)
            putLong("${property.name} time",value.time)
            putInt("${property.name} count",value.count)
            apply()
        }
    }
}