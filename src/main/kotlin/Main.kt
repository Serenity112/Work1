fun main()
{
    val stringOfAddresses: String =
        "123456, city Moscow, street Korablestroiteley, h. 3" + System.lineSeparator() +
                "123111, city SPB, street Bolshoy, h. 11" + System.lineSeparator() +
                "189765, city Moscow, street Leninsky, h. 2" + System.lineSeparator() +
                "111234, city Chicago, street Johnson, h. 67"

    val listOfAddresses = parseAddresses(stringOfAddresses)

    println("Addresses:")
    listOfAddresses.forEach { it.printAddress() }
}

fun parseAddresses(stringOfAddresses: String): List<Address>
{
    val addressesList = mutableListOf<Address>()

    val particularAddresses = stringOfAddresses.split('\n').toTypedArray()

    for (particularAddress: String in particularAddresses)
    {
        val addressData = particularAddress.split(',').toTypedArray()

        val index: Int = addressData[0].toInt()

        val city: String = addressData[1]
            .replace("city", "")
            .filter { !it.isWhitespace() }

        val street: String = addressData[2]
            .replace("street", "")
            .filter { !it.isWhitespace() }

        val house: Int = addressData[3]
            .replace("h.", "")
            .filter { !it.isWhitespace() }
            .toInt()

        addressesList.add(Address(index, city, street, house))

    }
    return addressesList
}