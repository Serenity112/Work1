fun main()
{
    val stringOfAddresses: String =
        "189765, city Moscow, street Korablestroiteley, h. 3" + System.lineSeparator() +
                "123111, city SPB, street Bolshoy, h. 11" + System.lineSeparator() +
                "189765, city Moscow, street Leninsky, h. 2" + System.lineSeparator() +
                "101789, city Chicago, street Cad, h. 67" + System.lineSeparator() +
                "109991, city Omsk, street Teatralnaya, h. 7" + System.lineSeparator() +
                "188646, city New York, street Wim, h. 677"

    val listOfAddresses = parseAddresses(stringOfAddresses)

    println("Addresses:")
    listOfAddresses.forEach { println(it.address) }

    println("\nAddresses with maximum index:")
    val maxIndex = listOfAddresses.maxOfOrNull { it.index }
    listOfAddresses.forEach { if (it.index == maxIndex) println(it.address) }

    println("\nAddress with shortest street name:")
    val shortestStreetLength = listOfAddresses.minOfOrNull { it.street.length }
    listOfAddresses.forEach { if (it.street.length == shortestStreetLength) println(it.address) }

    println("\nAddress with longest street name:")
    val longestStreetLength = listOfAddresses.maxOfOrNull { it.street.length }
    listOfAddresses.forEach { if (it.street.length == longestStreetLength) print(it.address) }
}

fun parseAddresses(stringOfAddresses: String): List<Address>
{
    val addressesList = mutableListOf<Address>()

    val particularAddresses = stringOfAddresses.split(System.lineSeparator()).toTypedArray()

    for (particularAddress: String in particularAddresses)
    {
        val addressData = particularAddress.split(',').toTypedArray()

        val index: Int = addressData[0].toInt()

        val city: String = addressData[1]
            .replace("city", "")
            .trimStart()

        val street: String = addressData[2]
            .replace("street", "")
            .trimStart()

        val house: Int = addressData[3]
            .replace("h.", "")
            .trimStart()
            .toInt()

        addressesList.add(Address(index, city, street, house))

    }
    return addressesList
}