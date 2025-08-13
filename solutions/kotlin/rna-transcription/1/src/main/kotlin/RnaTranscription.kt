fun transcribeToRna(dna: String): String {
    return dna.replace('A', 'U')
    .replace('T', 'A')
    .replace('C', 'M')
    .replace('G', 'C')
    .replace('M', 'G')
}
