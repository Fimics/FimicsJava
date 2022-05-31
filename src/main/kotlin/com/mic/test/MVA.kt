package com.mic.test

import kotlin.properties.Delegates

//93 %处 TODO
/**
 * github
 * https://github.com/ReKotlin/ReKotlin
 */

fun main() {

    val view = View()
    val action = AddTodoAction("resume", "resume");
    view.onClick(action)

    val store = Store()
    store.dispatch(action)

}

class View{
    fun onClick(addTodoAction: AddTodoAction){
    }
}

//Action  包含要传递给Store的信息，表明我们希望怎样改变应用的状态
data class AddTodoAction(val title: String, val content: String)

// Store(对应module)：保存应用的状态并提供方法来存取对应的状态，分发状态，并注册监听。
class Store {
    var reducers by Delegates.notNull<Reducers>()

    init {
        reducers = Reducers()
    }

    fun dispatch(addTodoAction: AddTodoAction) {
        reducers.reduce(AppState.STOP, addTodoAction)
    }
}

//·Reducers：Store收到Action以后，必须给出一个新的State，这样View才会发生变化。这种State的计算过程就叫作Reducer
class Reducers {
    fun reduce(oldState: AppState, action: AddTodoAction): AppState {
        println("action.content ${action.content}")
        return when (action.content) {
            "create" -> return AppState.CREATE
            "resume" -> return AppState.RESUME
            "stop" -> return AppState.STOP
            else -> return AppState.STOP
        }
    }
}

enum class AppState(val life: String) {
    CREATE("create"), RESUME("resume"), STOP("stop")
}