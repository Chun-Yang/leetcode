# Prepare for Interview

## Materials
- Thought Process
  - http://www.crackingthecodinginterview.com/uploads/6/5/2/8/6528028/handout_-_cracking_the_coding_skills.png
- Basic Algorithems
  - http://www.geeksforgeeks.org/fundamentals-of-algorithms/
- Facebook
  - https://www.interviewbit.com/search/?q=Facebook
  - http://www.geeksforgeeks.org/Facebook-topics-interview-preparation/

## Knowledge

### Algorithems
- merge sort
- heap sort
- quick sort
- selection sort
- insertion sort
- bubble sort
- radix sort
- couting sort
- bucket sort
- topological sort
- two pointer(multiple pointers) with (constrain / boundary condition / invariance)
- slow fast pointers / cycle detection
- dynamic programming
  - [?] knapsack http://www.geeksforgeeks.org/knapsack-problem/
- dfs
  - preorder
  - postorder
  - inorder
- bfs
- binary search
- backtracking
- greedy
- divide and counquer
- union find
- minimum cuts
- Hierholzer's algorithm (greedy)
- gcd
- reservoir sampling

### Data Structures
- array
- stack
- queue
- deque
- set
- hash table
- binary search tree
- red-black tree ( balanced binary search tree )
- spanning tree
- segment tree
- heap / priority queue (java PriorityQueue can have duplicates)
- linked list
- trie

### Tricks
- (x & (x-1)) remove last bit
- (x & (-x)) extract last bit
- (x ^ y) ^ y is x
- ~x + 1 get negative of the current number

### Basics
- regex: https://swtch.com/~rsc/regexp/regexp1.html

## Interview

### Intros
- more than 4 years building web applications
- build a converter to convert html to working react app with components as dependencies
- I design and build a custome enterprise content management software,
  we build a multi step form builder,
  its like a compiler that convert json like object into
  multi step form with validations and relationship constrains
  and the it team of our client provide the schema for the wizrds

### Approaches
- Listen and Ask: make sure I understand the questions
  - input format?
  - output format?
- Come up with a working plan: come up a plan first
- Improve: improve the plan using another algorithem
- Confirm: let the interviewer sign off my design
- Implementation plan: separte the algorithem in several parts and mark them.
- Implement
- Test
  - edge case
  - common case
- Debug

### Questions
- [tech] what is the biggest technical challenges you encourtered at facebook?
- [tech] which skill is most wanted in your day to day job?
  - algorithem design and development?
  - managing complexity in code?
  - engineer solutions to hard techinical problems?
  - communication skills?
- [tech] what were you doing recently, do you enjoy it and why?
- [culture] if you can give one advice to CEO, what would you say?
- [culture] which part excites you most working at facebook? and why?
  - technical challenges
  - meaning of work (connecting people)
  - learn new stuff.
  - work with smart people.
- [culture] what is the biggest technical mistake you made at facebook? how doe you
  feel about it and how does your manager feel about it?
- [culture] do people hangout after work? Or not?
- [culture] how does tech leadership work here? what happens when memebers have different
  opinions? Do you feel your opinion is respected? Or do you feel authority
  should be honored due to their experience?

### PLAN
- review 400 problems

- prepare for design interview

- prepare for experience/behavior interview
  - Talk about past projects, what YOU did and not what your team did
    - Designed a CMS engine that build multi-step and relational forms,
      build a table builder that can sort, search, select fields and flatten.
    - Build a general offline syncing package for ember data, it's a plugin and
      play package that works out of the box
    - Tune and rewrite SQL queries for a report generation feature on ruby on rails
      that speed the load time from more than 2 hours to less than 30 seconds
  - Be able to speak about Facebook products that excite you, is there a technical aspect you like about it?
    - Messagers. Frends suggestions feature.
    - I did not provide enough info for facebook, however I can find my friends
      somehow suggested there
  - Have examples of how you dealt with conflict in the workplace in the past
    - I try to figure out the ultimate goal we are trying to achieve together,
      this way it would reduce the friction and increse alignment
    - I have no problem with critics and will quickly accept them if the suggestions
      is better than my current plan.
    - I will try to suggest ideas to other people. I will try to explain the reasons
      instead of pushing for my agenda or my idea.
    - If I can not agree with my manager or project lead and I already explain
      the reasons for alternatives, I will just follow the decision and make
      the best out out it. (BYOB-CMS)
  - What was your toughest project and how did you handle it?
    CMS project
    - challenges:
      - technical challenges with constrains from ill configured database design
      - intense deadlines
      - main developer left project
      - multiple people on and off the project with size of team change over time
    - deal with it:
      - planning and change the estimate when new findings are found in the development process
      - do not burn myself, get the most results, not the most hours.
      - talk to project manager and let them know the problems
      - talk to the client, let them konw what to expect on each stage
      - always deliver
  - My mistakes:
    - take design and tasks as literal plan. I realized that I need to ask for
      the ultimate purpose of the tasks I was given.
    - I choose a non optimal way to do a task. It's hard to always choose the best
      solutions when you have limited undestanding and time.
      The client want to save mongo values with type an js does not have time.
      - one is to use custom objects
      - one is to use schema info and save it into db
        The lesson I learnt was that the more fundmental the change is,
        the more implication it will have.
        I thought the first one is the best solution since we only need to deal
        with new types. But it turns out it is complicated since its not a native
        type in js. And the tool we are using json-schemaform does not play
        well with objects as primitives
  - Be talkative and excited
  - There may be a light coding question that shouldn't take longer than 15-20 minutes. If the interviewer doesn't get to this, don't worry.

- prepare for an interview with an enterprise manager
  - I architected multiple applications
  - I lead teams of 2 to 5
  - Not just implement the design, try to think from first priciple
    and figure out what and how should I do to optimize the project as
    a whole.
  - No coding, but a chance to impress a manager and show off your knowledge
  - Have some questions about the enterprise team
    - examples of enterprise applications
    - tech stack
    - what are the challenges
    - How is the incentive mechemism set up? The reason I ask is I want to konw
      how are people motivated? Since people are shaped by incentives and metrics.
    - does the team convey the ultimate goal, try to align the goal with all
      people top to bottom, or the tasks are assigned level be level?
    - do you think developers have a good understanding of the requirements
  - The project I am working on CMS for one of the biggest company in the world
    - initial problem digging
    - solution proposal
    - implementation
    - lessons learnt
