package uz.smt.myapplication.data.repository

import android.content.Context
import uz.smt.myapplication.data.storage.local.LocalStorage
import uz.smt.myapplication.data.model.LocalData
import uz.smt.myapplication.data.model.RecordData

/**
 *  This file is created by Saidmurod Turdiyev SMT for My Application app
 *  2/29/2024  7:51 PM  Asus Rog
 */
class RepositoryPuzzle(private val context: Context) {
    private val storage = LocalStorage(context)
    private var ls = ArrayList<LocalData>()

    fun setRecord1(user: String, time: Long, count: Int) {
        storage.record1 = RecordData(user = user, time = time, count = count)
    }

    fun setRecord2(user: String, time: Long, count: Int) {
        storage.record2 = RecordData(user = user, time = time, count = count)
    }

    fun setRecord3(user: String, time: Long, count: Int) {
        storage.record3 = RecordData(user = user, time = time, count = count)
    }

    fun setRecord4(user: String, time: Long, count: Int) {
        storage.record4 = RecordData(user = user, time = time, count = count)
    }

    fun getRecord1(): RecordData {
        return storage.record1
    }

    fun getRecord2(): RecordData {
        return storage.record2
    }

    fun getRecord3(): RecordData {
        return storage.record3
    }

    fun getRecord4(): RecordData {
        return storage.record4
    }

    fun getNumbers(): List<Int> {
        val ls = ArrayList<Int>()
//        repeat(15) {
//            ls.add(it + 1)
//        }
//        ls.shuffle()
//        ls.add(16)
//tekshirish uchun
        repeat(16) {
            ls.add(it + 1)
        }
        ls[12] = 16
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
        ls.shuffle()
        return ls

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