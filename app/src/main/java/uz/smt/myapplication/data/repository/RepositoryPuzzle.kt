package uz.smt.myapplication.data.repository

import android.content.Context
import uz.smt.myapplication.data.model.LocalData
import uz.smt.myapplication.data.storage.local.LocalStorage

/**
 *  This file is created by Saidmurod Turdiyev SMT for My Application app
 *  2/29/2024  7:51 PM  Asus Rog
 */
class RepositoryPuzzle(private val context: Context) {
    private val storage = LocalStorage(context)
    private var ls = ArrayList<LocalData>()

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


    fun getNameOne(): String = storage.nameOne
    fun getNameTwo(): String = storage.nameTwo
    fun getNameThree(): String = storage.nameThree
    fun getNameFour(): String = storage.nameFour

    fun getTimeOne(): String = storage.timeOne
    fun getTimeTwo(): String = storage.timeTwo
    fun getTimeThree(): String = storage.timeThree
    fun getTimeFour(): String = storage.timeFour

    fun getCountOne(): String = storage.countOne
    fun getCountTwo(): String = storage.countTwo
    fun getCountThree(): String = storage.countThree
    fun getCountFour(): String = storage.countFour


    fun getNumbers(): List<Int> {
        val ls = ArrayList<Int>()
        repeat(16) {
            ls.add(it + 1)
        }
        ls[12]=16
        ls[14] = 14
        ls[13] = 13
        ls[15] = 15
        return ls

    }
    fun getNumbers2(): List<Int> {
        val ls = ArrayList<Int>()
        repeat(9) {
            ls.add(it + 1)
        }
        return ls.shuffled()

    }

    fun getButtonId(): List<LocalData> {
        return ls
    }

    fun getPuzzleById(id: Int): LocalData? {
        val data = ls.find { item ->
            item.id == id
        }
        return data
    }

    init {
        loadList()
    }

    fun loadList() {
        addPerson(
            LocalData(
                id = 0,
                txt = "3x3"
            )
        )
        addPerson(
            LocalData(
                id = 1,
                txt = "4x4"
            )
        )
        addPerson(
            LocalData(
                id = 2,
                txt = "5x5"
            )
        )
    }

    private fun addPerson(data: LocalData) {
        ls.add(data)
    }
}