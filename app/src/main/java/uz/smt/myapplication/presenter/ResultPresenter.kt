package uz.smt.myapplication.presenter

import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.screen.RecordScreen
import uz.smt.myapplication.screen.ResultScreen

class ResultPresenter(
    private val view: ResultScreen,
    private val repository: RepositoryPuzzle
) {
    init {
        check()
    }

    fun clickOK() {
        view.openRecord()
    }

    fun clickCANCEL() {
        view.backToPuzzle()
    }

    private fun check() {
        if (
            view.getCount() > repository.getRecord1().count &&
            view.getCount() > repository.getRecord2().count &&
            view.getCount() > repository.getRecord3().count &&
            view.getCount() > repository.getRecord4().count
        ) {
            repository.setRecord1(
                user = view.getName(),
                time = view.getTime(),
                count = view.getCount()
            )
            repository.setRecord2(
                user = repository.getRecord1().user,
                time = repository.getRecord1().time,
                count = repository.getRecord1().count
            )
            repository.setRecord3(
                user = repository.getRecord2().user,
                time = repository.getRecord2().time,
                count = repository.getRecord2().count
            )
            repository.setRecord4(
                user = repository.getRecord3().user,
                time = repository.getRecord3().time,
                count = repository.getRecord3().count
            )
        } else if (
            view.getCount() < repository.getRecord1().count &&
            view.getCount() > repository.getRecord2().count &&
            view.getCount() > repository.getRecord3().count &&
            view.getCount() > repository.getRecord4().count
        ) {
            repository.setRecord2(
                user = view.getName(),
                time = view.getTime(),
                count = view.getCount()
            )
            repository.setRecord3(
                user = repository.getRecord2().user,
                time = repository.getRecord2().time,
                count = repository.getRecord2().count
            )
            repository.setRecord4(
                user = repository.getRecord3().user,
                time = repository.getRecord3().time,
                count = repository.getRecord3().count
            )
        } else if (
            view.getCount() < repository.getRecord1().count &&
            view.getCount() < repository.getRecord2().count &&
            view.getCount() > repository.getRecord3().count &&
            view.getCount() > repository.getRecord4().count
        ) {
            repository.setRecord3(
                user = view.getName(),
                time = view.getTime(),
                count = view.getCount()
            )
            repository.setRecord4(
                user = repository.getRecord3().user,
                time = repository.getRecord3().time,
                count = repository.getRecord3().count
            )
        } else if (
            view.getCount() < repository.getRecord1().count &&
            view.getCount() < repository.getRecord2().count &&
            view.getCount() < repository.getRecord3().count &&
            view.getCount() > repository.getRecord4().count
        ) {
            repository.setRecord4(
                user = view.getName(),
                time = view.getTime(),
                count = view.getCount()
            )
        }
    }
}


