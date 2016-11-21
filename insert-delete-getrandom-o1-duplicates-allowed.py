# TODO: is python list append O(1)?

# 1. a list []: keys
# 2. a dict of sets. each set contain indexes in the list that contain the values
import random

class RandomizedCollection(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.l = []
        self.d = {}

    def insert(self, val):
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        self.l.append(val)
        index = len(self.l) - 1
        if val in self.d:
            self.d[val].add(index)
            return False
        else:
            self.d[val] = set([index])
            return True


    def remove(self, val):
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.d:
            return False

        indexToRemove = self.d[val].pop()
        if not self.d[val]:
            del self.d[val]

        if indexToRemove == len(self.l) - 1:
            # remove the value
            self.l.pop()
        else:
            # remove the last value
            value = self.l.pop()
            self.d[value].remove(len(self.l))
            # move the last element to the current element if not the last element
            self.l[indexToRemove] = value
            self.d[value].add(indexToRemove)
        return True

    def getRandom(self):
        """
        Get a random element from the collection.
        :rtype: int
        """
        return self.l[random.randrange(len(self.l))]


# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
