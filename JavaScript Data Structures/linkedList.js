function LinkedList () {
    
    var list = {
        head : null,
        tail : null,

        addAtTail : function (elemData) {
            if (this.tail == null) {
                this.tail = this.newNode(elemData, null);
                this.head = this.tail;
            }
            else {
                var tempTail = this.tail;
                this.tail = this.newNode(elemData);
                tempTail.next = this.tail;
            }
        },

        addAtHead : function (elemData) {
            if (this.head == null) {
                this.head = this.newNode (elemData, null);
                this.tail = this.head;
            }
            else {
                var tempHead = this.head;
                this.head = this.newNode (elemData, tempHead);
            }
        },

        findByData : function(data) {
            if (this.head == null)
                return "The list is already empty."
            
            var found = false;
            var currentNode = this.head;
            while(!found) {
                if (currentNode.data === data)
                    return currentNode;
                if (currentNode.next == null)
                    return "Data not Found";
                else
                    currentNode = currentNode.next;
            }
            

        },

        deleteByData : function (data) {
            if (data == null) {
                return "Man cannot search for the undefined."
            }
            
            if (this.head == null)
                return "The list is already empty."
            
            if (data == this.head.data) {
                if(this.head == this.tail) {
                    this.head = null;
                    this.tail = null;
                    return "Data deleted.  The list is empty."
                }
                this.head = this.head.next;
                return "Data successfully deleted"
            }
            
            var currentNode = this.head;
            var found = false;
            while (!found) {
                if (currentNode.next.data == data) {
                    if (currentNode.next == this.tail){
                        currentNode.next = null;
                        this.tail = currentNode;
                        return "Data successfully deleted";
                    }
                    else {
                        currentNode.next = currentNode.next.next;
                        return "Data successfully deleted";
                    }
                }
                if (currentNode.next.next == null)
                    return "Data not Found";
                else
                    currentNode = currentNode.next;
            }

        },        

        newNode : function (aData, aNext) {
            var node = {
                data : aData,
                next : aNext,
            }
            return node;
        },
        
        nthFromEnd : function(data) {
            if (data == null)
                return "Cannot count space of nothing to the end";
            if (this.head === null)
                return "The list is empty";
            
            
            var currentNode = this.head;
            var endOfList = false;
            var nthFromEnd = 0;
            var dataFound = false;
            while (!endOfList) {
                if (currentNode.next == null)
                    endOfList = true;
                if (currentNode.data == data)
                    dataFound = true;
                if (dataFound)
                    nthFromEnd++;
                
                if(!endOfList)
                    currentNode = currentNode.next;
            }
            
            if (!dataFound)
                return "Data not found in list";
            else
                return nthFromEnd;
        }
    }

    return list;

}

var list = new LinkedList();

list.addAtTail("Nibbler");
list.addAtHead("Gusto");
list.addAtTail("Charlie");
list.addAtTail("MurphDog");
list.addAtTail("Obi");

console.log(list.findByData("Obi"));
console.log(list.findByData(1));
console.log(list.nthFromEnd("Nibbler"));
