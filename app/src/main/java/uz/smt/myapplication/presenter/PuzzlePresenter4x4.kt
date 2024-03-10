package uz.smt.myapplication.presenter

import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.screen.PuzzleScreen4x4

/**
 *  This file is created by Saidmurod Turdiyev SMT for My Application app
 *  2/29/2024  7:53 PM  Asus Rog
 */
class PuzzlePresenter4x4(
    private val repository: RepositoryPuzzle,
    private val view: PuzzleScreen4x4
) {
    private val numbers = ArrayList(repository.getNumbers())
    private var hideIndex = 0
    private var countStep = 0
    private var count: Int? = null

    init {

        numbers.forEachIndexed { index, i ->
            if (i == 16)
                hideIndex = index
        }
        view.loadButtons(numbers)
    }

    fun clickRestart() {
        val numbers = ArrayList(repository.getNumbers())
        numbers.forEachIndexed { index, i ->
            if (i == 16)
                hideIndex = index
        }
        view.loadButtons(numbers)
    }

    fun click(index: Int) {
        if (checkCanReplace(index)) {
            if (countStep == 0)
                view.startTimer()
            countStep++
            view.hideVisible(index)
            view.setText(numbers[index], hideIndex)
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
        return hideIndex - 4 == index || hideIndex + 4 == index || hideIndex - 1 == index || hideIndex + 1 == index
    }


    private fun replace(fromIndex: Int) {
        val t = numbers[fromIndex]
        numbers[fromIndex] = numbers[hideIndex]
        numbers[hideIndex] = t
        hideIndex = fromIndex
    }

    private fun checkIsSuccess(): Boolean {
        var cond = true
        numbers.forEachIndexed { index, i ->
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
