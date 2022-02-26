# Name:

# Sources:
-

# Reflection:

Phase one and phase three are just the previous assignments. Thus it doesn't take long to get those set up. However, we had to make the method more general to accomodate this program. Hopefully if we ever need them again, we can just copy the files over. 

Phase two was hard. I have taken Discrete Maths and having read the GeeksForGeeks: Recursion, it was useful to think of this as a tree. The first node is the starting points, then from that node we have four branches of EAST/WEST/SOUTH/NORTH to choose from. Each branch will connect to a new node that is the location to the EAST/WEST/SOUTH/NORTH. The new node will also have these four branches. By this tree diagram, we have a lot of potential paths going from start to wherever according to the choice we made at each node. When we start the programs, the recursion run through each paths from top to bottom in a tree diagram. If the paths is a deadend, we abandon that and go to the next paths. 

Also, if I was implementing the iterative method, I would do the above: looping through each potential paths. By the tree above, we have exponential amount of paths, some are shorter than other, and some overlaps. 