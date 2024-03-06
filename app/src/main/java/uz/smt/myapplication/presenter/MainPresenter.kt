package uz.smt.myapplication.presenter

import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.screen.MainScreen

class MainPresenter(
    private val view: MainScreen,
    private val repository: RepositoryPuzzle
) {
    fun firstBtnClick(){
        view.firstBtn()
    }
    fun secondBtnClick(){
        view.secondBtn()
    }
    fun thirdBtnClick(){
        view.thirdBtn()
    }
}