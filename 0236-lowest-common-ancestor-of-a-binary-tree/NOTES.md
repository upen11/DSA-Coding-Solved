if(root.right == null)
return root.left;
​
if(root.left == null)
return root.right;
// if both are not null.
return root;
​
we have not written if (root.left != null) return left,
Because in the last condition we are checking if both are not null then return root.
​
This can also be written like
​
if(root.left != null && root.right != null)
return root;
if(root.left != null)
return root.left;
return root.right;