package data.structure.binarytree


fun main(){

}

private class Node<E> constructor(var element: E,var parent:Node<E>){
    lateinit var left:Node<E>
    lateinit var right:Node<E>


    constructor(element: E,parent:Node<E>,left:Node<E>,right:Node<E>):this(element,parent){
        this.left=left
        this.right=right
    }
}