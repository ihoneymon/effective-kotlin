package io.honeymon.boot.effectivekotlin.item3

class UserRepoImpl: UserRepo {
    override fun getUserName(): String? {
        return null
    }
}

fun statedType() {
    val value: String = JavaClass().value
    println(value.length)
}

/**
 * 플랫폼타입: 다른 프로그래밍 언어에서 와서 nullable 여부를 알 수 없는 타입을 플랫폼 타입이라고 한다.
 */
fun platformType() {
    val value = JavaClass().value
    println(value.length)
}

fun main() {
//    statedType()
//    platformType()

    val repo: UserRepo = UserRepoImpl()
    val text: String = repo.getUserName() // 런타임 때 NPE, null 이 아닐 것이라 판단
    println("User name length is: ${text.length}")
}