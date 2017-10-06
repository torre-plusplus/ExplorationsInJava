function NewHeap() {
    var heap = {
        root : null,
        
        newNode : function(data) {
            var node = {
                data : data,
                left : null,
                right : null
            }
            
            return node;
        },
        
        addNode : function(data) {
            
            var currentNode = this.newNode(data);
            var nodeAdded = false;
            if (this.root == null) {
                this.root = currentNode;
                nodeAdded = true;
            }
            
            
//            SWITCH TO RECURSION  (LOOK UP CODE FOR BALANCED TREE)
            while(!nodeAdded) {
                if (currentNode.data > this.root.data) {
                    var tempNode = this.root;
                    currentNode.left = this.root.left;
                    currentNode.right = this.root.right;
                    this.root = currentNode;
                    currentNode = tempNode;
                }
            }
        }
    }


}