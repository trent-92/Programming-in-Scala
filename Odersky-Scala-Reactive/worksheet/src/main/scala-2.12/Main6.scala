import rx.lang.scala.subjects.{BehaviorSubject, PublishSubject}

/**
  * Created by Minsik on 2017-05-12.
  */
object Main6 extends App {

  override def main(args: Array[String]): Unit = {
    val channel = BehaviorSubject[Int]()

    val a = channel.subscribe(x => println(s"a: $x"))
    val b = channel.subscribe(x => println(s"b: $x"))

    channel.onNext(42)

    a.unsubscribe()

    channel.onNext(4902)

    channel.onCompleted()

    val c = channel.subscribe(x => println(s"c: $x"))
    channel.onNext(1)
  }
}
