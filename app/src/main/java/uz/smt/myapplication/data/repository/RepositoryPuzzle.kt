package uz.smt.myapplication.data.repository

import android.content.Context
import uz.smt.myapplication.data.storage.local.LocalStorage

/**
 *  This file is created by Saidmurod Turdiyev SMT for My Application app
 *  2/29/2024  7:51 PM  Asus Rog
 */
class RepositoryPuzzle(private val context: Context) {
    private val storage = LocalStorage(context)

    fun setNameOne(name: String) {
        storage.nameOne = name
    }

    fun setNameSecond(name: String) {
        storage.nameTwo = name
    }

    fun setNameThree(name: String) {
        storage.nameThree = name
    }

    fun setNameFour(name: String) {
        storage.nameFour = name
    }

    fun setNameFive(name: String) {
        storage.nameFive = name
    }

    fun setNameSix(name: String) {
        storage.nameSix = name
    }

    fun setNameSeven(name: String) {
        storage.nameSeven = name
    }

    fun setTimeOne(time: String) {
        storage.nameOne = time
    }

    fun setTimeSecond(time: String) {
        storage.nameTwo = time
    }

    fun setTimeThree(time: String) {
        storage.nameThree = time
    }

    fun setTimeFour(time: String) {
        storage.nameFour = time
    }

    fun setTimeFive(time: String) {
        storage.nameFive = time
    }

    fun setTimeSix(time: String) {
        storage.nameSix = time
    }

    fun setTimeSeven(count: String) {
        storage.countSeven = count
    }
    fun setCountOne(count: String) {
        storage.countOne = count
    }

    fun setCountSecond(count: String) {
        storage.countTwo = count
    }

    fun setCountThree(count: String) {
        storage.countThree = count
    }

    fun setCountFour(count: String) {
        storage.countFour = count
    }

    fun setCountFive(count: String) {
        storage.countFive = count
    }

    fun setCountSix(count: String) {
        storage.countSix = count
    }

    fun setCountSeven(count: String) {
        storage.countSeven = count
    }

    fun getNameOne(): String = storage.nameOne
    fun getNameTwo(): String = storage.nameTwo
    fun getNameThree(): String = storage.nameThree
    fun getNameFour(): String = storage.nameFour
    fun getNameFive(): String = storage.nameFive
    fun getNameSix(): String = storage.nameSix
    fun getNameSeven(): String = storage.nameSeven
    fun getTimeOne(): String = storage.timeOne
    fun getTimeTwo(): String = storage.timeTwo
    fun getTimeThree(): String = storage.timeThree
    fun getTimeFour(): String = storage.timeFour
    fun getTimeFive(): String = storage.timeFive
    fun getTimeSix(): String = storage.timeSix
    fun getTimeSeven(): String = storage.timeSeven
    fun getCountOne(): String = storage.countOne
    fun getCountTwo(): String = storage.countTwo
    fun getCountThree(): String = storage.countThree
    fun getCountFour(): String = storage.countFour
    fun getCountFive(): String = storage.countFive
    fun getCountSix(): String = storage.countSix
    fun getCountSeven(): String = storage.countSeven

    fun getNumbers(): List<Int> {
        val ls = ArrayList<Int>()
        repeat(16) {
            ls.add(it + 1)
        }
        ls[14] = 14
        ls[13] = 16
        ls[15] = 15
        return ls
    }
}