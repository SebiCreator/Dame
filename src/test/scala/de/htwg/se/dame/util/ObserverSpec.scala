package de.htwg.se.dame.util

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import de.htwg.se.dame.util.Observable

class ObserverSpec extends AnyWordSpec {
  "an Observable" when {
    "a new Observer is added " should {
      var updated = false
      val observer = new Observable {}
      val observer2 = new Observer {
        override def update: Unit = updated = true
      }
      observer.add(observer2)

      "have a subscriber" in {
        observer.subscribers.contains(observer2) should be(true)
      }
      "have the subscriber removed" in {
        observer.remove(observer2)
        observer.subscribers.contains(observer2) should be(false)
      }
      "have a function to notify each observer" in {
        observer.add(observer2)
        observer.notifyObservers
        updated should be(true)
      }

      "an observer" should {
        "have a function to update a change" in {
          updated = false
          observer2.update
          updated should be(true)
        }
      }
    }
  }
}
