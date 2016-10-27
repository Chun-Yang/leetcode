import random
class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.d = dict()
        self.l = list()


    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.d:
            return False
        else:
            self.l.append(val)
            self.d[val] = len(self.l) - 1
            return True


    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.d:
            index = self.d[val]
            del self.d[val]
            last = self.l.pop()
            # put the last in to the slot if the removed one is not the last one
            if index != len(self.d):
                self.l[index] = last
                self.d[last] = index
            return True
        else:
            return False


    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """
        return self.l[random.randrange(len(self.l))]



# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# obj.insert(0)
# obj.insert(1)
# print("obj.getRandom()", obj.getRandom())
# print("obj.getRandom()", obj.getRandom())
# print("obj.getRandom()", obj.getRandom())
# print("obj.getRandom()", obj.getRandom())
# print("obj.getRandom()", obj.getRandom())
# print("obj.getRandom()", obj.getRandom())
