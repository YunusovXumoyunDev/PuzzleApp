package uz.smt.myapplication.presenter

import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.screen.RecordScreen
import uz.smt.myapplication.screen.ResultScreen

class ResultPresenter(
    private val view: ResultScreen,
    private val repository: RepositoryPuzzle
) {
    init {
        maximum()
    }

    fun clickOK() {
        view.openRecord()
    }

    fun clickCANCEL() {
        view.backToPuzzle()
    }

    private fun maximum() {
        val numbers = listOf(
            view.getCount(),
            repository.getCountOne().toInt(),
            repository.getCountTwo().toInt(),
            repository.getCountThree().toInt(),
            repository.getCountFour().toInt(),
        )
        val sortedNumbers = numbers.sortedWith(compareByDescending { it })
        repository.setCountOne(sortedNumbers[3].toString())
        repository.setCountSecond(sortedNumbers[2].toString())
        repository.setCountThree(sortedNumbers[1].toString())
        repository.setCountFour(sortedNumbers[0].toString())
    }
}


