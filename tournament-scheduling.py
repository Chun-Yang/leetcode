def tournamentScheduling(n):
    schedule = [1]
    currentN = 1
    while currentN < n:
        currentN *= 2
        newSchedule = []
        for rank in schedule:
            newSchedule.append(rank)
            newSchedule.append(currentN + 1 - rank)
        schedule = newSchedule

    return schedule

assert tournamentScheduling(1) == [1]
assert tournamentScheduling(2) == [1, 2]
assert tournamentScheduling(4) == [1, 4, 2, 3]
assert tournamentScheduling(8) == [1, 8, 4, 5, 2, 7, 3, 6]
assert tournamentScheduling(16) == [1, 16, 8, 9, 4, 13, 5, 12, 2, 15, 7, 10, 3, 14, 6, 11]
