import random

def sort(array):
    length = len(array)
    if length <= 1:
        return array

    less = []
    more = []
    equal = []

    pivotIndex = random.randint(0, len(array) - 1)
    pivot = array[pivotIndex]

    for i in array:
        if i < pivot:
            less.append(i)
        elif i > pivot:
            more.append(i)
        else:
            equal.append(i)

    return sort(less) + equal + sort(more)


assert sort([1,9,5,1,3,5,42,1,110,7,8,9,52,1,4,40,6,3]) == sorted([1,9,5,1,3,5,42,1,110,7,8,9,52,1,4,40,6,3])
