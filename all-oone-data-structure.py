# 1. Dict { string: pointerToAnElementInLinedList }
# 2. LinkedList small->large
# 3. value of EachNode is a set
#
# Inc:
# - check if exist
#   - not exist
#     - check if 1 exist in linked list
#       - no: create one with itself as a set
#       - yes: add itself into the set
#   - exist
#     - check value + 1 and next node
#       - next node is + 1, add to set
#       - not + 1, create a new Node
#     - check if we need to remove the previous node
