fun strCalculate(x0: String, x1: String): Int {
    var result = 0
    

    for (i in x0.indices) {
        if ((x0[i] == 'T' || x0[i] == 'C') && x0[i] == x1[i]) {
            continue
        } else if ((x0[i] == 'T' || x0[i] == 'C') && x0[i] != x1[i]) {
            if (i >= x0.length / 2) {
                result += 2
            } else {
                result += 1
            }
        }
    }
    
    return result
}