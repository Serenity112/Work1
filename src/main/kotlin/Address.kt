class Address(val index: Int, val city: String, val street: String, val house: Int)
{
    fun printAddress()
    {
        print("Address has Index: $index, city: $city, street: $street, house: $house\n")
    }
}