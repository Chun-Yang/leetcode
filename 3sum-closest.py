'''
- n^2 log(n)
- doubles (set): all pair combinations from input
- counts (dict): count of all numbers in input
                 this is used to determine feasibility
- sorted_nums (array): find the nearest number using binary search
                       for each pair, check feasibility
- closest_diff (number): save the closest difference
- closest_pair (pair): save the closest pair
- loop through doubles and find the closest pair
'''
