we will have head and tail nodes.
we will put new nodes between them, so it will be easy to track.
​
For every operation on a node we will delete it from the Linked List and add to the front after the head.
​
if capacity is reached then we will remove tail prev node and add the new node after head.
​
We will also update the map values because the new address will be different even if we getting the node or updating it, because we are deleting and inserting it again.
​