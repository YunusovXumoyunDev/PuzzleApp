package uz.smt.myapplication.data.storage.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *  This file is created by Saidmurod Turdiyev SMT for My Application app
 *  3/5/2024  7:35 PM  Asus Rog
 */
class LocalStorage(context: Context) {

    private val pref = context.getSharedPreferences("local_storadge", Context.MODE_PRIVATE)
    var nameOne by StringDelegation(pref, "")
    var nameTwo by StringDelegation(pref, "")
    var nameThree by StringDelegation(pref, "")
    var nameFour by StringDelegation(pref, "")
    var countOne by StringDelegation(pref, "0")
    var countTwo by StringDelegation(pref, "0")
    var countThree by StringDelegation(pref, "0")
    var countFour by StringDelegation(pref, "0")
    var timeOne by StringDelegation(pref, "")
    var timeTwo by StringDelegation(pref, "")
    var timeThree by StringDelegation(pref, "")
    var timeFour by StringDelegation(pref, "")
}

class StringDelegation(private val pref: SharedPreferences, private val defValue: String) :
    ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String =
        pref.getString(property.name, defValue) ?: ""

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) =
        pref.edit {
            putString(property.name, value).apply()
        }
}