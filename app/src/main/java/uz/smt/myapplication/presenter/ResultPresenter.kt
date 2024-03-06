package uz.smt.myapplication.presenter

import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.screen.RecordScreen
import uz.smt.myapplication.screen.ResultScreen

class ResultPresenter(
    private val view: ResultScreen,
    private val repository: RepositoryPuzzle
) {
    private fun checkRecord(){
        if (
            view.getTime().toInt()>repository.getTimeOne().toInt()&&
            view.getTime().toInt()>repository.getTimeTwo().toInt()&&
            view.getTime().toInt()>repository.getTimeThree().toInt()&&
            view.getTime().toInt()>repository.getTimeFour().toInt()&&
            view.getCount().toInt()>repository.getCountOne().toInt()&&
            view.getCount().toInt()>repository.getCountTwo().toInt()&&
            view.getCount().toInt()>repository.getCountThree().toInt()&&
            view.getCount().toInt()>repository.getCountFour().toInt()
        ){

        }
    }
    fun clickOK(){
        view.openRecord()
    }
    fun clickCANCEL(){
        view.backToPuzzle()
    }
}