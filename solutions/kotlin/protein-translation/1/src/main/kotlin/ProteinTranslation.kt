fun translate(rna: String?): List<String> {
    if (rna.isNullOrEmpty()) return emptyList() // Trường hợp đầu vào null hoặc rỗng

    // Map ánh xạ từ codon sang protein
    val codonToProtein = mapOf(
        "AUG" to "Methionine",
        "UUU" to "Phenylalanine", "UUC" to "Phenylalanine",
        "UUA" to "Leucine", "UUG" to "Leucine",
        "UCU" to "Serine", "UCC" to "Serine", "UCA" to "Serine", "UCG" to "Serine",
        "UAU" to "Tyrosine", "UAC" to "Tyrosine",
        "UGU" to "Cysteine", "UGC" to "Cysteine",
        "UGG" to "Tryptophan",
        "UAA" to "STOP", "UAG" to "STOP", "UGA" to "STOP"
    )

    val proteins = mutableListOf<String>()

    // Duyệt qua chuỗi theo từng cụm 3 ký tự (1 codon)
    for (i in rna.indices step 3) {
        if (i + 3 > rna.length) {
            throw IllegalArgumentException("Invalid codon") // Không đủ 3 ký tự cho 1 codon
        }

        val codon = rna.substring(i, i + 3)
        val protein = codonToProtein[codon]

        when {
            protein == null -> throw IllegalArgumentException("Invalid codon") // Codon không hợp lệ
            protein == "STOP" -> break // Gặp STOP thì dừng
            else -> proteins.add(protein) // Thêm protein vào danh sách kết quả
        }
    }

    return proteins
}
