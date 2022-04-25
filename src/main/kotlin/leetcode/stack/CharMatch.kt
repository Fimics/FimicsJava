package leetcode.stack

import java.util.*

/**
 * 检查括号是否匹配
 */
class CharMatch {
    companion object {
        private val map = HashMap<Char, Char?>()
        init {
            // key - value
            map['('] = ')'
            map['{'] = '}'
            map['['] = ']'
        }
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val len = s.length
        for (i in 0 until len) {
            val c = s[i]
            if (map.containsKey(c)) { // 左括号
                stack.push(c)
            } else { // 右括号
                if (stack.isEmpty()) return false
                if (c != map[stack.pop()]) return false
            }
        }
        return stack.isEmpty()
    }

    fun isValid1(s: String): Boolean {
        val stack = Stack<Char>()
        val len = s.length
        for (i in 0 until len) {
            val c = s[i]
            if (c == '(' || c == '{' || c == '[') { // 左括号
                stack.push(c)
            } else { // 右括号
                if (stack.isEmpty()) return false
                val left = stack.pop()
                if (left == '(' && c != ')') return false
                if (left == '{' && c != '}') return false
                if (left == '[' && c != ']') return false
            }
        }
        return stack.isEmpty()
    }

    fun isValid2(s: String): Boolean {
        var s = s
        while (s.contains("{}")
                || s.contains("[]")
                || s.contains("()")) {
            s = s.replace("{}", "")
            s = s.replace("()", "")
            s = s.replace("[]", "")
        }
        return s.isEmpty()
    }
}