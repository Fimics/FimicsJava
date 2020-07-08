package data.structure.queue

fun main(args: Array<String>) {
    test2()
    test3()

//		int n = 13;
//		int m = 7;
//
////		if (n >= m) {
////			System.out.println(n - m);
////		} else {
////			System.out.println(n);
////		}
//
//		// m > 0, n >= 0, n < 2m
//		System.out.println(n - (n >= m ? m : 0));
//
//		System.out.println(n % m);
}

fun test1() {
    val queue = Queue<Int>()
    queue.enQueue(11)
    queue.enQueue(22)
    queue.enQueue(33)
    queue.enQueue(44)
    while (!queue.isEmpty) {
        println(queue.deQueue())
    }

//		Deque<Integer> queue = new Deque<>();
//		queue.enQueueFront(11);
//		queue.enQueueFront(22);
//		queue.enQueueRear(33);
//		queue.enQueueRear(44);
//		
//		/* 尾  44  33   11  22 头 */
//		
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueueRear());
//		}
}

fun test2() {
    val queue = CircleQueue<Int>()
    // 0 1 2 3 4 5 6 7 8 9
    for (i in 0..9) {
        queue.enQueue(i)
    }
    // null null null null null 5 6 7 8 9
    for (i in 0..4) {
        queue.deQueue()
    }
    // 15 16 17 18 19 5 6 7 8 9
    for (i in 15..19) {
        queue.enQueue(i)
    }
    while (!queue.isEmpty) {
        println(queue.deQueue())
    }
    println(queue)
}

fun test3() {
    val queue = CircleDeque<Int>()
    // 头5 4 3 2 1  100 101 102 103 104 105 106 8 7 6 尾

    // 头 8 7 6  5 4 3 2 1  100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
    for (i in 0..9) {
        queue.enQueueFront(i + 1)
        queue.enQueueRear(i + 100)
    }

    // 头 null 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null null 尾
    for (i in 0..2) {
        queue.deQueueFront()
        queue.deQueueRear()
    }

    // 头 11 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null 12 尾
    queue.enQueueFront(11)
    queue.enQueueFront(12)
    println(queue)
    while (!queue.isEmpty) {
        println(queue.deQueueFront())
    }
}

