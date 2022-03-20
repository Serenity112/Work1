class Address(private val index: Int, private val city: String, private val street: String, private val house: Int)
{
    fun printAddress()
    {
        print("Index: $index, city: $city, street: $street, house: $house\n")
    }
}