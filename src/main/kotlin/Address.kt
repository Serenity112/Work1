data class Address(val index: Int, val city: String, val street: String, val house: Int)
{
    val address: String
        get() = "$index, city: $city, street: $street, house: $house"
}