package uz.smt.myapplication.presenter

import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.screen.PuzzleScreen3x3

/**
 *  This file is created by Saidmurod Turdiyev SMT for My Application app
 *  2/29/2024  7:53 PM  Asus Rog
 */
class PuzzlePresenter3x3(
    private val repository: RepositoryPuzzle,
    private val view: PuzzleScreen3x3
) {
    private val numbers2 = ArrayList(repository.getNumbers2())
    private var hideIndex = 0
    private var countStep = 0
    private var count: Int? = null

    init {

        numbers2.forEachIndexed { index, i ->
            if (i == 9)
                hideIndex = index
        }
        view.loadButtons(numbers2)
    }

    fun clickRestart() {
        view.loadButtons(numbers2)
    }

    fun click(index: Int) {
        if (checkCanReplace(index)) {
            if (countStep == 0)
                view.startTimer()
            countStep++
            view.hideVisible(index)
            view.setText(numbers2[index], hideIndex)
            replace(index)
            if (checkIsSuccess()) {
                view.stopTimer()
                count = countStep
            } else {
                view.loadCount(countStep)
            }
        }
    }


    private fun checkCanReplace(index: Int): Boolean {
        return hideIndex - 3 == index || hideIndex + 3 == index || hideIndex - 1 == index || hideIndex + 1 == index
    }


    private fun replace(fromIndex: Int) {
        val t = numbers2[fromIndex]
        numbers2[fromIndex] = numbers2[hideIndex]
        numbers2[hideIndex] = t
        hideIndex = fromIndex
    }

    private fun checkIsSuccess(): Boolean {
        var cond = true
        numbers2.forEachIndexed { index, i ->
            if (index + 1 != i) {
                cond = false
            }
        }
        return cond
    }


    fun getCount(): Int? {
        return count
    }

    fun clickBack() {
        view.clickBack()
    }
}
