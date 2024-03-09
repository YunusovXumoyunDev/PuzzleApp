package uz.smt.myapplication.presenter

import uz.smt.myapplication.data.model.LocalData
import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.screen.MainScreen

class MainPresenter(
    private val view: MainScreen,
    private val repository: RepositoryPuzzle
) {
    private val ls: List<LocalData> = repository.getButtonId()
    init {
        loadUi()
    }

    private fun loadUi() {
        view.setFirstBtn(ls[0])
        view.setSecondBtn(ls[1])
        view.setThirdBtn(ls[2])
    }
    fun clickFirstBtn() {
        view.openPuzzleScreen3x3()
    }

    fun clickSecondBtn() {
        view.openPuzzleScreen4x4()
    }

    fun clickThirdBtn() {
        view.openPuzzleScreen5x5()
    }
}