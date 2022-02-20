Item 3. 최대한 플랫폼타입을 사용하지 말라.
====
> 플랫폼 타입(Platform Type): 다른 프로그래밍 언어에서 와서 nullable 여부를 알 수 없는 타입을 지칭

> JSR 305: 소프트웨어 결함 감지를 위한 애노테이션
> 
> - JSR-305 at DZone: [https://dzone.com/articles/when-to-use-jsr-305-for-nullability-in-java](https://dzone.com/articles/when-to-use-jsr-305-for-nullability-in-java)
> - JSR 305: [https://jcp.org/en/jsr/detail?id=305](https://jcp.org/en/jsr/detail?id=305)

# 정리
* 플랫폼 타입을 사용하는 코드는 해당 부분만 위험할 뿐만 아니라, 이를 활용하는 곳까지 영향을 줄 수 있는 위험한 코드다.
* 이런 코드를 사용하고 있다면 해당 코드를 **빨리 해당 코드를 제거하는 것이 좋다.**
* 연결되어 있는 자바생성자, 메서드, 필드에 nullable 여부를 지정하는 어노테이션을 활용하는 것도 좋다.

# Tip: `NoClassDefFoundError` 발생시
Kotlin 컴파일경로에 Java 코드가 있는 경우 `NoClassDefFoundError` 예외가 터진다.
자바 파일을 `src/main/kotlin` 내에 생성하면 정상적으로 파일을 찾지 못한다.

```
Exception in thread "main" java.lang.NoClassDefFoundError: io/honeymon/boot/effectivekotlin/item3/JavaClass
	at io.honeymon.boot.effectivekotlin.item3.Item3Kt.platformType(Item3.kt:9)
	at io.honeymon.boot.effectivekotlin.item3.Item3Kt.main(Item3.kt:15)
	at io.honeymon.boot.effectivekotlin.item3.Item3Kt.main(Item3.kt)
Caused by: java.lang.ClassNotFoundException: io.honeymon.boot.effectivekotlin.item3.JavaClass
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	... 3 more
```

## 해결책
* `src/main/java` 하위 패키지로 이동한다. 

## 추가정보 
코틀린에서는 코드 소스셋 경로를 구분짓고 있다.

- Java: Project: src/main/java
- Kotlin: Project: src/main/kotlin

[Gradle | Kotlin](https://kotlinlang.org/docs/gradle.html#kotlin-and-java-sources)

혹은 [gradle.build](http://gradle.build) 에서 `sourceSets` 를 명시적으로 선언하여 기본구성을 무시할 수 있다.

```
sourceSets.main {
    java.srcDirs("src/main/myJava", "src/main/myKotlin")
}
```

`compileJava` 와 `compileKotlin` 이 바라보고 있는 위치가 서로 다르기 때문이겠군.

# 참고
* [https://fishpgrm.tistory.com/47](Effective Kotlin 번역 - Item 3: Eliminate platform types as soon as possible)
