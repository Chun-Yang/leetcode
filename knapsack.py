def knapsack(weights, values, weightLimit):
    itemsCount = len(weights)
    maxValues = [[0 for j in range(weightLimit + 1)] for i in range(itemsCount + 1)]
    # i is the number of items we considered
    # j is the maxWeight we considered
    for i in range(1, itemsCount + 1):
        for j in range(weightLimit + 1):
            if j >= weights[i-1]:
                maxValues[i][j] = max(
                        maxValues[i-1][j-weights[i-1]] + values[i-1],
                        maxValues[i-1][j]
                        )
            else:
                maxValues[i][j] = maxValues[i-1][j]

    return maxValues[-1][-1]

assert knapsack([], [], 1) == 0
assert knapsack([1, 2], [3, 4], 0) == 0
assert knapsack([3, 4, 5], [2, 1, 3], 2) == 0
assert knapsack([1, 1, 1], [2, 3, 4], 2) == 7
assert knapsack([2, 3, 6], [5, 8, 9], 7) == 13
assert knapsack([2, 3, 6], [5, 3, 9], 7) == 9
assert knapsack([2, 8, 4, 5], [5, 7, 9, 8], 10) == 17
assert knapsack(list(range(1, 10)), list(range(10, 1, -1)), sum(range(1, 10))) == sum(range(10, 1, -1))
