def maxValue(weights, values, weightLimit):
    itemsCount = len(weights)
    maxValues = [
            [ 0 for _ in range(weightLimit + 1) ]
            for _ in range(itemsCount + 1)
            ]
    for i in range(1, itemsCount + 1):
        w, v = weights[i-1], values[i-1]
        for j in range(1, weightLimit + 1):
            if w <= j:
                maxValues[i][j] = max(
                        maxValues[i-1][j],
                        maxValues[i-1][j-w] + v
                        )
            else:
                maxValues[i][j] = maxValues[i-1][j]

    return maxValues[-1][-1]

assert maxValue([], [], 10) == 0
assert maxValue([1], [3], 10) == 3
assert maxValue([11], [3], 10) == 0
assert maxValue([8, 7], [2, 4], 10) == 4
assert maxValue([5, 4], [2, 4], 10) == 6
assert maxValue([5, 4, 2, 1], [2, 4, 7, 1], 10) == 12
