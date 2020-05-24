def buildCodonLocations(sequence):
    codonLocations = {}
    for i in range(0, len(sequence), 3):
        codon = sequence[i:i+3]
        if codon not in codonLocations:
            codonLocations[codon] = []
        codonLocations[codon].append(i)
    return codonLocations

codonListFile = open("codonlist.txt", "r")
codonList = codonListFile.read().split()
filename = "SARSCoV2-S-gene-WH.txt"
file = open(filename, mode='r')
sequence = file.read()
codonLocations = buildCodonLocations(sequence)
print("Number of different codons following each codon")
for codon1 in codonList:
    print(codon1, ":", sep="", end=" ")
    followingCodons = {}
    if codon1 not in codonLocations:
        print("Does not occur in the sequence")
    else:
        for i in codonLocations[codon1]:
            nextCodon = sequence[i+3:i+6]
            followingCodons[nextCodon] = True
        print(len(followingCodons))

