package scalaz

trait OrderLike[F] extends EqualLike[F] { self =>
  ////
  // TODO
//  def order(a1: F, a2: F): Ordering
//
//  final def equal(a1: F, a2: F): Boolean = order(a1, a2) == EQ

  // derived functions

  ////
  val orderSyntax = new scalaz.syntax.OrderSyntax[F] {}
}

////
/**
 *
 */
////
trait Order[F] extends OrderLike[F] {
  self : EqualInstance[F] =>

  implicit val orderParents: EqualInstance[F] = this
}

object Order {
  def apply[F](implicit F: Order[F]): Order[F] = F

  ////

  ////
}

trait OrderInstance[F] extends Order[F] with EqualInstance[F]
