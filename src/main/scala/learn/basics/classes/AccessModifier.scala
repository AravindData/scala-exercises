package classes

class AccessModifier {

  private var _x = 1
  private var _y = 0
  private val bound = 100

  // getter
  def x = _x

  // setter
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")

}
