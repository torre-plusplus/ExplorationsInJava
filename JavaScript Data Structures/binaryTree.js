function NewTree() {
    
    var tree = {
        
        root : null,
        
        newNode : function (data, leftChild, rightChild) {
            var node = {
                data : data,
                left : leftChild,
                right : rightChild,
            }
            return node;   
            
        },
        
        addNode : function(data) {
            var sortedLocationFound = false;

            if (this.root == null) {
                this.root = this.newNode(data);
                sortedLocationFound = true;
            }
                        
            currentNode = this.root;
            while (!sortedLocationFound) {
                if(data <= currentNode.data) {
                    if (currentNode.left == null) {
                        currentNode.left = this.newNode(data);
                        sortedLocationFound = true;
                    }
                    else
                        currentNode = currentNode.left;
                }
                else if (data > currentNode.data) {
                    if (currentNode.right == null) {
                        currentNode.right = this.newNode(data);
                        sortedLocationFound = true;
                    }
                    else
                        currentNode = currentNode.right;
                }
                else
                    return "Duplicate data cannot be stored in a tree."
            }
            
            return "Data added successfully"
        },
        
        find : function(data) {
            if (this.root == null) 
                return "The tree is empty."
            currentNode = this.root;
            var dataFound = false;
            while(!dataFound) {
                if(data == currentNode.data) {
                    return currentNode;
                }
                else if (data < currentNode.data) {
                    if (currentNode.left == null)
                        return "Data not found";
                    else
                        currentNode = currentNode.left;
                }
                else
                    if (currentNode.right == null)
                        return "Data not found."
                    else
                        currentNode = currentNode.right;
            }
        },
        
        printInOrder : function() {
            var results = [];
            
            function printChildren (node) {
                if (node == null)
                    return;
                printChildren(node.left);
                results.push(node.data);
                printChildren(node.right);
            }
            
            printChildren(this.root);
            return results;
        },
        
        printNodes : function() {
            var results = [];
            
            function printChildren (node) {
                if (node == null)
                    return;
                results.push(node.data);
                printChildren(node.left);
                printChildren(node.right);
            }
            
            printChildren(this.root);
            return results;
        },
        
        findDepth : function() {
            var depth = 0;
            function seekDepth(node, tempDepth) {
                if (node == null)
                    return;
                tempDepth++;
                if (tempDepth > depth)
                    depth = tempDepth;
                seekDepth(node.left, tempDepth);
                seekDepth(node.right, tempDepth);
            }
            
            seekDepth(this.root, 0);
            
            return depth;
        },
        
        iterativePrint() {
            
            var currentNode = this.root;
            var stackArray = [currentNode];
            var results = [];
            
            while (stackArray.length > 0) {
                currentNode = stackArray.pop();
                
                results.push(currentNode.data);
                
                if (currentNode.right != null)
                    stackArray.push(currentNode.right)
                if (currentNode.left != null)
                    stackArray.push(currentNode.left)
            }
            
            return results;
        },
        
        findCommonAncestor(data1, data2) {
            var commonTree = [];
            
            var treeFound = false;
            var currentNode = this.root;
            
            while (!treeFound) {
                if (currentNode.data == data1 ||
                    currentNode.data == data2) {
                    commonTree.push(currentNode.data);
                    treeFound = true;
                }
                else if (currentNode.data > data1 && currentNode.data < data2) {
                    commonTree.push(currentNode.data);
                    treeFound = true;
                }
                else if (currentNode.data < data1 && currentNode.data > data2) {
                    commonTree.push(currentNode.data);
                    treeFound = true;
                }
                else if (currentNode.data > data1 && 
                    currentNode.data > data2) {
                    commonTree.push(currentNode.data);
                    currentNode = currentNode.left;
                }
                else 
//  catches (currentNode.data < data1 && currentNode.data < data2) 
                {
                    commonTree.push(currentNode.data);
                    currentNode = currentNode.right;
                }
                    
            }
            
            return commonTree;
            
        },
        
        treeToHeap : function (){
            
            var maxArray = [];
            function sortMax(currentNode) {
                if(currentNode == null)
                    return;
                
                sortMax(currentNode.right);
                maxArray.push(currentNode.data);
                sortMax(currentNode.left);
            }
            
            sortMax(this.root);
            
            function newHeapNode(index) {
                if (index === null && index != 0)
                    return null;
                
                var leftIndex = null;
                var rightIndex = null;
                if (maxArray.length > (2*index + 1))
                    leftIndex = 2 * index + 1;
                if (maxArray.length > (2*index + 2))
                    rightIndex = 2 * index + 2;
                
                if (leftIndex == null && rightIndex == null)
                    return null;
                else
                    return tree.newNode(maxArray[index], 
                                        newHeapNode(leftIndex), newHeapNode(rightIndex));
            }
            
            
            
            var heap = {
                root : newHeapNode(0)
            }
            
//            heap.root = newHeapNode(0);
            
            return heap;
        },
        
        //can be called if tree is out of balance.  Maintains binary tree structure by shifting root left or right and moving their child from their left/right to the former root's opposite.  Self-balancing would compare left and right side max depths and call the appropriate function, or call the function on each level.
        rotateRight : function() {
            tempNode = this.root;
            this.root = this.root.left;
            tempNode.left = this.root.right;
            this.root.right = tempNode;
            
        },
        
        rotateLeft : function() {
            tempNode = this.root;
            this.root = this.root.right;
            tempNode.right = this.root.left;
            this.root.left = tempNode;
        }
    }
    
    return tree;

}

var tree = new NewTree();
for (var i = 0; i < 32; i++)
    tree.addNode(Math.round(Math.random() * 100));

console.log(tree.printInOrder());
console.log(tree.findDepth());
console.log(tree.printNodes());
console.log(tree.iterativePrint().toString());

console.log(tree.treeToHeap())

