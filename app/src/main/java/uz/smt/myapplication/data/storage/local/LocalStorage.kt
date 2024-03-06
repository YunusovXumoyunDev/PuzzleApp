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
    var nameFive by StringDelegation(pref, "")
    var nameSix by StringDelegation(pref, "")
    var nameSeven by StringDelegation(pref, "")
    var countOne by StringDelegation(pref, "")
    var countTwo by StringDelegation(pref, "")
    var countThree by StringDelegation(pref, "")
    var countFour by StringDelegation(pref, "")
    var countFive by StringDelegation(pref, "")
    var countSix by StringDelegation(pref, "")
    var countSeven by StringDelegation(pref, "")
    var timeOne by StringDelegation(pref, "")
    var timeTwo by StringDelegation(pref, "")
    var timeThree by StringDelegation(pref, "")
    var timeFour by StringDelegation(pref, "")
    var timeFive by StringDelegation(pref, "")
    var timeSix by StringDelegation(pref, "")
    var timeSeven by StringDelegation(pref, "")
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