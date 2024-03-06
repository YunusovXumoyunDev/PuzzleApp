package uz.smt.myapplication.presenter

import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.screen.ResultScreen

class ResultPresenter(
    private val view: ResultScreen,
    private val repository: RepositoryPuzzle
) {
}