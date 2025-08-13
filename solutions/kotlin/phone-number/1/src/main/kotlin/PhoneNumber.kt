class PhoneNumber(input: String) {
    val number: String?
    init {
        val cleaned = input.replace("[^0-9]".toRegex(), "")
        if (cleaned.length == 10) {
            number = cleaned
        } else if (cleaned.length == 11 && cleaned.startsWith("1")) {
            number = cleaned.substring(1)
        } else {
            throw IllegalArgumentException("Invalid phone number")
        }
        validatePhoneNumber(number)
    }
    private fun validatePhoneNumber(phone: String) {
        val areaCode = phone.substring(0, 3)
        if (areaCode[0] == '0' || areaCode[0] == '1') {
            throw IllegalArgumentException("Invalid area code")
        }
        val exchangeCode = phone.substring(3, 6)
        if (exchangeCode[0] == '0' || exchangeCode[0] == '1') {
            throw IllegalArgumentException("Invalid exchange code")
        }
    }
}